package gid01.aid00101;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WindowRead extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5085369360635392482L;
	JTextArea taOutput = new JTextArea();
	JScrollPane scroll = new JScrollPane(taOutput);

	public WindowRead(String text) {
		this.taOutput.setText(text);
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

	protected void initWindow() 
	{
		//this.taOutput.setBounds(5, 5, 800, 1200);
		this.scroll.setBounds(5, 5, 500, 1000);
		//this.getContentPane().add(taOutput);
		this.getContentPane().add(this.scroll);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
