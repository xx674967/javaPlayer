package Event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import VideoPlayer.Main.PlayerMain;
import VideoPlayer.Window.AnnotationWin;

public class MyWindowEventHandle implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if(PlayerMain.file != null){
            int exi = JOptionPane.showConfirmDialog (null, "Save AnnotatedInfo£¿", "Confirm Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (exi == JOptionPane.YES_OPTION)
            {
           	 AnnotationWin.saveAnnotation();
           	 System.exit (0);
            }
            else if(exi == JOptionPane.NO_OPTION)
            {
           	 System.exit (0);
            }else{
           	 return;
            }
		}else{
			int exi = JOptionPane.showConfirmDialog (null, "Exit VideoAnnotationTool£¿", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (exi == JOptionPane.YES_OPTION){
				System.exit (0);
			}else{
				return;
			}
		}

         }
	

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
