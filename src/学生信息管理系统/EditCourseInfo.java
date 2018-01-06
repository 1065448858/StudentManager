package 学生信息管理系统;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditCourseInfo extends CourseInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cNum_str = "";
	public EditCourseInfo() {
		this.setTitle("修改课程信息");
		this.setResizable(false);

		cNum.setEditable(false);
		cNum.setText("请查询课程号");
		cName.setEditable(false);
		cTeacher.setEditable(false);
		cPoint.setEditable(false);
		cRatio.setEditable(false);
		cPlace.setEditable(false);

		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 +45);
	}

	public void downInit(){
		searchInfo.setText("查询");
		searchInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(searchInfo);
		modifyInfo.setText("修改");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);

		searchInfo.setEnabled(true);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		eixtInfo.setEnabled(true);

		//添加事件侦听
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] s = new String[5];

		if (obj == eixtInfo) { //退出
			this.dispose();
		}
		else if (obj == modifyInfo) { //修改
			CrsBean modifyCrs = new CrsBean();
			modifyCrs.crsModify(cNum.getText(), cName.getText(), cTeacher.getText(), cPlace.getText(), cPoint.getText(), cRatio.getText());
			modifyCrs.crsSearch(cNum.getText());
			s = modifyCrs.crsSearch(cNum_str);

			cName.setText(s[0]);
			cTeacher.setText(s[1]);
			cPlace.setText(s[2]);
			cPoint.setText(s[3]);
			cRatio.setText(s[4]);
			
		}
		else if (obj == clearInfo) { //清空
			setNull();
			cNum.setText("请查询课程号");
		}
		else if (obj == searchInfo) { //课程号查询
			CourseInfoSearchCnum cisc = new CourseInfoSearchCnum(this);
			cisc.pack();
			cisc.setVisible(true);
			cNum_str = cisc.getCnum();
			
			CrsBean searchCrs = new CrsBean();
			s = searchCrs.crsSearch(cNum_str);
			if(s == null){
				JOptionPane.showMessageDialog(null, "记录不存在！");
				cNum.setText("请查询学号");
				cName.setText("");
				cTeacher.setText("");
				cPlace.setText("");
				cPoint.setText("");
				cRatio.setText("");
								
				cName.setEditable(false);
				cTeacher.setEditable(false);
				cPlace.setEditable(false);
				cPoint.setEditable(false);
				cRatio.setEditable(false);
				modifyInfo.setEnabled(false);
				return;
			}
			else{
				cNum.setText(cNum_str);
				cName.setText(s[0]);
				cTeacher.setText(s[1]);
				cPlace.setText(s[2]);
				cPoint.setText(s[3]);
				cRatio.setText(s[4]);
				

				cName.setEditable(true);
				cTeacher.setEditable(true);
				cPlace.setEditable(true);
				cPoint.setEditable(true);
				cRatio.setEditable(true);
				modifyInfo.setEnabled(true);
			}
		}
	}
}
