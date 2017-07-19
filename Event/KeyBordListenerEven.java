package Event;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;

import VideoPlayer.Main.PlayerMain;



/**
 * Key board listener
 * @author ganyee
 *
 */
public class KeyBordListenerEven {

	public void keyBordListner(){
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			@Override
			public void eventDispatched(AWTEvent event) {
				// TODO Auto-generated method stub
				if(((KeyEvent)event).getID()==KeyEvent.KEY_PRESSED){
					switch (((KeyEvent)event).getKeyCode()) {
					case KeyEvent.VK_RIGHT:{
						int a = PlayerMain.getFrame().getSlider().getValue();
						PlayerMain.getFrame().getSlider().setValue(a);
						PlayerMain.forword((float)(((PlayerMain.getFrame().getProgressBar().getPercentComplete() * PlayerMain.getFrame().getProgressBar().getWidth() + 10)) / PlayerMain.getFrame().getProgressBar().getWidth()));
					}
						break;
					case KeyEvent.VK_LEFT:{
						PlayerMain.jumpTo((float)((PlayerMain.getFrame().getProgressBar().getPercentComplete() * PlayerMain.getFrame().getProgressBar().getWidth() - 5) / PlayerMain.getFrame().getProgressBar().getWidth()));
					}
						break;

					case KeyEvent.VK_UP:{
						PlayerMain.getFrame().getSlider().setValue(PlayerMain.getFrame().getSlider().getValue() + 1);
						PlayerMain.getFrame().getSlider().setValue(PlayerMain.getFrame().getSlider().getValue());
//						PlayerMain.getFrame().getVolumLabel().setText("" + PlayerMain.getFrame().getVolumControlerSlider().getValue());
					}
						break;
					case KeyEvent.VK_DOWN:
						PlayerMain.getFrame().getSlider().setValue(PlayerMain.getFrame().getSlider().getValue() - 1);
						PlayerMain.getFrame().getSlider().setValue(PlayerMain.getFrame().getSlider().getValue());
						break;
					case KeyEvent.VK_SPACE:{
						if(PlayerMain.getFrame().getMediaPlayer().isPlaying()){
							PlayerMain.pause();
							PlayerMain.getFrame().getBtnPause().setText(PlayerMain.getFrame().getBtnPause().getText());
						}
						else{
							PlayerMain.play();
							PlayerMain.getFrame().getBtnPause().setText(PlayerMain.getFrame().getBtnPause().getText());
						}
					}
						break;
					}
				}
			}
		}, AWTEvent.KEY_EVENT_MASK);
	}
}

