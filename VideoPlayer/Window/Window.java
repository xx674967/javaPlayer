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
	private JPanel contentPane;	//������������������ҳ�������
	private JMenuBar menuBar;	//�˵���
	private JPanel panel;	//������������
	private JProgressBar progress;	//������
	private JPanel controlPanel;	//���ư�ť����
	private JButton btnPause;	//���ư�ť��ֹͣ�����š���ͣ
	private JSlider slider;		//�������ƿ�
	private JPanel progressTimePanel;
	private JButton listButton;
	private KeyBordListenerEven kble;
	private static AnnotationWin annotation;
	private JButton FileBtn;
	private JButton ExitBtn;
	private JButton HelpBtn;
	private ImageIcon xx233;
	private ImageIcon xx322;
	
	
	
	EmbeddedMediaPlayerComponent playerComponent;	//ý�岥�������
	
	
	//�µ�swing���
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//��ư�ť����
	private JButton createBtn(String text, ImageIcon icon) {
		JButton btn = new JButton(text, icon);
		btn.setUI(new BasicButtonUI());// �ָ������Ӿ�Ч��
		btn.setPreferredSize(new Dimension(80, 27));// ���ð�ť��С
		btn.setContentAreaFilled(false);// ���ð�ť͸��
		btn.setFont(new Font("����", Font.PLAIN, 15));// ��ť�ı���ʽ
		btn.setMargin(new Insets(0, 0, 0, 0));// ��ť������߿����
		btn.addMouseListener(new MyMouseListener(this));
		return btn;
	}
	

	//MainWindow���췽���������������ŵ�������
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
		//�����¼�
		kble = new KeyBordListenerEven();
		kble.keyBordListner();
		//

		ImageIcon iconTitle = new ImageIcon(getClass().getResource("/icon/computer.png"));
		setIconImage(iconTitle.getImage());
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
		
		/*��Ƶ���Ŵ����еĲ˵���*/
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
		
//		mnFile=new JMenu("File");		//���ò˵���
//		mnFile.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
//		menuBar.add(mnFile);
//		mnSetting=new JMenu("Source");
//		mnSetting.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
//		menuBar.add(mnSetting);
//		mnHelp=new JMenu("Help");
//		mnHelp.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
//		menuBar.add(mnHelp);
//		
//		mnOpenVideo =new JMenuItem("OpenFile");	//�����ļ��˵���Ŀ¼���ļ�
//		mnOpenVideo.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
//		mnFile.add(mnOpenVideo);
//		
//		mnExit =new JMenuItem("Quit");	//�����ļ��˵���Ŀ¼�˳�
//		mnExit.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));
//		mnFile.add(mnExit);
		
		
		//�Զ���ҳ���С--ȫ��
//				int fraWidth = this.getWidth();//frame�Ŀ�
//				int fraHeight = this.getHeight();//frame�ĸ�
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
		
		
		
		
		
		
		
		//���ļ�
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
		
		//�˳�
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
				JOptionPane.showMessageDialog(null, "If you have any questions, please contact��497530437@qq.com","Help",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		
		/*���������в��Ž��沿��*/
		JPanel videoPane=new JPanel();
		contentPane.add(videoPane, BorderLayout.CENTER);
		videoPane.setLayout(new BorderLayout(0,0));
		
		
		playerComponent=new EmbeddedMediaPlayerComponent();
		videoPane.add(playerComponent,BorderLayout.CENTER);//�޸Ľ�����- - - - -
		
		
		/*���������п��Ʋ���
		 * videoPane��SOUTH��������һ����壬Ϊ���ý���������ȥ
		 * 
		 * */
		
		
		
		panel=new JPanel();		//ʵ����������������
		videoPane.add(panel,BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		progressTimePanel = new JPanel();
		
		panel.add(progressTimePanel,BorderLayout.NORTH);
		progressTimePanel.setLayout(new BorderLayout(0, 0));
		
//		currentLabel = new JLabel("00��00");
//		progressTimePanel.add(currentLabel, BorderLayout.WEST);
//		
//		totalLabel = new JLabel("02��13");
//		progressTimePanel.add(totalLabel, BorderLayout.EAST);
		
		
		//��ӽ�����
		progress=new JProgressBar();	
		progressTimePanel.add(progress,BorderLayout.SOUTH);		
		
		
		
		
		//progressPanel=new JPanel();	//ʵ��������������
		//panel.add(progressPanel, BorderLayout.NORTH);

		//panel.add(progress,BorderLayout.NORTH);
		progress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){		//��������������������Ž���
				int x=e.getX();
				PlayerMain.jumpTo((float)x/progress.getWidth());
			}
		});
		progress.setStringPainted(true);
		
		
//		controlPanel=new JPanel();		//ʵ�������ư�ť����
//		panel.add(controlPanel,BorderLayout.SOUTH);
		
		controlPanel = new JPanel();
		controlPanel.getLayout();
		panel.add(controlPanel, BorderLayout.SOUTH);
	
		
		
		
		
		//���ֹͣ��ť
		ImageIcon btnQ = new ImageIcon(getClass().getResource("/icon/22.png"));
		//ImageIcon btnQ =new ImageIcon("./icon/22.png");
		final JButton btnStop = new JButton(" Quit", btnQ);
		
		btnStop.setFont(new Font("����", Font.PLAIN, 16));
		btnStop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(PlayerMain.file != null){
		            int exi = JOptionPane.showConfirmDialog (null, "Save AnnotatedInfo��", "Confirm Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "No video��","error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		controlPanel.add(btnStop);
		
		//��Ӳ��Ű�ť
//		btnPlay=new JButton(" Play  ");
//		//btnPlay.setIcon(new ImageIcon(JButtonDemo.class.getResource("/images/delete.gif")));
//		btnPlay.setFont(new Font("����", Font.PLAIN, 16));
//		btnPlay.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				PlayerMain.play();
//			}
//		});
//		controlPanel.add(btnPlay);
	
		//�����ͣ��ť
		//btnPause=new JButton(">");
		//btnPause=new JButton("Play");
		ImageIcon btnP = new ImageIcon(getClass().getResource("/icon/play.png"));
		//ImageIcon btnP =new ImageIcon("./icon/play.png");
		final JButton btnPause = new JButton(" Play", btnP);
		//btnPause=createBtn(" Play", "./icon/play.png");11
		
		btnPause.setFont(new Font("����", Font.PLAIN, 16));
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
		
		//����������ƿ�
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
		
		listButton.setFont(new Font("����", Font.PLAIN, 16));
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
            int exi = JOptionPane.showConfirmDialog (null, "Save AnnotatedInfo��", "Confirm Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
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
			int exi = JOptionPane.showConfirmDialog (null, "Exit VideoAnnotationTool��", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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

	//��ȡ����ý��ʵ����ĳ����Ƶ��
	public EmbeddedMediaPlayer getMediaPlayer() {
		return playerComponent.getMediaPlayer();
	}
	
	//��ȡ������ʵ��
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



