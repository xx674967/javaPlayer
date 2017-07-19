package VideoPlayer.Window;
import javax.swing.ImageIcon;

import VideoPlayer.Main.PlayerMain;
import uk.co.caprica.vlcj.binding.internal.libvlc_logo_position_e;
import uk.co.caprica.vlcj.player.Logo;

/**
 * A test for add logo to video
 * @author ganyee
 *
 */
public class MyLogo {
	//ImageIcon xx233 = new ImageIcon(getClass().getResource("/icon/233.png"));
	private Logo logo = Logo.logo()
			.file("/icon/computer.png")
			.position(libvlc_logo_position_e.top_left)
			.opacity(0.2f)
			.enable();

	public Logo getLogo() {
		
		return logo;
	}
	
	
}
