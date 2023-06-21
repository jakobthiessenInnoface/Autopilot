package gid01.aid00101;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import io.adminshell.aas.v3.dataformat.SerializationException;
import io.adminshell.aas.v3.dataformat.aasx.AASXSerializer;
import io.adminshell.aas.v3.dataformat.aasx.InMemoryFile;
import io.adminshell.aas.v3.dataformat.json.JsonSerializer;

public class WindowWrite extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel lAssetId = new JLabel("Asset ID");
	JLabel lAssetIdShort = new JLabel("Asset ID Short");
	JLabel lAasId = new JLabel("AAS ID");
	JLabel lAasIdShort = new JLabel("AAS ID Short");
	JLabel lNameplateId = new JLabel("Nameplate ID");
	JLabel lIdentificationId = new JLabel("Identification ID");

	JLabel lManufacturerName = new JLabel("Manufacturer Name");
	JLabel lManufacturerProductDesignation = new JLabel("Manufacturer Product Designation");
	JLabel lNameOfSupplier = new JLabel("Name Of Supplier");
	JLabel lTypThumbnail = new JLabel("TypThumbnail");

	JTextField tfAssetId = new JTextField();
	JTextField tfAssetIdShort = new JTextField();
	JTextField tfAasId = new JTextField();
	JTextField tfAasIdShort = new JTextField();
	JTextField tfNameplateId = new JTextField();
	JTextField tfIdentificationId = new JTextField();

	JTextField tfManufacturerName = new JTextField();
	JTextField tfManufacturerProductDesignation = new JTextField();
	JTextField tfNameOfSupplier = new JTextField();
	JTextField tfTypThumbnail = new JTextField();

	JButton button = new JButton("Apply");

	public WindowWrite() {
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

	protected void initWindow() {

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					buttonApplyClicked();
				} catch (IOException | SerializationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		tfAssetId.setBounds(100, 50, 400, 25);
		tfAssetIdShort.setBounds(100, 100, 200, 25);
		tfAasId.setBounds(100, 200, 400, 25);
		tfAasIdShort.setBounds(100, 250, 200, 25);
		tfNameplateId.setBounds(100, 350, 400, 25);
		tfIdentificationId.setBounds(100, 400, 400, 25);
		tfManufacturerName.setBounds(250, 500, 400, 25);
		tfManufacturerProductDesignation.setBounds(250, 530, 400, 25);
		tfNameOfSupplier.setBounds(250, 560, 400, 25);
		tfTypThumbnail.setBounds(250, 590, 400, 25);

		lAssetId.setBounds(5, 50, 90, 25);
		lAssetIdShort.setBounds(5, 100, 90, 25);
		lAasId.setBounds(5, 200, 90, 25);
		lAasIdShort.setBounds(5, 250, 90, 25);
		lNameplateId.setBounds(5, 350, 90, 25);
		lIdentificationId.setBounds(5, 400, 90, 25);
		lManufacturerName.setBounds(5, 500, 240, 25);
		lManufacturerProductDesignation.setBounds(5, 530, 240, 25);
		lNameOfSupplier.setBounds(5, 560, 240, 25);
		lTypThumbnail.setBounds(5, 590, 240, 25);

		button.setBounds(300, 700, 100, 30);

		this.getContentPane().add(lAssetId);
		this.getContentPane().add(tfAssetId);
		this.getContentPane().add(lAssetIdShort);
		this.getContentPane().add(tfAssetIdShort);

		this.getContentPane().add(lAasId);
		this.getContentPane().add(tfAasId);
		this.getContentPane().add(lAasIdShort);
		this.getContentPane().add(tfAasIdShort);

		this.getContentPane().add(lNameplateId);
		this.getContentPane().add(tfNameplateId);
		this.getContentPane().add(lIdentificationId);
		this.getContentPane().add(tfIdentificationId);

		this.getContentPane().add(lManufacturerName);
		this.getContentPane().add(tfManufacturerName);
		this.getContentPane().add(lManufacturerProductDesignation);
		this.getContentPane().add(tfManufacturerProductDesignation);
		this.getContentPane().add(lNameOfSupplier);
		this.getContentPane().add(tfNameOfSupplier);
		this.getContentPane().add(lTypThumbnail);
		this.getContentPane().add(tfTypThumbnail);

		this.getContentPane().add(button);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void buttonApplyClicked() throws FileNotFoundException, IOException, SerializationException {
		String assetId = tfAssetId.getText();
		String assetIdShort = tfAssetIdShort.getText();
		String aasId = tfAasId.getText();
		String aasIdShort = tfAssetIdShort.getText();
		String nameplateId = tfNameplateId.getText();
		String identificationId = tfIdentificationId.getText();
		String manufacturerName = tfManufacturerName.getText();
		String manufacturerProductDesignation = tfManufacturerProductDesignation.getText();
		String nameOfSupplier = tfNameOfSupplier.getText();
		String typThumbnail = tfTypThumbnail.getText();

		if (assetId.isEmpty()) {
			assetId = "HTTP://PK.FESTO.COM/3S7PM0CP4BD";
		}
		if (assetIdShort.isEmpty()) {
			assetIdShort = "FPK_3s7plfdrs35";
		}
		if (aasId.isEmpty()) {
			aasId = "smart.festo.com/demo/aas/1/1/454576463545648365874";
		}
		if (aasIdShort.isEmpty()) {
			aasIdShort = "Festo_3S7PM0CP4BD";
		}
		if (nameplateId.isEmpty()) {
			nameplateId = "www.company.com/ids/sm/4343_5072_7091_3242";
		}
		if (identificationId.isEmpty()) {
			identificationId = "www.company.com/ids/sm/6563_5072_7091_4267";
		}
		if (manufacturerName.isEmpty()) {
			manufacturerName = "Festo Manufacturer AG & Co. KG";
		}
		if (manufacturerProductDesignation.isEmpty()) {
			manufacturerProductDesignation = "OVEL Vacuum generator";
		}
		if (nameOfSupplier.isEmpty()) {
			nameOfSupplier = "Festo Supplier AG & Co. KG";
		}
		if (typThumbnail.isEmpty()) {
			typThumbnail = "aasx/files/MyFile2.pdf";
		}

		JtNameplate jtNameplate = new JtNameplate(nameplateId);
		jtNameplate.setManufacturerName(manufacturerName);
		jtNameplate.setManufacturerProductDesignation(manufacturerProductDesignation);
		jtNameplate.buildElements();
		JtIdentification jtIdentification = new JtIdentification(identificationId);
		jtIdentification.setNameOfSupplier(nameOfSupplier);
		jtIdentification.setTypThumbnail(typThumbnail);
		jtIdentification.buildElements();
		JtAsset jtAsset = new JtAsset(assetId, assetIdShort, "en", "de");
		JtAAS jtAas = new JtAAS(aasId, aasIdShort, jtAsset, jtNameplate, jtIdentification);
		JtAAS jtAas2 = new JtAAS("myAASId", "myAASIdShort", jtAsset, jtNameplate, jtIdentification);

		JtEnv env = new JtEnv(jtAsset, jtAas, jtAas2, jtNameplate, jtIdentification);
		JsonSerializer jsonSerializer = new JsonSerializer();
		AASXSerializer aasxSerializer = new AASXSerializer();

		JFileChooser aasxChooser = new JFileChooser();
		JFileChooser jsonChooser = new JFileChooser();

		File dir = new File(
				"C:\\Users\\jakob.thiessen\\OneDrive - INNOFACE AG\\Projekte\\Autopilot\\AASX\\examples\\20230616");
		aasxChooser.setCurrentDirectory(dir);
		jsonChooser.setCurrentDirectory(dir);

		int jsonReturnValue = jsonChooser.showOpenDialog(null);
		File jsonFile = null;
		if (jsonReturnValue == JFileChooser.APPROVE_OPTION) {
			jsonFile = jsonChooser.getSelectedFile();
		}

		int aasxReturnValue = aasxChooser.showOpenDialog(null);
		File aasxFile = null;
		if (aasxReturnValue == JFileChooser.APPROVE_OPTION) {
			aasxFile = aasxChooser.getSelectedFile();
		}

		try {
			PrintWriter pw = new PrintWriter(jsonFile);
			byte[] fileContent = Files
					.readAllBytes(Paths.get("C:\\Users\\jakob.thiessen\\Downloads\\54600_Datenblatt_de.pdf"));
			InMemoryFile inMemoryFile = new InMemoryFile(fileContent, typThumbnail);
			List<InMemoryFile> fileList = new ArrayList<InMemoryFile>();
			fileList.add(inMemoryFile);
			ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
			OutputStream os = new FileOutputStream(aasxFile);
			aasxSerializer.write(env.get(), fileList, byteArrayOS);
			byteArrayOS.toByteArray();
			byteArrayOS.writeTo(os);
			os.close();
			pw.print(jsonSerializer.write(env.get()));
			pw.close();
		} finally {
		}
		
		
//		try {
//			PrintWriter pw = new PrintWriter(jsonFile);
//			try {
//				try {
//					byte[] fileContent = Files
//							.readAllBytes(Paths.get("C:\\Users\\jakob.thiessen\\Downloads\\54600_Datenblatt_de.pdf"));
//					InMemoryFile inMemoryFile = new InMemoryFile(fileContent, "aasx/MyFile2.pdf");
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				List<InMemoryFile> fileList = new ArrayList<InMemoryFile>();
//				fileList.add(inMemoryFile);
//				ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
//				OutputStream os = new FileOutputStream(aasxFile);
//				try {
//					aasxSerializer.write(env.get(), fileList, byteArrayOS);
//					byteArrayOS.toByteArray();
//					byteArrayOS.writeTo(os);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} finally {
//					try {
//						os.close();
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//
//				pw.print(jsonSerializer.write(env.get()));
//			} catch (SerializationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			pw.close();
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}
}
