package 学生信息管理系统;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 课程信息管理模块
 * 修改课程信息的类
 */
public class DelCourseInfo extends CourseInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String cNum_str = "";
	public DelCourseInfo() {
		this.setTitle("删除课程信息");
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
		deleteInfo.setText("删除");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		clearInfo.setText("清空");
		clearInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(clearInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		contentPane.add(downPanel,BorderLayout.SOUTH);

		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		eixtInfo.setEnabled(true);

		//添加事件侦听
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
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
		else if (obj == deleteInfo) { //删除
			int ifdel = JOptionPane.showConfirmDialog(null,"真的要删除该信息？","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE );
			if(ifdel == JOptionPane.YES_OPTION){
				CrsBean delCrs = new CrsBean();
				delCrs.crsDel(cNum.getText());
				
				this.dispose();

				DelCourseInfo dci = new DelCourseInfo();
				dci.downInit();
				dci.pack();
				dci.setVisible(true);
			}
			else{
				return;
			}
		}
		else if (obj == searchInfo) { //学号查询
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
				deleteInfo.setEnabled(false);
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
				deleteInfo.setEnabled(true);
			}
		}
	}
}
