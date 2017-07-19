package VideoPlayer.Window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicButtonUI; 














import Event.KeyBordListenerEven;
import Event.MyMouseListener;
import Event.MyWindowEventHandle;
import FileUtils.AnnotatedObj;
import FileUtils.FileUtils;
import VideoPlayer.Main.PlayerMain;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import java.awt.Font;

public class Window extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 131564881844443270L;
	private JPanel contentPane;	//顶层容器，整个播放页面的容器
	private JMenuBar menuBar;	//菜单栏
	private JPanel panel;	//控制区域容器
	private JProgressBar progress;	//进度条
	private JPanel controlPanel;	//控制按钮容器
	private JButton btnPause;	//控制按钮，停止、播放、暂停
	private JSlider slider;		//声音控制块
	private JPanel progressTimePanel;
	private JButton listButton;
	private KeyBordListenerEven kble;
	private static AnnotationWin annotation;
	private JButton FileBtn;
	private JButton ExitBtn;
	private JButton HelpBtn;
	private ImageIcon xx233;
	private ImageIcon xx322;
	
	
	
	EmbeddedMediaPlayerComponent playerComponent;	//媒体播放器组件
	
	
	//新的swing风格
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//设计按钮方法
	private JButton createBtn(String text, ImageIcon icon) {
		JButton btn = new JButton(text, icon);
		btn.setUI(new BasicButtonUI());// 恢复基本视觉效果
		btn.setPreferredSize(new Dimension(80, 27));// 设置按钮大小
		btn.setContentAreaFilled(false);// 设置按钮透明
		btn.setFont(new Font("粗体", Font.PLAIN, 15));// 按钮文本样式
		btn.setMargin(new Insets(0, 0, 0, 0));// 按钮内容与边框距离
		btn.addMouseListener(new MyMouseListener(this));
		return btn;
	}
	

	//MainWindow构造方法，创建视屏播放的主界面
	public Window(){
		setLookAndFeel(); 
		annotation = new AnnotationWin();
		setTitle("   VideoAnnotationTool  ");
		
		addWindowListener(new MyWindowEventHandle(){
	
		});
		
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				if(annotation.getFlag() == 0){
					annotation.setVisible(false);
					annotation.setBounds(PlayerMain.getFrame().getX() + PlayerMain.getFrame().getWidth() - 15, PlayerMain.getFrame().getY(),550,PlayerMain.getFrame().getHeight());
				}
			}
			@Override
			public void componentResized(ComponentEvent e) {
				
				if(annotation.getFlag() == 0 && !PlayerMain.getFrame().getMediaPlayer().isFullScreen()){
					annotation.setVisible(true);
					if(Math.abs(PlayerMain.getFrame().getWidth() - Toolkit.getDefaultToolkit().getScreenSize().width ) <= 20){
						annotation.setBounds((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 550), 0,550,PlayerMain.getFrame().getHeight());
						annotation.setAlwaysOnTop(true);
					}
					else
						annotation.setBounds(PlayerMain.getFrame().getX() + PlayerMain.getFrame().getWidth() - 15, PlayerMain.getFrame().getY(),550,PlayerMain.getFrame().getHeight());
				}
				
			}
		});

		
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(75,110,927,652);
		//键盘事件
		kble = new KeyBordListenerEven();
		kble.keyBordListner();
		//

		ImageIcon iconTitle = new ImageIcon(getClass().getResource("/icon/computer.png"));
		setIconImage(iconTitle.getImage());
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		
		/*视频播放窗口中的菜单栏*/
		menuBar=new JMenuBar();
		
		// icon test!
//		 menuBar.setLayout(new FlowLayout(40, 4, 0)); 
//		 ImageIcon xxx1=new ImageIcon("./icon/1.png");
//		 JButton editBtn=new JButton("Edit",xxx1);
//		 menuBar.add(editBtn);
		ImageIcon iconFile = new ImageIcon(getClass().getResource("/icon/1.png"));
		ImageIcon iconExit = new ImageIcon(getClass().getResource("/icon/2.png"));
		ImageIcon iconHelp = new ImageIcon(getClass().getResource("/icon/4.png"));
		FileBtn=createBtn("File", iconFile);
		
	
		 menuBar.add(FileBtn);
		 
		 ExitBtn=createBtn("Exit", iconExit);
		 menuBar.add(ExitBtn);
		 HelpBtn=createBtn("Help", iconHelp);
		 menuBar.add(HelpBtn);
		 
		 
		 
		 
		 //icon test end!	
		setJMenuBar(menuBar);
		
