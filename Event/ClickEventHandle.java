package Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import FileUtils.AnnotatedObj;
import FileUtils.FileUtils;
import VideoPlayer.Main.PlayerMain;
import VideoPlayer.Window.AnnotationWin;

public class ClickEventHandle implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AnnotationWin.saveAnnotation();
	
	}

}
