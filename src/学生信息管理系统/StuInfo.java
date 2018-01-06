package 学生信息管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 学生信息综合管理类
 * 提供主界面，供其他类继承
 */
public class StuInfo extends JFrame implements ActionListener{
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
	JLabel jLabel7 = new JLabel();
	JLabel jLabel8 = new JLabel();
	JLabel jLabel9 = new JLabel();
	JTextField sNum = new JTextField(15);
	JTextField sName = new JTextField(15);
	JTextField sSex = new JTextField(15);
	JTextField sSethnic = new JTextField(15);
	JTextField sBirth = new JTextField(15);
	JTextField sYear = new JTextField(15);
	JTextField sMajor = new JTextField(15);
	JTextField sCollege = new JTextField(15);
	JTextField sHome = new JTextField(46);
	JButton searchInfo = new JButton();
	JButton addInfo = new JButton();
	JButton modifyInfo = new JButton();
	JButton deleteInfo = new JButton();
	JButton clearInfo = new JButton();
	JButton saveInfo = new JButton();
	JButton eixtInfo = new JButton();

	JButton jBSee = new JButton();
	JButton jBSearch = new JButton();
	JButton jBExit = new JButton();
	JButton jBSum = new JButton();
	JButton jBGrade = new JButton();

	GridBagLayout girdBag = new GridBagLayout();
	GridBagConstraints girdBagCon;

	public StuInfo() {
		//设置框架的大小
		this.setSize(faceSize);
		//设置标题
		this.setTitle("学生综合信息管理"); 
		this.setResizable(false);
		
		try	{
			Init();
		}
		catch(Exception	e) {
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

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 0;
		girdBagCon.insets = new Insets(10,1,10,15);
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
		girdBag.setConstraints(sName,girdBagCon);
		centerPanel.add(sName);

		jLabel3.setText("性        别：");
		jLabel3.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel3,girdBagCon);
		centerPanel.add(jLabel3);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 1;
		girdBagCon.insets = new Insets(10,1,10,15);
		girdBag.setConstraints(sSex,girdBagCon);
		centerPanel.add(sSex);

		jLabel4.setText("民        族：");
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
		girdBag.setConstraints(sSethnic,girdBagCon);
		centerPanel.add(sSethnic);

		jLabel5.setText("出生日期：");
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
		girdBag.setConstraints(sBirth,girdBagCon);
		centerPanel.add(sBirth);

		jLabel6.setText("入学时间：");
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
		girdBag.setConstraints(sYear,girdBagCon);
		centerPanel.add(sYear);

		jLabel7.setText("学        院：");
		jLabel7.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 3;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel7,girdBagCon);
		centerPanel.add(jLabel7);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 3;
		girdBagCon.insets = new Insets(10,1,10,15);
		girdBag.setConstraints(sCollege,girdBagCon);
		centerPanel.add(sCollege);

		jLabel8.setText("专        业：");
		jLabel8.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 2;
		girdBagCon.gridy = 3;
		girdBagCon.insets = new Insets(10,15,10,1);
		girdBag.setConstraints(jLabel8,girdBagCon);
		centerPanel.add(jLabel8);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 3;
		girdBagCon.gridy = 3;
		girdBagCon.insets = new Insets(10,1,10,10);
		girdBag.setConstraints(sMajor,girdBagCon);
		centerPanel.add(sMajor);

		jLabel9.setText("籍        贯：");
		jLabel9.setFont(new Font("Dialog",0,12));
		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 0;
		girdBagCon.gridy = 4;
		girdBagCon.insets = new Insets(10,10,10,1);
		girdBag.setConstraints(jLabel9,girdBagCon);
		centerPanel.add(jLabel9);

		girdBagCon = new GridBagConstraints();
		girdBagCon.gridx = 1;
		girdBagCon.gridy = 4;
		girdBagCon.gridwidth = 3;
		girdBagCon.insets = new Insets(10,1,10,10);
		girdBag.setConstraints(sHome,girdBagCon);
		centerPanel.add(sHome);

		contentPane.add(centerPanel,BorderLayout.CENTER);

		sNum.setEditable(false);
		sName.setEditable(false);
		sSex.setEditable(false);
		sSethnic.setEditable(false);
		sBirth.setEditable(false);
		sYear.setEditable(false);
		sMajor.setEditable(false);
		sCollege.setEditable(false);
		sHome.setEditable(false);	
	}
	
	/**
	 * 下部面板的布局
	 */
	public void downInit(){
		searchInfo.setText("查询");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		addInfo.setText("增加");
		addInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(addInfo);
		modifyInfo.setText("修改");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		deleteInfo.setText("删除");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		saveInfo.setText("保存");
		saveInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(saveInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		contentPane.add(downPanel,BorderLayout.SOUTH);

		//添加事件侦听
		searchInfo.addActionListener(this);
		addInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		saveInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		modifyInfo.setEnabled(false);
		deleteInfo.setEnabled(false);
		saveInfo.setEnabled(false);
		clearInfo.setEnabled(false);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) { //查询
		}
		else if (obj == addInfo) { //增加
		}
		else if (obj == modifyInfo) { //修改
		}
		else if (obj == deleteInfo) { //删除
		}
		else if (obj == saveInfo) { //保存
		}
		else if (obj == clearInfo) { //清空
			setNull();
		}
		else if (obj == eixtInfo) { //退出
			this.dispose();
		}
	}

	/**
	 * 将文本框清空
	 */
	void setNull(){
		sNum.setText(null);
		sName.setText(null);
		sSex.setText(null);
		sSethnic.setText(null);
		sBirth.setText(null);
		sYear.setText(null);
		sMajor.setText(null);
		sCollege.setText(null);
		sHome.setText(null);
	}

	
}
