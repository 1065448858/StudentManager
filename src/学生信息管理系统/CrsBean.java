package 学生信息管理系统;

import java.sql.*;
import javax.swing.*;

/**
 * 有关课程信息数据库操作的类
 */
public class CrsBean {
	String sql;
	ResultSet rs = null;

	String cNum;
	String cName;
	String cTeacher;
	String cPlace;
	String cPoint;
	String cRatio;
	String sNum;

	String colName;//列名
	String colValue;//列值
	int crsId;//新课程的编号
	
	/**
	 * 添加课程信息
	 */
	public void crsAdd(String num,String name, String teacher, String place, String type, String time){
		
		Database DB = new Database();
		this.cNum = num;
		this.cName = name;
		this.cTeacher = teacher;
		this.cPlace = place;
		this.cPoint= type;
		this.cRatio = time;

		if(cName == null||cName.equals("")){
			JOptionPane.showMessageDialog(null, "请输入课程名称", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			sql = "insert into course(cnum,cname,cteacher,cplace,cpoint,cratio) values ('"+cNum+"','"+cName+"','"+cTeacher+"','"+cPlace+"','"+cPoint+"','"+cRatio+"')";
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
	}

	/**
	 * 修改课程信息
	 */
	public void crsModify(String num, String name, String teacher, String place, String type, String time){
		Database DB = new Database();
		this.cNum = num;
		this.cName = name;
		this.cTeacher = teacher;
		this.cPlace = place;
		this.cPoint = type;
		this.cRatio = time;

		if(cName == null||cName.equals("")){
			JOptionPane.showMessageDialog(null, "请输入课程名称", "错误", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else{
			sql = "update course set cname = '"+cName+"', cTeacher = '"+cTeacher+"', cPlace = '"+cPlace+"', cpoint = '"+cPoint+"', cratio = '"+cRatio+"' where cnum = '"+cNum+"'";
			try{
				DB.OpenConn();
				DB.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"成功修改一条新的纪录！");
			}
			catch(Exception e){
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "更新失败", "错误", JOptionPane.ERROR_MESSAGE); 
			}
			finally {
				DB.closeStmt();
				DB.closeConn();
			}
		}
	}

	/**
	 * 删除课程信息
	 */
	public void crsDel(String num){
		Database DB = new Database();
		this.cNum = num;
		
		sql = "delete from course where cnum = '"+cNum+"'";
		try{
			DB.OpenConn();
			DB.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"成功删除一条新的纪录！");
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败", "错误", JOptionPane.ERROR_MESSAGE); 
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
	}

	/**
	 * 根据课程号，搜索课程名称等相关信息
	 */
	public String[] crsSearch(String num){
		Database DB = new Database();
		this.cNum = num;
		String[] s = new String[5];

		sql = "select * from course where cnum = '"+cNum+"'";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				s[0] = rs.getString("cname");
				s[1] = rs.getString("cteacher");
				s[2] = rs.getString("cplace");
				s[3] = rs.getString("cpoint");
				s[4] = rs.getString("cratio");
			}
			else
				s = null;
		}
		catch(Exception e){
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}

	/**
	 * 根据课程名称，搜索课程号
	 */
	public String[] crsNameSear(String name){
		Database DB = new Database();
		String[] s = new String[6];
		this.cName = name;
		//DB.toGBK(cName);

		sql = "select * from course where cname = '"+cName+"'";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				s[0] = rs.getString("cname");
				s[1] = rs.getString("cteacher");
				s[2] = rs.getString("cplace");
				s[3] = rs.getString("cpoint");
				s[4] = rs.getString("cratio");
				s[5] = rs.getString("cnum");
			}
			else
				s = null;
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}


	/**
	 * 根据课程名称与选课人，搜索课程相关信息
	 */
	public String[] crsNameSearch(String name,String snum){
		
		Database DB = new Database();

		this.cName = name;
		this.sNum = snum;

		String[] s = new String[6];
		sql = "select * from course,sc where cname = '"+cName+"' and sc.snum = '"+sNum+"' and course.cnum = sc.cnum";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.next()){
				s[0] = rs.getString("cnum");
				s[1] = rs.getString("cteacher");
				s[2] = rs.getString("cplace");
				s[3] = rs.getString("cpoint");
				s[4] = rs.getString("cratio");
				s[5] = rs.getString("grade");
			}
			else
				s = null;
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}

	
	/**
	 * 课程信息综合查询
	 */
	public String[][] crsAllSearch(String colname,String colvalue){
		this.colName = colname;
		this.colValue = colvalue;
		
		Database DB = new Database();
		String[][] cn = null;
		int row = 0;
		int i = 0;
		
		if(colValue == null||colValue.equals("")){
			sql = "select * from course";
		}
		else{
			sql = "select * from course where "+colName+" = '"+colValue+"'";
		}

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
				cn = new String[row][6];
				rs.first();
				rs.previous();
				while(rs.next()){
					cn[i][0] = rs.getString("cnum");
					cn[i][1] = rs.getString("cname");
					cn[i][2] = rs.getString("cteacher");
					cn[i][3] = rs.getString("cplace");
					cn[i][4] = rs.getString("cpoint");
					cn[i][5] = rs.getString("cratio");
					i++;
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return cn;
	}
	
	
	/**
	 * 获得course表中的所有课程号cnum
	 */
	public String[] getAllId(){
		
		String[] s = null;
		int row = 0;
		int i = 0;
		Database DB = new Database();

		sql = "select cnum from course";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.last()){
				row = rs.getRow();
			}
			if(row == 0){
				s = null;
			}
			else{
				s = new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					s[i] = rs.getString(1);
					i++;
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}

	/**
	 * 获得course表中的所有课程名称
	 */
	public String[] getAllName(){
		String[] s = null;
		int row = 0;
		int i = 0;
		Database DB = new Database();

		sql = "select cname from course";
		try{
			DB.OpenConn();
			rs = DB.executeQuery(sql);
			if(rs.last()){
				row = rs.getRow();
			}

			if(row == 0){
				s = null;
			}
			else{
				s = new String[row];
				rs.first();
				rs.previous();
				while(rs.next()){
					s[i] = rs.getString(1);
					i++;
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally {
			DB.closeStmt();
			DB.closeConn();
		}
		return s;
	}
}

