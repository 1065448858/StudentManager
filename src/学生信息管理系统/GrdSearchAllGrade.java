package 学生信息管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 成绩信息查询模块
 * 查询某学生所有科目的成绩
 */
public class GrdSearchAllGrade extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Container contentPane;
	//框架的大小
	Dimension faceSize = new Dimension(300, 100);
	String[] stu ;
	JLabel jLabel1 = new JLabel();
	JComboBox sNum;
	JButton searchInfo = new JButton();
	
	public GrdSearchAllGrade() {
		//设置标题
		this.setTitle("所有成绩查询");
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

		jLabel1.setText("请选择学号 ：");
		jLabel1.setFont(new Font("Dialog",0,12));
		contentPane.add(jLabel1);

		StuBean sN = new StuBean();
		stu = sN.getAllId();
		sNum = new JComboBox(stu);
		sNum.setSelectedItem(null);
		sNum.setFont(new Font("Dialog",0,12));
		contentPane.add(sNum);

		searchInfo.setText("确定");
		searchInfo.setFont(new Font("Dialog",0,12));
		contentPane.add(searchInfo);

		searchInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == searchInfo) { //查询
			ResultGrade rG = new ResultGrade((String)sNum.getSelectedItem());
			this.dispose();
		}
	}

}
