package 学生信息管理系统;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 成绩信息管理模块
 * 添加新的成绩信息
 */
public class AddGradeInfo extends GradeInfo implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddGradeInfo() {
		this.setTitle("添加成绩信息");
		this.setResizable(false);

		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 +45);
	}

	public void downInit(){
		addInfo.setText("增加");
		addInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(addInfo);
		eixtInfo.setText("退出");
		eixtInfo.setFont(new Font("Dialog",0,12));
		downPanel.add(eixtInfo);

		this.contentPane.add(downPanel,BorderLayout.SOUTH);

		sNum.addActionListener(this);
		addInfo.addActionListener(this);
		eixtInfo.addActionListener(this);
	}

	/**
	 * 事件处理
	 */
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == addInfo) { //增加
			cNum.setEnabled(false);
			cName.setEditable(false);
			cTeacher.setEditable(false);
			Grade.setEditable(false);
			sNum.setEditable(false);
			sName.setEditable(false);

			addInfo.setEnabled(false);
			clearInfo.setEnabled(false);
			eixtInfo.setEnabled(false);

			csBean addGrade = new csBean();
			addGrade.csModify(cNum.getText(),(String)sNum.getSelectedItem(),Grade.getText());

			this.dispose();
			AddGradeInfo agi = new AddGradeInfo();
			agi.downInit();
			agi.pack();
			agi.setVisible(true);
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
				addInfo.setEnabled(false);
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
			addInfo.setEnabled(true);
			cName.setEnabled(false);
			cName.removeActionListener(this);
		}
	}
}

