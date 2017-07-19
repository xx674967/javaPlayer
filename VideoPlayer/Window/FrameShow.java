package VideoPlayer.Window;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;

public class FrameShow {

	
	/**
	 * frame�еĿؼ�����Ӧframe��С���ı��Сλ�ú�����
	 * @param frame Ҫ���ƵĴ���
	 * @param proportion ��ǰ��ԭʼ�ı���
	 */
	public static void modifyComponentSize(JFrame frame,float proportionW,float proportionH){
		
		try 
		{
			Component[] components = frame.getRootPane().getContentPane().getComponents();
			for(Component co:components)
			{
//				String a = co.getClass().getName();//��ȡ��������
//				if(a.equals("javax.swing.JLabel"))
//				{
//				}
				float locX = co.getX() * proportionW;
				float locY = co.getY() * proportionH;
				float width = co.getWidth() * proportionW;
				float height = co.getHeight() * proportionH;
				co.setLocation((int)locX, (int)locY);
				co.setSize((int)width, (int)height);
				int size = (int)(co.getFont().getSize() * proportionH);
				Font font = new Font(co.getFont().getFontName(), co.getFont().getStyle(), size);
				co.setFont(font);
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
}
