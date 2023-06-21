package gid01.aid00101;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import io.adminshell.aas.v3.dataformat.DeserializationException;
import io.adminshell.aas.v3.dataformat.SerializationException;
import io.adminshell.aas.v3.dataformat.json.JsonDeserializer;
import io.adminshell.aas.v3.dataformat.json.JsonSerializer;
import io.adminshell.aas.v3.model.impl.DefaultAssetAdministrationShellEnvironment;

public class WindowSelection extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JRadioButton rbWrite = new JRadioButton("Write");
	JRadioButton rbRead = new JRadioButton("Read");
	JRadioButton rbConvertTo30 = new JRadioButton("Convert");
	JButton button = new JButton("Next");

	public WindowSelection() {
		this.getContentPane().setLayout(null);

		this.initWindow();

		this.addWindowListener(new WindowListener() {

			public void windowClosed(WindowEvent arg0) {

			}

			public void windowActivated(WindowEvent e) {

			}

			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
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

	protected void initWindow() {

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					buttonNextClicked();
				} catch (InvalidFormatException | IOException | DeserializationException | SerializationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		button.setBounds(300, 700, 100, 30);
		rbWrite.setBounds(10, 10, 200, 20);
		rbRead.setBounds(10, 110, 200, 20);
		rbConvertTo30.setBounds(10,210,200,20);

		this.getContentPane().add(button);
		this.getContentPane().add(rbWrite);
		this.getContentPane().add(rbRead);
		this.getContentPane().add(rbConvertTo30);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void buttonNextClicked() throws InvalidFormatException, IOException, DeserializationException, SerializationException {
		WindowWrite wWrite = new WindowWrite();
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		if (rbWrite.isSelected()) {
			wWrite.setVisible(Boolean.TRUE);
		} else if (rbRead.isSelected()) {

			JFileChooser chooser = new JFileChooser();

			File dir = new File(
					"C:\\Users\\jakob.thiessen\\OneDrive - INNOFACE AG\\Projekte\\Autopilot\\AASX\\examples\\20230616");
			chooser.setCurrentDirectory(dir);

			int returnValue = chooser.showOpenDialog(null);

			File file = null;
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
			}

			JsonDeserializer jsonDeserializer = new JsonDeserializer();
			JsonSerializer jsonSerializer = new JsonSerializer();
			DefaultAssetAdministrationShellEnvironment env = (DefaultAssetAdministrationShellEnvironment) jsonDeserializer
					.read(file);
			WindowRead wRead = new WindowRead(jsonSerializer.write(env));
			wRead.setVisible(Boolean.TRUE);
		} else if (rbConvertTo30.isSelected()) {
			WindowConvert wConvert = new WindowConvert();
			wConvert.setVisible(Boolean.TRUE);
		}
	}
}
