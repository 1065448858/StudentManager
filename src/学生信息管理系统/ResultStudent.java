package 学生信息管理系统;

import java.awt.*;
import javax.swing.*;

/**
 * 显示学生查询模块查询结果的类
 */
public class ResultStudent extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1 ;
	JTable jTabStuInfo;

	String sNum;
	String[] colName = {"学号","姓名","性别","民族","籍贯","入学年份","专业","学院","出生日期"};
	String[][] colValue;
	String sColValue;
	String sColName;
	String sFromValue;
	String sToValue;
	
	String sCourse;
	
	public ResultStudent(String colname,String colvalue) {
		this.sColValue = colvalue;
		this.sColName = colname;

		this.setTitle("学生信息查询结果");
		
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
		//this.setSize(500, 500);
		StuBean rStu = new StuBean();
		try {
			colValue = rStu.stuAllSearch(sColName,sColValue);
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
			e.printStackTrace();
		}
	}

	public ResultStudent(String colname,String fromvalue,String tovalue) {
		this.sColName = colname;
		this.sFromValue = fromvalue;
		this.sToValue = tovalue;

		this.setTitle("学生信息查询结果");
		
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
		StuBean rStu = new StuBean();
		try {
			colValue = rStu.stuAllSearch(sColName,sFromValue,sToValue);
			if(colValue == null){
				this.dispose();
				JOptionPane.showMessageDialog(null, "没有符合条件的记录"); 	
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
			e.printStackTrace();
		}
	}

	
	public ResultStudent(String course) {
		this.sCourse = course;

		this.setTitle("学生信息查询结果");
		
		//设置运行位置，使对话框居
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
		StuBean rStu = new StuBean();
		try {
			colValue = rStu.stuSearchBySimple(sCourse);
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
			e.printStackTrace();
		}
	}
	
	public ResultStudent() {
		this.setTitle("学生信息查询结果");
		
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 400) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
		StuBean rStu = new StuBean();
		try {
			colValue = rStu.stuSearchBypoint();
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
			e.printStackTrace();
		}
	}
	
	
}
