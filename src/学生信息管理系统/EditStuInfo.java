package 学生信息管理系统;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 学生信息管理模块
 * 修改学生信息的类
 */
public class EditStuInfo extends StuInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String sNum_str = "";
	public EditStuInfo() {
		this.setTitle("修改学生信息");
		this.setResizable(false);

		sNum.setEditable(false);
		sNum.setText("请查询学号");
		sName.setEditable(false);
		sSex.setEditable(false);
		sSethnic.setEditable(false);
		sBirth.setEditable(false);
		sYear.setEditable(false);
		sMajor.setEditable(false);
		sCollege.setEditable(false);
		sHome.setEditable(false);

		//设置运行时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 400) / 2, 
			(screenSize.height - 300) / 2 + 45);
	}

	public void downInit(){
		searchInfo.setText("学号查询");
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

		searchInfo.setEnabled(true);
		modifyInfo.setEnabled(false);
		clearInfo.setEnabled(true);
		eixtInfo.setEnabled(true);

		//添加事件侦听
		searchInfo.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String[] s = new String[8];

		if (obj == eixtInfo) { //退出
			this.dispose();
		}
		else if (obj == modifyInfo) { //修改
			StuBean modifyStu = new StuBean();
			modifyStu.stuModify(sNum.getText(), sName.getText(), sSex.getText(), sBirth.getText(), sHome.getText(), sSethnic.getText(), sYear.getText(), sMajor.getText(), sCollege.getText());
			modifyStu.stuSearch(sNum.getText());
			s = modifyStu.stuSearch(sNum_str);

			sName.setText(s[0]);
			sSex.setText(s[1]);
			sSethnic.setText(s[2]);
			sHome.setText(s[3]);
			sYear.setText(s[4]);
			sMajor.setText(s[5]);
			sCollege.setText(s[6]);
			sBirth.setText(s[7]);
		}
		else if (obj == clearInfo) { //清空
			setNull();
			sNum.setText("请查询学号");
		}
		else if (obj == searchInfo) { //学号查询
			
			StuInfoSearchSnum siss = new StuInfoSearchSnum(this);
			siss.pack();
			siss.setVisible(true);
			try{
				sNum_str = siss.getSnum();
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "没有查找到该学号！"); 
			}
	
			StuBean searchStu = new StuBean();
			s = searchStu.stuSearch(sNum_str);
			if(s == null){
				JOptionPane.showMessageDialog(null, "记录不存在！");
				sNum.setText("请查询学号");
				sName.setText("");
				sSex.setText("");
				sSethnic.setText("");
				sHome.setText("");
				sYear.setText("");
				sMajor.setText("");
				sCollege.setText("");
				sBirth.setText("");
				
				sName.setEditable(false);
				sSex.setEditable(false);
				sSethnic.setEditable(false);
				sBirth.setEditable(false);
				sYear.setEditable(false);
				sMajor.setEditable(false);
				sCollege.setEditable(false);
				sHome.setEditable(false);
				modifyInfo.setEnabled(false);
				return;
			}
			else{
				sNum.setText(sNum_str);
				sName.setText(s[0]);
				sSex.setText(s[1]);
				sSethnic.setText(s[2]);
				sHome.setText(s[3]);
				sYear.setText(s[4]);
				sMajor.setText(s[5]);
				sCollege.setText(s[6]);
				sBirth.setText(s[7]);

				sName.setEditable(true);
				sSex.setEditable(true);
				sSethnic.setEditable(true);
				sBirth.setEditable(true);
				sYear.setEditable(true);
				sMajor.setEditable(true);
				sCollege.setEditable(true);
				sHome.setEditable(true);
				modifyInfo.setEnabled(true);
			}
		}
	}
}
