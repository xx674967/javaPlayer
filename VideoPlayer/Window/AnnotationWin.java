package VideoPlayer.Window;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;

import Event.ClickEventHandle;
import FileUtils.AnnotatedObj;
import FileUtils.XmlUtils;
import VideoPlayer.Main.PlayerMain;

import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;














import FileUtils.FileUtils;


public class AnnotationWin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3603073267437763172L;
	
	private int flag = 0;
	private JPanel panel;
	private JPanel panel_condition;
	private static JCheckBox weather1;
	private static JCheckBox weather2;
	private static JCheckBox weather3;
	private static JCheckBox weather4;
	private static JCheckBox weather5;
	private static JCheckBox weather6;
	private static JCheckBox weather7;
	
	private static JComboBox<Object> comboBox;
	
	private static JCheckBox road_condition1;
	private static JCheckBox road_condition2;
	private static JCheckBox road_condition3;
	private static JCheckBox road_condition4;
	private static JCheckBox road_condition5;
	
	
	private static JTextArea road_feature;
	private static JTextArea road_equality;
	
	
	private static JCheckBox light1;
	private static JCheckBox light2;
	private static JCheckBox light3;
	private static JCheckBox light4;
	private static JCheckBox light5;
	
	private static JCheckBox video_content1;
	private static JCheckBox video_content2;
	private static JCheckBox video_content3;
	private static JCheckBox video_content4;
	private static JCheckBox video_content5;
	
	private static JCheckBox annotated_info1;
	private static JCheckBox annotated_info2;
	private static JCheckBox annotated_info3;
	private static JCheckBox annotated_info4;
	private static JCheckBox annotated_info5;
	
	private static JTextArea video_remark;
	
	private static JTextField annotater;
	private ImageIcon xx233;
	
	

	public AnnotationWin() {
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
//	             int exi = JOptionPane.showConfirmDialog (null, "Save AnnotatedInfo？", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//	             if (exi == JOptionPane.YES_OPTION)
//	             {
//	            	 
//	                 System.exit (0);
//	             }
//	             else
//	             {
//	                 return;
//	             }
				setVisible(false);

				xx233 = new ImageIcon(getClass().getResource("/icon/233.png"));
				flag = 0;
				PlayerMain.getFrame().getListButton().setText("Pops  Up ");
				
				//PlayerMain.getFrame().getListButton().setText(PlayerMain.getFrame().getListButton().getText());
				
				PlayerMain.getFrame().getListButton().setIcon(xx233);
			}
		});
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMaximizedBounds(new Rectangle((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 400, 0, 400,
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		
		
		
		
		
		
		//标注者
		panel=new JPanel();
		TitledBorder xx = new TitledBorder("AnnotatedInfo");
		xx.setTitleFont(new Font("Dialog", Font.PLAIN, 20));
		panel.setBorder(xx);
		BoxLayout layout=new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layout);
		
		setContentPane(panel);
		
		//天气
		JPanel panel_weather=new JPanel();
		panel.add(panel_weather);
		panel_weather.setLayout(new BoxLayout(panel_weather, BoxLayout.X_AXIS));
		
		
		JLabel lblWeatherm = new JLabel("Weather(M)");
		lblWeatherm.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_weather.add(lblWeatherm);
		
		weather1 = new JCheckBox("Sunny");
		weather1.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_weather.add(weather1);
		
		weather2 = new JCheckBox("Overcast");
		weather2.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_weather.add(weather2);
		
		weather3 = new JCheckBox("Lrain");
		weather3.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_weather.add(weather3);
		
		weather4 = new JCheckBox("Cloudy");
		weather4.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_weather.add(weather4);
		
		weather5 = new JCheckBox("Hrain");
		weather5.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_weather.add(weather5);
		
		weather6 = new JCheckBox("Snow");
		weather6.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_weather.add(weather6);
		
		weather7 = new JCheckBox("Fog");
		weather7.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_weather.add(weather7);
		
		//道路类型
		Panel panel_road_1 = new Panel();
		panel_road_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		//BoxLayout bl_panel_road_1=new BoxLayout(panel_road_1, BoxLayout.X_AXIS);
		//panel_road_1.setLayout(bl_panel_road_1);
		panel.add(panel_road_1);
		JLabel lblNewLabel1 = new JLabel("RoadType(S)");
		lblNewLabel1.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_road_1.add(lblNewLabel1);
		
		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_5);
		
		Component rigidArea_16 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_16);
		
		Component rigidArea_12 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_12);
		
		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_3);
		
		Component rigidArea_18 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_18);
		
		Component rigidArea_17 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_17);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_1);
		
		comboBox = new JComboBox<Object>();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comboBox.setToolTipText("HighWay: the main signs of traffic lights, lane line, zebra crossing, bus station, mainly the city internal scene;\r\nCityRoad: the main signs of no traffic lights, lane line, no zebra crossing, the speed limit of the signs and the inherent signs of the highway;\r\nRuralRoad: The main sign is no lane line, no zebra crossing.");
			}
		});
	
		comboBox.setFont(new Font("Dialog", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"HighWay", "CityRoad", "RuralRoad"}));
		panel_road_1.add(comboBox);
		
		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_6);
		
		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_7);
		
		Component rigidArea_32 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_32);
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_2);
		
		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_4);
		
		Component rigidArea_27 = Box.createRigidArea(new Dimension(20, 20));
		panel_road_1.add(rigidArea_27);
		

		
		//路况
		panel_condition=new JPanel();
		BoxLayout layout_condition=new BoxLayout(panel_condition, BoxLayout.X_AXIS);
		panel_condition.setLayout(layout_condition);
		panel.add(panel_condition);
		
		JLabel lblNewLabel = new JLabel("RoadCondition(M)");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_condition.add(lblNewLabel);
		
		road_condition1 = new JCheckBox("Normal");
		road_condition1.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_condition.add(road_condition1);
		
		road_condition2 = new JCheckBox("Tunnel");
		road_condition2.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_condition.add(road_condition2);
		
		road_condition3 = new JCheckBox("Intersection");
		road_condition3.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_condition.add(road_condition3);
		
		road_condition4 = new JCheckBox("Corners");
		road_condition4.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_condition.add(road_condition4);
		
		road_condition5 = new JCheckBox("Ramp");
		road_condition5.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_condition.add(road_condition5);
		
		Component rigidArea_29 = Box.createRigidArea(new Dimension(20, 20));
		panel_condition.add(rigidArea_29);
		 
		
		
		// 工况特点
		Panel panel_condit1= new Panel();
		panel.add(panel_condit1);
		panel_condit1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		
		JLabel lblCharacteristicsOfWork = new JLabel("WorkCondition  ");
		lblCharacteristicsOfWork.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_condit1.add(lblCharacteristicsOfWork);
		
		road_feature= new JTextArea();
		road_feature.setFont(new Font("Monospaced", Font.PLAIN, 14));
		road_feature.setPreferredSize(new Dimension(365, 140)); 
		
		
		panel_condit1.add(road_feature);
		
		Component rigidArea_8 = Box.createRigidArea(new Dimension(20, 20));
		panel_condit1.add(rigidArea_8);
		
		Component rigidArea_9 = Box.createRigidArea(new Dimension(20, 20));
		panel_condit1.add(rigidArea_9);
		//textField.setColumns(10);
		
		//道路质量
		Panel panel_roadquality= new Panel();
		panel.add(panel_roadquality);
		panel_roadquality.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		JLabel lblRoadquality = new JLabel("RoadQuality ");
		lblRoadquality.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_roadquality.add(lblRoadquality);
		
		Component rigidArea_14 = Box.createRigidArea(new Dimension(20, 20));
		panel_roadquality.add(rigidArea_14);
		
		road_equality = new JTextArea();
		road_equality.setFont(new Font("Monospaced", Font.PLAIN, 14));
		road_equality.setPreferredSize(new Dimension(365, 140)); 
		panel_roadquality.add(road_equality);
		
		Component rigidArea_37 = Box.createRigidArea(new Dimension(20, 20));
		panel_roadquality.add(rigidArea_37);
		
		JPanel panel_light = new JPanel();
		panel.add(panel_light);
		panel_light.setLayout(new BoxLayout(panel_light, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("Light(M)");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_light.add(lblNewLabel_1);
		
		light1 = new JCheckBox("Normal");
		light1.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_light.add(light1);
		
		light2 = new JCheckBox("FrontLight");
		light2.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_light.add(light2);
		
		light3 = new JCheckBox("SideLight");
		light3.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_light.add(light3);
		
	    light4 = new JCheckBox("BackLight");
		light4.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_light.add(light4);
		
		light5 = new JCheckBox("InfraredFillLight");
		light5.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_light.add(light5);
		
		JPanel panel_content = new JPanel();
		panel.add(panel_content);
		panel_content.setLayout(new BoxLayout(panel_content, BoxLayout.X_AXIS));
		
		JLabel lblVideocontentm = new JLabel("VideoContent(M)");
		lblVideocontentm.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_content.add(lblVideocontentm);
		
		video_content1 = new JCheckBox("FCWS");
		video_content1.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_content.add(video_content1);
		
		video_content2 = new JCheckBox("PCWS");
		video_content2.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_content.add(video_content2);
		
		video_content3 = new JCheckBox("LDWS");
		video_content3.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_content.add(video_content3);
		
		video_content4 = new JCheckBox("TSR");
		video_content4.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_content.add(video_content4);
		
		video_content5 = new JCheckBox("LAMP");
		video_content5.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_content.add(video_content5);
		
		Component rigidArea_10 = Box.createRigidArea(new Dimension(20, 20));
		panel_content.add(rigidArea_10);
		
		Component rigidArea_11 = Box.createRigidArea(new Dimension(20, 20));
		panel_content.add(rigidArea_11);
		
		Component rigidArea_23 = Box.createRigidArea(new Dimension(20, 20));
		panel_content.add(rigidArea_23);
		
		Component rigidArea_24 = Box.createRigidArea(new Dimension(20, 20));
		panel_content.add(rigidArea_24);
		
		JPanel panel_annot_info = new JPanel();
		panel.add(panel_annot_info);
		panel_annot_info.setLayout(new BoxLayout(panel_annot_info, BoxLayout.X_AXIS));
		
		JLabel lblAnnotatedinfom = new JLabel("AnnotatedInfo(M)");
		lblAnnotatedinfom.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_annot_info.add(lblAnnotatedinfom);
		
		annotated_info1 = new JCheckBox("People");
		annotated_info1.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_annot_info.add(annotated_info1);
		
		annotated_info2 = new JCheckBox("Car");
		annotated_info2.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_annot_info.add(annotated_info2);
		
		 annotated_info3 = new JCheckBox("Ride");
		annotated_info3.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_annot_info.add(annotated_info3);
		
		annotated_info4 = new JCheckBox("TrafficSign");
		annotated_info4.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_annot_info.add(annotated_info4);
		
		annotated_info5 = new JCheckBox("LaneLine");
		annotated_info5.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_annot_info.add(annotated_info5);
		
		Component rigidArea_13 = Box.createRigidArea(new Dimension(20, 20));
		panel_annot_info.add(rigidArea_13);
		
		Component rigidArea_28 = Box.createRigidArea(new Dimension(20, 20));
		panel_annot_info.add(rigidArea_28);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		
		JLabel lblVideomemo = new JLabel("VideoMemo ");
		lblVideomemo.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_1.add(lblVideomemo);
		
		Component rigidArea_15 = Box.createRigidArea(new Dimension(20, 20));
		panel_1.add(rigidArea_15);
		
		video_remark = new JTextArea();
		video_remark.setFont(new Font("Monospaced", Font.PLAIN, 14));
		video_remark.setPreferredSize(new Dimension(365, 140)); 
		panel_1.add(video_remark);
		
		Component rigidArea_39 = Box.createRigidArea(new Dimension(20, 20));
		panel_1.add(rigidArea_39);
		
		Panel panel_condit = new Panel();
		panel.add(panel_condit);
		panel_condit.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		//panel_condit.setLayout(new BoxLayout(panel_condit, BoxLayout.X_AXIS));
		
		JLabel lblAnnotator = new JLabel("Annotator   ");
		lblAnnotator.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 14));
		panel_condit.add(lblAnnotator);
		
		Component rigidArea_20 = Box.createRigidArea(new Dimension(20, 20));
		panel_condit.add(rigidArea_20);
		annotater = new JTextField();
		annotater.setFont(new Font("宋体", Font.PLAIN, 20));
		annotater.setPreferredSize(new Dimension(100, 30)); 
		panel_condit.add(annotater);
		
		Component rigidArea_19 = Box.createRigidArea(new Dimension(20, 20));
		panel_condit.add(rigidArea_19);
		
		JButton btnS = new JButton(" Submit  ");
		
		
		//提交按钮事件
		btnS.addActionListener(new ClickEventHandle() {
		
		});
		

		
		
		
		
		btnS.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_condit.add(btnS);
		
		Component rigidArea_21 = Box.createRigidArea(new Dimension(20, 20));
		panel_condit.add(rigidArea_21);
		
		JButton btnNewButton = new JButton("createXML");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(PlayerMain.file != null){
				XmlUtils.createXml(PlayerMain.file);
				
						}else{JOptionPane.showMessageDialog(null, "Please open a video first","error",JOptionPane.ERROR_MESSAGE);}
				}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel_condit.add(btnNewButton);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel_condit.add(rigidArea);
		
		//JTextField textField1= new JTextF();
		
		
		
	}
	
	
	
	
	
	//读取信息并显示的函数
	public static void showAnnotation(AnnotatedObj xx){
		//设置标注者
		annotater.setText(xx.getAnnotater());
		//获取天气
		String x1=xx.getWeather();
		if(x1 != null){
		String[] z1=x1.split(",");
	
		for (int i = 0; i < z1.length; i++) {

			if(weather1.getText().equals(z1[i]))weather1.setSelected(true);
			if(weather2.getText().equals(z1[i]))weather2.setSelected(true);
			if(weather3.getText().equals(z1[i]))weather3.setSelected(true);
			if(weather4.getText().equals(z1[i]))weather4.setSelected(true);
			if(weather5.getText().equals(z1[i]))weather5.setSelected(true);
			if(weather6.getText().equals(z1[i]))weather6.setSelected(true);
			if(weather7.getText().equals(z1[i]))weather7.setSelected(true);
			}
		}
		//道路类型
		//System.out.println("11");
		//System.out.println(comboBox.getItemAt(1).toString());   // 从下表为0开始！！！！！！！！
		String x2=xx.getRoad_type();
		//if(x2.equals(comboBox.getItemAt(0)))comboBox.setSelectedIndex(0);	
		if(x2 != null){
			//String[] z2=x2.split(","); 道路状况唯一-.-
			   if(x2.equals(comboBox.getItemAt(1)))comboBox.setSelectedIndex(1);
			   if(x2.equals(comboBox.getItemAt(2)))comboBox.setSelectedIndex(2);
			
		}
		
		//道路状况
		String x3 = xx.getRoad_condition();
	
		if(x3 != null){
		String[] z2=x3.split(",");
	
		for (int i = 0; i < z2.length; i++) {

			if(road_condition1.getText().equals(z2[i]))road_condition1.setSelected(true);
			if(road_condition2.getText().equals(z2[i]))road_condition2.setSelected(true);
			if(road_condition3.getText().equals(z2[i]))road_condition3.setSelected(true);
			if(road_condition4.getText().equals(z2[i]))road_condition4.setSelected(true);
			if(road_condition5.getText().equals(z2[i]))road_condition5.setSelected(true);
			}
		}
		
	  //工况
		String x4 = xx.getRoad_Feature();
		if(x4 != null)road_feature.setText(x4);
		
	//道路质量
		String x5 = xx.getRoad_quality();
		if(x5 != null)road_equality.setText(x5);

	//光线
		
		String x6 = xx.getLight();
		
		if(x6 != null){
		String[] z3=x6.split(",");
	
		for (int i = 0; i < z3.length; i++) {

			if(light1.getText().equals(z3[i]))light1.setSelected(true);
			if(light2.getText().equals(z3[i]))light2.setSelected(true);
			if(light3.getText().equals(z3[i]))light3.setSelected(true);
			if(light4.getText().equals(z3[i]))light4.setSelected(true);
			if(light5.getText().equals(z3[i]))light5.setSelected(true);
			}
		}
		
		
		//视频内容
		
		String x7 = xx.getVideo_content();
		
		if(x7 != null){
		String[] z4=x7.split(",");
	
		for (int i = 0; i < z4.length; i++) {

			if(video_content1.getText().equals(z4[i]))video_content1.setSelected(true);
			if(video_content2.getText().equals(z4[i]))video_content2.setSelected(true);
			if(video_content3.getText().equals(z4[i]))video_content3.setSelected(true);
			if(video_content4.getText().equals(z4[i]))video_content4.setSelected(true);
			if(video_content5.getText().equals(z4[i]))video_content5.setSelected(true);
			}
		}
		
		//标注信息
		String x8 = xx.getAnnotated_info();
		
		if(x8 != null){
		String[] z5=x8.split(",");
	
		for (int i = 0; i < z5.length; i++) {

			if(annotated_info1.getText().equals(z5[i]))annotated_info1.setSelected(true);
			if(annotated_info2.getText().equals(z5[i]))annotated_info2.setSelected(true);
			if(annotated_info3.getText().equals(z5[i]))annotated_info3.setSelected(true);
			if(annotated_info4.getText().equals(z5[i]))annotated_info4.setSelected(true);
			if(annotated_info5.getText().equals(z5[i]))annotated_info5.setSelected(true);
			}
		}
		
		//视频留言
		String x9 = xx.getVideo_remark();
		if(x9 != null)video_remark.setText(x9);
}

	
	
	
/*
 * 	//把保存信息写一个静态函数
 */
	
	
	

	public static  void saveAnnotation(){
		AnnotatedObj xx = new AnnotatedObj();
		
		
		//获取天气
		String weather="";
		if(weather1.isSelected() && weather != "" ){
			
			weather=weather+","+weather1.getText();}
		else if(weather1.isSelected()&& weather == ""){
			weather=weather+weather1.getText();
		}
		if(weather2.isSelected() && weather != "" ){
			
			weather=weather+","+weather2.getText();}
		else if(weather2.isSelected()&& weather == ""){
			weather=weather+weather2.getText();
		}
		if(weather3.isSelected() && weather != "" ){
			
			weather=weather+","+weather3.getText();}
		else if(weather3.isSelected()&& weather == ""){
			weather=weather+weather3.getText();
		}
		if(weather4.isSelected() && weather != "" ){
			
			weather=weather+","+weather4.getText();}
		else if(weather4.isSelected()&& weather == ""){
			weather=weather+weather4.getText();
		}
		if(weather5.isSelected() && weather != "" ){
			
			weather=weather+","+weather5.getText();}
		else if(weather5.isSelected()&& weather == ""){
			weather=weather+weather5.getText();
		}
		if(weather6.isSelected() && weather != "" ){
			
			weather=weather+","+weather6.getText();}
		else if(weather6.isSelected()&& weather == ""){
			weather=weather+weather6.getText();
		}
		if(weather7.isSelected() && weather != "" ){
			
			weather=weather+","+weather7.getText();}
		else if(weather7.isSelected()&& weather == ""){
			weather=weather+weather7.getText();
		}
		
		//xx.setWeather(weather1.getText()+weather2.getText()+weather3.getText()+weather4.getText()+weather5.getText()+weather6.getText()+weather7.getText());
		
		xx.setWeather(weather);
		
		//获取道路类型
		
		
		String road_type = comboBox.getSelectedItem().toString();
		
		xx.setRoad_type(road_type);
		
		//获取路况
		String road_condition="";
		if(road_condition1.isSelected() && road_condition != "" ){
			
			road_condition=road_condition+","+road_condition1.getText();}
		else if(road_condition1.isSelected()&& road_condition == ""){
			road_condition=road_condition+road_condition1.getText();
		}
		if(road_condition2.isSelected() && road_condition != "" ){
			
			road_condition=road_condition+","+road_condition2.getText();}
		else if(road_condition2.isSelected()&& road_condition == ""){
			road_condition=road_condition+road_condition2.getText();
		}
		
		if(road_condition3.isSelected() && road_condition != "" ){
			
			road_condition=road_condition+","+road_condition3.getText();}
		else if(road_condition3.isSelected()&& road_condition == ""){
			road_condition=road_condition+road_condition3.getText();
		}
		
		if(road_condition4.isSelected() && road_condition != "" ){
			
			road_condition=road_condition+","+road_condition4.getText();}
		else if(road_condition4.isSelected()&& road_condition == ""){
			road_condition=road_condition+road_condition4.getText();
		}
		
		if(road_condition5.isSelected() && road_condition != "" ){
			
			road_condition=road_condition+","+road_condition5.getText();}
		else if(road_condition5.isSelected()&& road_condition == ""){
			road_condition=road_condition+road_condition5.getText();
		}
		xx.setRoad_condition(road_condition);
		
		//获取工况特点
		xx.setRoad_Feature(road_feature.getText());
		
		//获取道路质量
		xx.setRoad_quality(road_equality.getText());
		
		//光线
		String light="";
		
		if(light1.isSelected() && light != "" ){
			
			light=light+","+light1.getText();}
		else if(light1.isSelected()&& light == ""){
			light=light+light1.getText();
		}
		if(light2.isSelected() && light != "" ){
			
			light=light+","+light2.getText();}
		else if(light2.isSelected()&& light == ""){
			light=light+light2.getText();
		}
		if(light3.isSelected() && light != "" ){
			
			light=light+","+light3.getText();}
		else if(light3.isSelected()&& light == ""){
			light=light+light3.getText();
		}
		if(light4.isSelected() && light != "" ){
			
			light=light+","+light4.getText();}
		else if(light4.isSelected()&& light == ""){
			light=light+light4.getText();
		}
		if(light5.isSelected() && light != "" ){
			
			light=light+","+light5.getText();}
		else if(light5.isSelected()&& light == ""){
			light=light+light5.getText();
		}
		xx.setLight(light);
		
		//获取视频内容
		String video_content="";
	
		
		if(video_content1.isSelected() && video_content != "" ){
			
			 video_content=video_content+","+video_content1.getText();}
		else if(video_content1.isSelected()&& video_content == ""){
			 video_content=video_content+video_content1.getText();
		}
		if(video_content2.isSelected() && video_content != "" ){
			
			 video_content=video_content+","+video_content2.getText();}
		else if(video_content2.isSelected()&& video_content == ""){
			 video_content=video_content+video_content2.getText();
		}
		
		if(video_content3.isSelected() && video_content != "" ){
			
			 video_content=video_content+","+video_content3.getText();}
		else if(video_content3.isSelected()&& video_content == ""){
			 video_content=video_content+video_content3.getText();
		}
		if(video_content4.isSelected() && video_content != "" ){
			
			 video_content=video_content+","+video_content4.getText();}
		else if(video_content4.isSelected()&& video_content == ""){
			 video_content=video_content+video_content4.getText();
		}
		if(video_content5.isSelected() && video_content != "" ){
			
			 video_content=video_content+","+video_content5.getText();}
		else if(video_content5.isSelected()&& video_content == ""){
			 video_content=video_content+video_content5.getText();
		}
		

		xx.setVideo_content(video_content);
		
		//获取标注信息
		String annotated_info="";
		if(annotated_info1.isSelected() && annotated_info != "" ){
		
			annotated_info=annotated_info+","+annotated_info1.getText();}
		else if(annotated_info1.isSelected()&& annotated_info == ""){
			annotated_info=annotated_info+annotated_info1.getText();
		}
	
			
			
		
		if(annotated_info2.isSelected() && annotated_info != "" ){
			
			annotated_info=annotated_info+","+annotated_info2.getText();}
		else if(annotated_info2.isSelected()&& annotated_info ==""){
			annotated_info=annotated_info+annotated_info2.getText();
		}
		
		
		if(annotated_info3.isSelected() && annotated_info != "" ){
			
			annotated_info=annotated_info+","+annotated_info3.getText();}
		else if(annotated_info3.isSelected()&& annotated_info ==""){
			annotated_info=annotated_info+annotated_info3.getText();
		}
		
		
		if(annotated_info4.isSelected() && annotated_info != "" ){
			
			annotated_info=annotated_info+","+annotated_info4.getText();}
		else if(annotated_info4.isSelected()&& annotated_info == ""){
			annotated_info=annotated_info+annotated_info4.getText();
		}
		
		
		if(annotated_info5.isSelected() && annotated_info != ""){
			
			annotated_info=annotated_info+","+annotated_info5.getText();}
		else if(annotated_info5.isSelected()&& annotated_info == ""){
			annotated_info=annotated_info+annotated_info5.getText();
		}
		
		
		
		xx.setAnnotated_info(annotated_info);
		
		//获取视频备注
		xx.setVideo_remark(video_remark.getText());
		
		//获取作者
		xx.setAnnotater(annotater.getText());
		
		
		
		if(PlayerMain.file != null){
		
			FileUtils.saveFile(xx,PlayerMain.file);
			JOptionPane.showMessageDialog(null, "AnnotatedFile saved successfully！","information",JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			JOptionPane.showMessageDialog(null, "Please open a video first!","error",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public static void clearWin(){
		weather1.setSelected(false);
		weather2.setSelected(false);
		weather3.setSelected(false);
		weather4.setSelected(false);
		weather5.setSelected(false);
		weather6.setSelected(false);
		weather7.setSelected(false);
		
		comboBox.setSelectedIndex(0);
		
		road_condition1.setSelected(false);
		road_condition2.setSelected(false);
		road_condition3.setSelected(false);
		road_condition4.setSelected(false);
		road_condition5.setSelected(false);
		
		road_feature.setText("");
		road_equality.setText("");
		
		light1.setSelected(false);
		light2.setSelected(false);
		light3.setSelected(false);
		light4.setSelected(false);
		light5.setSelected(false);
		
		video_content1.setSelected(false);
		video_content2.setSelected(false);
		video_content3.setSelected(false);
		video_content4.setSelected(false);
		video_content5.setSelected(false);
		
		
		annotated_info1.setSelected(false);
		annotated_info2.setSelected(false);
		annotated_info3.setSelected(false);
		annotated_info4.setSelected(false);
		annotated_info5.setSelected(false);
		
		
		video_remark.setText("");
		
		annotater.setText("");
	}
	
	
	public int getFlag() {
		return flag;
	}

	
	
	public void setFlag(int flag) {
		this.flag = flag;
	}

	
	
	

}

