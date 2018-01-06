package 学生信息管理系统;



import java.awt.event.*;
import java.awt.*;

/**
 * 课程信息管理模块
 * 添加新的课程信息
 */
public class AddCourseInfo extends CourseInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CrsBean getCnum = new CrsBean();

	public AddCourseInfo() {
		this.setTitle("添加课程信息");
		this.setResizable(false);
		
		cNum.setEditable(true);
		
		cName.setEditable(true);
		cTeacher.setEditable(true);
		cPoint.setEditable(true);
		cRatio.setEditable(true);
		cPlace.setEditable(true);

		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 +45);
	}

	public void downInit(){
		addInfo.setText("增加");
		addInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(addInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);

		//添加事件侦听
		addInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == eixtInfo) { //退出
			this.dispose();
		}
		else if (obj == addInfo) { //增加
			cNum.setEnabled(false);
			cName.setEditable(false);
			cTeacher.setEditable(false);
			cPoint.setEditable(false);
			cRatio.setEditable(false);
			cPlace.setEditable(false);

			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			eixtInfo.setEnabled(false);

			CrsBean addCrs = new CrsBean();
			addCrs.crsAdd(cNum.getText(),cName.getText(), cTeacher.getText(), cPlace.getText(), cPoint.getText(), cRatio.getText());
			
			this.dispose();

			AddCourseInfo aci = new AddCourseInfo();
			aci.downInit();
			aci.pack();
			aci.setVisible(true);

			this.dispose();
		}
		else if (obj == clearInfo) { //清空
			setNull();
			cNum.setText("");
		}
	}
}
