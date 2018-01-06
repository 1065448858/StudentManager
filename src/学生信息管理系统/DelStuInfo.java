package 学生信息管理系统;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 学生信息管理模块
 * 删除学生信息的类
 */
public class DelStuInfo extends StuInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String sNum_str = "";

	public DelStuInfo() {
		this.setTitle("删除学生信息");
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
		deleteInfo.setText("删除");
		deleteInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(deleteInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		searchInfo.setEnabled(true);
		deleteInfo.setEnabled(false);
		eixtInfo.setEnabled(true);

		//添加事件侦听
		searchInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		eixtInfo.addActionListener(this);

		contentPane.add(downPanel,BorderLayout.SOUTH);
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
		else if (obj == deleteInfo) { //删除
			int ifdel = JOptionPane.showConfirmDialog(null,"真的要删除该信息？","提示信息",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE );
			if(ifdel == JOptionPane.YES_OPTION){
				StuBean delStu = new StuBean();
				delStu.stuDel(sNum.getText());
				
				this.dispose();

				DelStuInfo dsi = new DelStuInfo();
				dsi.downInit();
				dsi.pack();
				dsi.setVisible(true);
			}
			else{
				return;
			}
		}
		else if (obj == searchInfo) { //学号查询
			StuInfoSearchSnum siss = new StuInfoSearchSnum(this);
			siss.pack();
			siss.setVisible(true);
			sNum_str = siss.getSnum();
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
				deleteInfo.setEnabled(false);
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
				deleteInfo.setEnabled(true);
			}
			
		}
	}
}

