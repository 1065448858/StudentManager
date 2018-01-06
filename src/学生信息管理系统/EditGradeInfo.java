package 学生信息管理系统;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 成绩信息管理模块
 * 修改成绩信息的类
 */
public class EditGradeInfo extends GradeInfo implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditGradeInfo() {
		this.setTitle("修改成绩信息");
		this.setResizable(false);

		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 +45);
	}

	public void downInit(){
		modifyInfo.setText("修改");
		modifyInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(modifyInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);

		sNum.addActionListener(this);
		modifyInfo.addActionListener(this);
		clearInfo.addActionListener(this);
		eixtInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == modifyInfo) { //修改
			cNum.setEnabled(false);
			cName.setEditable(false);
			cTeacher.setEditable(false);
			Grade.setEditable(false);
			sNum.setEditable(false);
			sName.setEditable(false);

			modifyInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			eixtInfo.setEnabled(false);

			csBean addGrade = new csBean();
			addGrade.csModify(cNum.getText(),(String)sNum.getSelectedItem(),Grade.getText());

			this.dispose();
			EditGradeInfo egi = new EditGradeInfo();
			egi.downInit();
			egi.pack();
			egi.setVisible(true);
		}
		else if (obj == eixtInfo) { //退出
			this.dispose();
		}
		else if (obj == sNum) { //选择学号
			StuBean sN = new StuBean();
			sName.setText(sN.stuSearch((String)sNum.getSelectedItem())[0]);

			if(cName.getItemCount()>0){
				cName.removeAllItems();
			}
			
			csBean cN = new csBean();
			cReturn = cN.cNameSearch((String)sNum.getSelectedItem());
			
			if(cReturn == null){
				cName.removeActionListener(this);
				JOptionPane.showMessageDialog(null,"该学生没有选择课程！");
				modifyInfo.setEnabled(false);
				cName.setEnabled(false);
			}
			else{
				int i = 0;
				for(i = 0; i < (cReturn.length); i++){
					cName.addItem(cReturn[i]);
				}

				cName.setEnabled(true);
				sNum.setEnabled(false);
				cName.setSelectedItem(null);
				cName.addActionListener(this);
			}
		}
		else if (obj == cName) { //选择课程号
			CrsBean cSname = new CrsBean();
			cNum.setText(cSname.crsNameSearch((String)cName.getSelectedItem(),(String)sNum.getSelectedItem())[0]);
			cTeacher.setText(cSname.crsNameSearch((String)cName.getSelectedItem(),(String)sNum.getSelectedItem())[1]);
			Grade.setText("");
			Grade.setText(cSname.crsNameSearch((String)cName.getSelectedItem(),(String)sNum.getSelectedItem())[5]);
			modifyInfo.setEnabled(true);
			
			cName.setEnabled(false);
		}
	}
}
