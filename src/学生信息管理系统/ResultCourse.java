package 学生信息管理系统;
import java.awt.*;
import javax.swing.*;


/**
 * 显示课程查询模块查询结果的类
 */
public class ResultCourse extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel jLabel1 = new JLabel();
	JButton jBExit = new JButton();
	JScrollPane jScrollPane1 ;
	JTable jTabStuInfo;
	String[] colName = {"课程号","课程名称","授课老师","上课地点","课程学分","课程系数"};
	String[][] colValue;
	String sColValue;
	String sColName;
	
	public ResultCourse(String colname,String colvalue) {
		this.sColValue = colvalue;
		this.sColName = colname;

		this.setTitle("课程查询结果");
		
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 200) / 2 ,
						(int) (screenSize.height - 300) / 2 + 45);
		CrsBean rCrs = new CrsBean();
		try {
			colValue = rCrs.crsAllSearch(sColName,sColValue);
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
