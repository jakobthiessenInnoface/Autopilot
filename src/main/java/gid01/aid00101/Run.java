package gid01.aid00101;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import io.adminshell.aas.v3.dataformat.DeserializationException;
import io.adminshell.aas.v3.dataformat.SerializationException;
import io.adminshell.aas.v3.dataformat.json.JsonDeserializer;
import io.adminshell.aas.v3.dataformat.json.JsonSerializer;
import io.adminshell.aas.v3.model.impl.DefaultAssetAdministrationShellEnvironment;

public class Run {
	
	public static void read() {
		
		JFileChooser chooser = new JFileChooser();
		
		File dir = new File("C:\\Users\\jakob.thiessen\\OneDrive - INNOFACE AG\\Projekte\\Autopilot\\AASX\\examples");
		chooser.setCurrentDirectory(dir);
		
		
		int returnValue = chooser.showOpenDialog( null ) ;
		
		 File file = null;
		 if( returnValue == JFileChooser.APPROVE_OPTION ) {
		        file = chooser.getSelectedFile() ;
		 }
		 
		JsonDeserializer deserializer = new JsonDeserializer();
		JsonSerializer serializer = new JsonSerializer();
		try {
			DefaultAssetAdministrationShellEnvironment env = (DefaultAssetAdministrationShellEnvironment) deserializer.read(file);
			System.out.println(serializer.write(env));
		} catch (FileNotFoundException | DeserializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main( String args[] ) {
		WindowSelection aw2 = new WindowSelection();
		aw2.setBounds(10,10,420,180);
		aw2.setVisible(Boolean.TRUE);
//		AppWindow theAppWindow = new AppWindow();
//		theAppWindow.setBounds(10, 10, 420, 180);
//		theAppWindow.setVisible(Boolean.TRUE);
	}
}
