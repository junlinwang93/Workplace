package GobangGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Gobang extends JFrame{
	/**
	 * @author Junlin Wang
	 */
	private static final long serialVersionUID = -2748054483582261121L;
	GobangPad Pad=new GobangPad();
	private void handleEvents() {
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
 
			@Override
			public void windowClosing(WindowEvent arg0) {
				int result = JOptionPane.showConfirmDialog(Gobang.this, "Are you sure to quit?",
				        "alert", JOptionPane.OK_CANCEL_OPTION);
				System.out.println(result);
				if (result == 0)
					System.exit(0);
				setVisible(true);
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	public Gobang() {
		super("Gobang Game");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container c = getContentPane();
		setSize(920,880);
		c.add(Pad);
		handleEvents();
		setVisible(true); 
	}
	
	public static void main(String[] args) {		
        new Gobang();
        
    }
	 
}
