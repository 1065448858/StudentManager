package 学生信息管理系统;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * 学生信息管理模块
 * 根据学号查询学生的信息，以供调用者修改或删除
 */
public class StuInfoSearchSnum extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container contentPane;
	String[] s;
	//框架的大小
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JComboBox selectSnum;
	JButton searchInfo = new JButton();

	
	public StuInfoSearchSnum(JFrame frame) {
		super(frame, true);
		this.setTitle("学号查询");
		this.setResizable(false);
		try {
			Init();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 +45);

	}
	
	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("请输入或者选择学号:");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);

		StuBean getId = new StuBean();
		s = getId.getAllId();
		if (s != null)selectSnum = new JComboBox(s);
		else {JOptionPane.showMessageDialog(null, "没有记录", "错误", JOptionPane.ERROR_MESSAGE);
		//selectSnum = new JComboBox(NULLSTRING);
		return;
		}
		selectSnum.setEditable(true);
		selectSnum.setFont(new Font("Dialog",0,12));
		contentPane.add(selectSnum);

		searchInfo.setText("查询");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == selectSnum) { //退出
			this.dispose();
		}
		else if (obj == searchInfo) { //修改
			this.dispose();
		}
	}

	/**
	 * 返回选择的学号
	 */
	public String getSnum(){
		return (String)this.selectSnum.getSelectedItem();
	}
}
