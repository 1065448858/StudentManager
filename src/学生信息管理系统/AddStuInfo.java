package 学生信息管理系统;


import java.awt.event.*;
import java.awt.*;

/**setNull
* 学生信息管理模块
* 添加新的学生信息
*/
public class AddStuInfo extends StuInfo {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
StuBean getSnum = new StuBean();
public AddStuInfo() {
this.setTitle("添加学生信息");
this.setResizable(false);
sNum.setEditable(true);
//sNum.setText(""+getSnum.getStuId());

sName.setEditable(true);
sSex.setEditable(true);
sSethnic.setEditable(true);
sBirth.setEditable(true);
sYear.setEditable(true);
sMajor.setEditable(true);
sCollege.setEditable(true);
sHome.setEditable(true);

//设置运行时窗口的位置
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation((screenSize.width - 400) / 2, 
(screenSize.height - 300) / 2 + 45);
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

//添加事件侦听
addInfo.addActionListener(this);
clearInfo.addActionListener(this);
eixtInfo.addActionListener(this);

this.contentPane.add(downPanel,BorderLayout.SOUTH);
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

sNum.setEnabled(false);
sName.setEnabled(false);
sSex.setEnabled(false);
sSethnic.setEnabled(false);
sBirth.setEnabled(false);
sYear.setEnabled(false);
sMajor.setEnabled(false);
sCollege.setEnabled(false);
sHome.setEnabled(false);

addInfo.setEnabled(false);
clearInfo.setEnabled(false);
eixtInfo.setEnabled(false);

StuBean addStu = new StuBean();
addStu.stuAdd(sNum.getText(),sName.getText(), sSex.getText(), sBirth.getText(), sHome.getText(), sSethnic.getText(), sYear.getText(), sMajor.getText(), sCollege.getText());

this.dispose();

AddStuInfo asi = new AddStuInfo();
asi.downInit();
asi.pack();
asi.setVisible(true);
}
else if (obj == clearInfo) { //清空
setNull();
}
}
}

