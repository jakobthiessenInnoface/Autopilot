package gid01.aid00101;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.adminshell.aas.v3.dataformat.DeserializationException;
import io.adminshell.aas.v3.dataformat.SerializationException;
import io.adminshell.aas.v3.dataformat.aasx.AASXDeserializer;
import io.adminshell.aas.v3.dataformat.aasx.AASXSerializer;
import io.adminshell.aas.v3.dataformat.aasx.InMemoryFile;
import io.adminshell.aas.v3.model.impl.DefaultAssetAdministrationShellEnvironment;

public class WindowConvert extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5085369360635392482L;
	private File file20 = null;
	private File file30 = null;
	private JLabel lPathToV20 = new JLabel("Select 2.0 File");
	private JLabel lPathToV30 = new JLabel("Select 3.0 File");
	private JButton bPathTo20 = new JButton("Select File");
	private JButton bPathTo30 = new JButton("Select File");
	private JButton bConvert = new JButton("Convert");
	private File dir = new File(
			"C:\\Users\\jakob.thiessen\\OneDrive - INNOFACE AG\\Projekte\\Autopilot\\AASX\\examples\\20230616");
	private JFileChooser chooser = new JFileChooser();

	public WindowConvert() {
		this.chooser.setCurrentDirectory(this.dir);
		bPathTo20.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				buttonPathTo20Clicked();
			}

		});

		bPathTo30.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				buttonPathTo30Clicked();
			}

		});
		
		bConvert.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					buttonConvertClicked();
				} catch (InvalidFormatException | IOException | DeserializationException | SerializationException e) {
					e.printStackTrace();
				}
			}

		});

		this.getContentPane().setLayout(null);

		this.initWindow();

		this.addWindowListener(new WindowListener() {

			public void windowClosed(WindowEvent arg0) {

			}

			public void windowActivated(WindowEvent e) {

			}

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowDeactivated(WindowEvent e) {

			}

			public void windowDeiconified(WindowEvent e) {

			}

			public void windowIconified(WindowEvent e) {

			}

			public void windowOpened(WindowEvent e) {

			}

		});

	}

	public void buttonPathTo20Clicked() {
		int returnValue = this.chooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			this.file20 = this.chooser.getSelectedFile();
			this.bPathTo20.setText(this.file20.getPath());
			this.bPathTo20.setToolTipText(this.file20.getPath());
		}
	}

	public void buttonPathTo30Clicked() {
		int returnValue = this.chooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			this.file30 = this.chooser.getSelectedFile();
			this.bPathTo30.setText(this.file30.getPath());
			this.bPathTo30.setToolTipText(this.file30.getPath());
		}
	}

	public void buttonConvertClicked() throws InvalidFormatException, IOException, DeserializationException, SerializationException {
		FileInputStream fileInputStream = new FileInputStream(this.file20);
		AASXDeserializer aasxDeserializer = new AASXDeserializer(fileInputStream);
		AASXSerializer aasxSerializer = new AASXSerializer();
		DefaultAssetAdministrationShellEnvironment aasxEnv = (DefaultAssetAdministrationShellEnvironment) aasxDeserializer.read();
		//byte[] fileContent = Files
		//		.readAllBytes(Paths.get("C:\\Users\\jakob.thiessen\\Downloads\\54600_Datenblatt_de.pdf"));
		//InMemoryFile inMemoryFile = new InMemoryFile(fileContent, "aasx/files/MyFile2.pdf");
		List<InMemoryFile> fileList = new ArrayList<InMemoryFile>();
		//fileList.add(inMemoryFile);
		ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
		OutputStream os = new FileOutputStream(this.file30);
		aasxSerializer.write(aasxEnv, fileList, byteArrayOS);
		byteArrayOS.toByteArray();
		byteArrayOS.writeTo(os);
		os.close();
	}

	protected void initWindow() {
		this.lPathToV20.setBounds(5, 10, 200, 20);
		this.bPathTo20.setBounds(210, 10, 200, 20);
		this.lPathToV30.setBounds(5, 70, 200, 20);
		this.bPathTo30.setBounds(210, 70, 200, 20);
		this.bConvert.setBounds(5,150,100,30);

		this.getContentPane().add(this.bPathTo20);
		this.getContentPane().add(this.lPathToV20);
		this.getContentPane().add(this.bPathTo30);
		this.getContentPane().add(this.lPathToV30);
		this.getContentPane().add(this.bConvert);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
