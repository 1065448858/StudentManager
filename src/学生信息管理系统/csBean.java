package 学生信息管理系统;

import java.util.*;
import java.sql.*;
import javax.swing.*;

/**
 * 成绩选课方面的类
 */
public class csBean {
	String sql;
	ResultSet rs;
	Vector<?> tempvector=new Vector<Object>(1,1);

	String cNum;
	String sNum;
	float grade;

	int colNum;

	/**
	 * 添加学生的选课信息
	 */
	public void csAdd(String cnum, String snum){
		
		Database DB = new Database();

		this.cNum = cnum;
		this.sNum = snum;
		//Integer.parseInt(String)就是将String字符类型数据转换为Integer整型数据。
		//Integer.parseInt(String)遇到一些不能被转换为整型的字符时，会抛出异常。

		sql = "insert into sc(cnum,snum) values ("+Integer.parseInt(cNum)+","+Integer.parseInt(sNum)+")";
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"成功添加一条新的纪录！");

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "保存失败", "错误", JOptionPane.ERROR_MESSAGE); 
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}

	/**
	 * 修改学生的选课成绩
	 */
	public void csModify(String cnum, String snum, String grade){
		Database DB = new Database();
		this.cNum = cnum;
		this.sNum = snum;

		try{
			this.grade = Float.parseFloat(grade);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "成绩输入错误", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}

		sql = "update sc set grade = "+grade+" where snum = "+Integer.parseInt(sNum)+" and cnum = "+Integer.parseInt(cNum)+" ";
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"成功登记成绩！");
		}
		catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "登记失败", "错误", JOptionPane.ERROR_MESSAGE); 
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}
	
	/**
	 * 删除学生的选课成绩
	 */
	public void csdel(String cnum, String snum){
		Database DB = new Database();
		this.cNum = cnum;
		this.sNum = snum;

		

		sql = "delete from sc  where snum = "+Integer.parseInt(sNum)+" and cnum = "+Integer.parseInt(cNum)+" ";
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"成功删除成绩！");
		}
		catch(Exception e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "删除失败", "错误", JOptionPane.ERROR_MESSAGE); 
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}

	/**
	 * 根据学号搜索其所选的课程名称
	 */
	public String[] cNameSearch(String snum){
		Database DB = new Database();
		this.sNum = snum;

		sql = "select * from sc,course where sc.snum = "+Integer.parseInt(sNum)+" and sc.cnum = course.cnum";
		String[] cn = null;
		int row = 0;
		int i = 0;
		
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.last()){
				row = rs.getRow();
			}
			if(row == 0){
				cn = null;
			}
			else{
				cn = new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					cn[i] = rs.getString(5);
					i++;
				}
			}
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return cn;
	}

	/**
	 * 成绩信息综合查询
	 */
	public String[][] csAllSearch(String snum, int colnum){
		this.sNum = snum;
		this.colNum = colnum;
		
		Database DB = new Database();
		String[][] cn = null;
		int row = 0;
		int i = 0;
		sql = "select * from sc,course,student where sc.snum = "+Integer.parseInt(sNum)+" and sc.cnum = course.cnum and sc.snum = student.snum";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);

			if(rs.last()){
				row = rs.getRow();
			}
			if(row == 0){
				cn = null;
			}
			else{
				cn = new String[row][colNum];
				rs.first();
				rs.previous();
				while(rs.next()){
					cn[i][0] = rs.getString(1);
					cn[i][1] = rs.getString(11);
					cn[i][2] = rs.getString(2);
					cn[i][3] = rs.getString(5);
					cn[i][4] = rs.getString(3);
					i++;
				}
			}
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return cn;
	}
}
