package 学生信息管理系统;

import java.awt.*;
import javax.swing.*;

/**
 * 显示成绩查询模块查询结果的类
 */
public class ResultGrade extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1 ;
	JTable jTabStuInfo;

	String sNum;
	String[] colName = {"学号","姓名","课程号","课程名称","成绩"};
	String[][] colValue;
	
	public ResultGrade(String sNum) {
		this.setTitle("成绩查询结果");
		
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);

		this.sNum = sNum;
		csBean rGrade = new csBean();
		try {
			colValue = rGrade.csAllSearch(sNum,5);	
			if(colValue == null){
				JOptionPane.showMessageDialog(null, "没有符合条件的记录"); 
				this.dispose();
			}
			else{
				jTabStuInfo = new JTable(colValue,colName);
				jScrollPane1 = new JScrollPane(jTabStuInfo);
				this.getContentPane().add(jScrollPane1,BorderLayout.CENTER);
				this.pack();
				this.setVisible(true);
			}
		}
		catch(Exception e) {
		}
	}

	
}

