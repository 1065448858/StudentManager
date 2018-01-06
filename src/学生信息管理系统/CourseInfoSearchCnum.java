package 学生信息管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 课程信息管理模块
 * 根据课程编号查询课程信息，以供调用者修改或删除
 */
public class CourseInfoSearchCnum extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container contentPane;
	String[] s;
	//框架的大小
	Dimension faceSize = new Dimension(300, 100);
	JLabel jLabel1 = new JLabel();
	JComboBox<?> selectCnum;
	JButton searchInfo = new JButton();
	
	public CourseInfoSearchCnum(JFrame frame) {
		super(frame, true);
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
						(int) (screenSize.height - 300) / 2 + 45);
	}
	
	private void Init() throws Exception {
		this.setSize(faceSize);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());

		jLabel1.setText("请输入或者选择课程号:");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);
		
		CrsBean getId = new CrsBean();
		s = getId.getAllId();

		selectCnum = new JComboBox(s);
		selectCnum.setSelectedItem(null);
		selectCnum.setEditable(true);
		selectCnum.setFont(new Font("Dialog",0,12));
		contentPane.add(selectCnum);

		searchInfo.setText("查询");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		selectCnum.addActionListener(this);
		searchInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == selectCnum) { //退出
			this.dispose();
		}
		else if (obj == searchInfo) { //修改
			this.dispose();
		}
	}

	/**
	 * 返回选择的学号
	 */
	public String getCnum(){
		return (String)this.selectCnum.getSelectedItem();
	}
}