//		mnFile=new JMenu("File");		//设置菜单名
//		mnFile.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
//		menuBar.add(mnFile);
//		mnSetting=new JMenu("Source");
//		mnSetting.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
//		menuBar.add(mnSetting);
//		mnHelp=new JMenu("Help");
//		mnHelp.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
//		menuBar.add(mnHelp);
//		
//		mnOpenVideo =new JMenuItem("OpenFile");	//设置文件菜单子目录打开文件
//		mnOpenVideo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
//		mnFile.add(mnOpenVideo);
//		
//		mnExit =new JMenuItem("Quit");	//设置文件菜单子目录退出
//		mnExit.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
//		mnFile.add(mnExit);
		
		
		//自动化页面大小--全屏
//				int fraWidth = this.getWidth();//frame的宽
//				int fraHeight = this.getHeight();//frame的高
//				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//				int screenWidth = screenSize.width;
//				int screenHeight = screenSize.height;
//				this.setSize(screenWidth, screenHeight);
//				this.setLocation(0, 0);
//				float proportionW = screenWidth/fraWidth;
//				float proportionH = screenHeight/fraHeight;
//				
//				FrameShow.modifyComponentSize(this, proportionW,proportionH);
//				this.toFront();
		
		
		
		
		
		
		
		//打开文件
		FileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					PlayerMain.openVideo();
					AnnotatedObj xx = null;
					xx=FileUtils.readFile(PlayerMain.file);
					if(xx != null){
						AnnotationWin.showAnnotation(xx);
									}

					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		//退出
		ExitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CloseWin();
			}
		});
		
		
		HelpBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "If you have any questions, please contact：497530437@qq.com","Help",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		
		/*视屏窗口中播放界面部分*/
		JPanel videoPane=new JPanel();
		contentPane.add(videoPane, BorderLayout.CENTER);
		videoPane.setLayout(new BorderLayout(0,0));
		
		
		playerComponent=new EmbeddedMediaPlayerComponent();
		videoPane.add(playerComponent,BorderLayout.CENTER);//修改进度条- - - - -
		
		
		/*视屏窗口中控制部分
		 * videoPane的SOUTH继续增加一个面板，为了让进度条变上去
		 * 
		 * */
		
		
		
		panel=new JPanel();		//实例化控制区域容器
		videoPane.add(panel,BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		progressTimePanel = new JPanel();
		
		panel.add(progressTimePanel,BorderLayout.NORTH);
		progressTimePanel.setLayout(new BorderLayout(0, 0));
		
//		currentLabel = new JLabel("00：00");
//		progressTimePanel.add(currentLabel, BorderLayout.WEST);
//		
//		totalLabel = new JLabel("02：13");
//		progressTimePanel.add(totalLabel, BorderLayout.EAST);
		
		
		//添加进度条
		progress=new JProgressBar();	
		progressTimePanel.add(progress,BorderLayout.SOUTH);		
		
		
		
		
		//progressPanel=new JPanel();	//实例化进度条容器
		//panel.add(progressPanel, BorderLayout.NORTH);

		//panel.add(progress,BorderLayout.NORTH);
		progress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){		//点击进度条调整视屏播放进度
				int x=e.getX();
				PlayerMain.jumpTo((float)x/progress.getWidth());
			}
		});
		progress.setStringPainted(true);
		
		
