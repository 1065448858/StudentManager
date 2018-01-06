package 学生信息管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 学生选课的类
 */
public class SelectCourse extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container contentPane;
	JPanel centerPanel = new JPanel();
	JPanel upPanel = new JPanel();
	JPanel downPanel = new JPanel();

	//框架的大小
	Dimension faceSize = new Dimension(800, 500);

	JLabel jLabel1 = new JLabel();
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel5 = new JLabel();
	JLabel jLabel6 = new JLabel();

	String[] s;
	JComboBox sNum;
	JTextField sName = new JTextField(15);
	JTextField cNum = new JTextField(15);
	JComboBox cName;
	JTextField cTeacher = new JTextField(15);
	JTextField Cplace = new JTextField(15);
	JTextField sMajor = new JTextField(15);
	JTextField sCollege = new JTextField(15);
	JTextField sHome = new JTextField(46);
	JButton selectCourse = new JButton();
	JButton cancel = new JButton();

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;

	public SelectCourse() {
		this.setSize(faceSize);
		this.setResizable(false);
		//设置标题
		this.setTitle("学生选课"); 
		
		//设置运行时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);

		try	{
			Init();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void Init() throws Exception {
		contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		//中部面板的布局
		centerPanel.setLayout(girdBag);

		jLabel1.setText("学        号：");
		jLabel1.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel1,girdBagCon);
		centerPanel.add(jLabel1);

		StuBean sN = new StuBean();
		s = sN.getAllId();
		sNum = new JComboBox(s);
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 0;
		girdBagCon.fill = girdBagCon.BOTH;
		girdBagCon.insets = new Insets(10,1,10,15);
		sNum.setSelectedItem(null);
		girdBag.setConstraints(sNum,girdBagCon);
		centerPanel.add(sNum);

		jLabel2.setText("姓        名：");
		jLabel2.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel2,girdBagCon);
		centerPanel.add(jLabel2);
		
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,1,10,10);
		sName.setEnabled(false);
		girdBag.setConstraints(sName,girdBagCon);
		centerPanel.add(sName);

		jLabel3.setText("选择课程：");
		jLabel3.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel3,girdBagCon);
		centerPanel.add(jLabel3);
		
		CrsBean getId = new CrsBean();
		s = getId.getAllName();
		cName = new JComboBox(s);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 1;
		girdBagCon.fill = girdBagCon.BOTH;
		girdBagCon.insets = new Insets(10,1,10,15);
		cName.setSelectedItem(null);
		girdBag.setConstraints(cName,girdBagCon);
		centerPanel.add(cName);

		jLabel4.setText("课程编码：");
		jLabel4.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel4,girdBagCon);
		centerPanel.add(jLabel4);
	
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,1,10,10);
		cNum.setEditable(false);
		girdBag.setConstraints(cNum,girdBagCon);
		centerPanel.add(cNum);

		jLabel5.setText("授课老师：");
		jLabel5.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel5,girdBagCon);
		centerPanel.add(jLabel5);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,1,10,15);
		cTeacher.setEditable(false);
		girdBag.setConstraints(cTeacher,girdBagCon);
		centerPanel.add(cTeacher);

		jLabel6.setText("授课地点：");
		jLabel6.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 2;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel6,girdBagCon);
		centerPanel.add(jLabel6);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.insets = new Insets(10,1,10,10);
		Cplace.setEditable(false);
		girdBag.setConstraints(Cplace,girdBagCon);
		centerPanel.add(Cplace);

		contentPane.add(centerPanel,BorderLayout.CENTER);

		sNum.addActionListener(this);
		cName.addActionListener(this);
	}

	/**
	 * 下部面板的布局
	 */
	public void downInit(){
		selectCourse.setText("选课");
		selectCourse.setFont(new Font("Dialog",0,12));
		downPanel.add(selectCourse);
		cancel.setText("取消");
		cancel.setFont(new Font("Dialog",0,12));
		downPanel.add(cancel);

		contentPane.add(downPanel,BorderLayout.SOUTH);

		//添加事件侦听
		cancel.addActionListener(this);
		selectCourse.addActionListener(this);
	}

	
	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == selectCourse) { //增加
			cNum.setEnabled(false);
			cName.setEditable(false);
			cTeacher.setEditable(false);
			Cplace.setEditable(false);
			sNum.setEditable(false);
			sName.setEditable(false);

			selectCourse.setEnabled(false);
			cancel.setEnabled(false);

			csBean crsAdd = new csBean();
			crsAdd.csAdd(cNum.getText(),(String)sNum.getSelectedItem());

			this.dispose();
			SelectCourse sc = new SelectCourse();
			sc.downInit();
			sc.pack();
			sc.setVisible(true);
		}
		else if (obj == cancel) { //退出
			this.dispose();
		}
		else if (obj == sNum) { //选择学号
			StuBean sN = new StuBean();
			sName.setText(sN.stuSearch((String)sNum.getSelectedItem())[0]);
		}
		else if (obj == cName) { //选择课程号
			CrsBean cSname = new CrsBean();
			cNum.setText(cSname.crsNameSear((String)cName.getSelectedItem())[5]);
			cTeacher.setText(cSname.crsNameSear((String)cName.getSelectedItem())[1]);
			Cplace.setText(cSname.crsNameSear((String)cName.getSelectedItem())[2]);
		}
	}

	
}