//		controlPanel=new JPanel();		//实例化控制按钮容器
//		panel.add(controlPanel,BorderLayout.SOUTH);
		
		controlPanel = new JPanel();
		controlPanel.getLayout();
		panel.add(controlPanel, BorderLayout.SOUTH);
	
		
		
		
		
		//添加停止按钮
		ImageIcon btnQ = new ImageIcon(getClass().getResource("/icon/22.png"));
		//ImageIcon btnQ =new ImageIcon("./icon/22.png");
		final JButton btnStop = new JButton(" Quit", btnQ);
		
		btnStop.setFont(new Font("宋体", Font.PLAIN, 16));
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(PlayerMain.file != null){
		            int exi = JOptionPane.showConfirmDialog (null, "Save AnnotatedInfo？", "Confirm Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
		            if (exi == JOptionPane.YES_OPTION)
		            {
		           	 AnnotationWin.saveAnnotation();
		           	PlayerMain.stop();
		            }
		            else if(exi == JOptionPane.NO_OPTION)
		            {
		            	PlayerMain.stop();
		            }else{
		           	 return;
		            }
				}else{
					JOptionPane.showMessageDialog(null, "No video！","error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		controlPanel.add(btnStop);
		
		//添加播放按钮
//		btnPlay=new JButton(" Play  ");
//		//btnPlay.setIcon(new ImageIcon(JButtonDemo.class.getResource("/images/delete.gif")));
//		btnPlay.setFont(new Font("宋体", Font.PLAIN, 16));
//		btnPlay.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				PlayerMain.play();
//			}
//		});
//		controlPanel.add(btnPlay);
	
		//添加暂停按钮
		//btnPause=new JButton(">");
		//btnPause=new JButton("Play");
		ImageIcon btnP = new ImageIcon(getClass().getResource("/icon/play.png"));
		//ImageIcon btnP =new ImageIcon("./icon/play.png");
		final JButton btnPause = new JButton(" Play", btnP);
		//btnPause=createBtn(" Play", "./icon/play.png");11
		
		btnPause.setFont(new Font("宋体", Font.PLAIN, 16));
		btnPause.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				PlayerMain.pause();
//			}
			
			
			String btnText = " Play";

			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnPause.getText() == " Play") {
					PlayerMain.play();
					btnText = "Pause";
					btnPause.setText(btnText);
					
					ImageIcon btnPa = new ImageIcon(getClass().getResource("/icon/12.png"));
					btnPause.setIcon(btnPa);
				} else {
					PlayerMain.pause();
					btnText = " Play";
					btnPause.setText(btnText);
					ImageIcon btnP = new ImageIcon(getClass().getResource("/icon/play.png"));
					btnPause.setIcon(btnP);
				}
			}
		});
		controlPanel.add(btnPause);
		
		//添加声音控制块
		slider=new JSlider();
		slider.setValue(80);
		slider.setMaximum(100);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				PlayerMain.setVol(slider.getValue());
			}
		});
		controlPanel.add(slider);
		
		xx233 = new ImageIcon(getClass().getResource("/icon/233.png"));
		xx322 = new ImageIcon(getClass().getResource("/icon/322.png"));
		listButton = new JButton("Pops  Up ",xx233);
		
		listButton.setFont(new Font("宋体", Font.PLAIN, 16));
		//listButton.setText("Pops AnnotationInfo");
		if(annotation.getFlag() == 1){
			listButton.setText("Pull Back");
			listButton.setIcon(xx322);
		}
		else if(annotation.getFlag() == 0){
			listButton.setText("Pops  Up ");
			listButton.setIcon(xx233);
		}
		
		
		listButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(listButton.getText() == "Pops  Up "){
			
					annotation.setVisible(true);
					if (Math.abs(PlayerMain.getFrame().getWidth() - Toolkit.getDefaultToolkit().getScreenSize().width) <= 20)
						annotation.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width - 550, 0, 550,
								PlayerMain.getFrame().getHeight());
					else
						annotation.setBounds(PlayerMain.getFrame().getX() + PlayerMain.getFrame().getWidth() - 15,
								PlayerMain.getFrame().getY(), 550, PlayerMain.getFrame().getHeight());
					annotation.setFlag(0);
					listButton.setText("Pull Back");
					listButton.setIcon(xx322);
				}else if(listButton.getText() == "Pull Back"){
					annotation.setVisible(false);
					listButton.setText("Pops  Up ");
					listButton.setIcon(xx233);
				}
				

			}
		});
		
		controlPanel.add(listButton);
		

		

	}
	
	
	public void CloseWin(){
		if(PlayerMain.file != null){
            int exi = JOptionPane.showConfirmDialog (null, "Save AnnotatedInfo？", "Confirm Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
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
			int exi = JOptionPane.showConfirmDialog (null, "Exit VideoAnnotationTool？", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (exi == JOptionPane.YES_OPTION){
				System.exit (0);
			}else{
				return;
			}
		}
	}
	
	
	
	
	public JButton getListButton() {
		return listButton;
	}

	public void setListButton(JButton listButton) {
		this.listButton = listButton;
	}

	//获取播放媒体实例（某个视频）
	public EmbeddedMediaPlayer getMediaPlayer() {
		return playerComponent.getMediaPlayer();
	}
	
	//获取进度条实例
	public JProgressBar getProgressBar() {
		return progress;
	}

	public JButton getBtnPause() {
		return btnPause;
	}

	public void setBtnPause(JButton btnPause) {
		this.btnPause = btnPause;
	}

	public JSlider getSlider() {
		return slider;
	}

	public void setSlider(JSlider slider) {
		this.slider = slider;
	}
	
	
	
}



