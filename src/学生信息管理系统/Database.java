package 学生信息管理系统;

import java.sql.*;

/**
 * 连接数据库的类
 */
public class Database {
	
	private Statement stmt=null;
	ResultSet rs=null;
	private Connection conn=null;
	String sql;
	String strurl="jdbc:mysql://127.0.0.1:3306/studentsys?characterEncoding=utf8&useSSL=true";
	
	public Database(){
	}
	
	/**
	 * 打开数据库连接
	 */
	public void OpenConn()throws Exception{
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			conn=DriverManager.getConnection(strurl,"root","5201314qaz,./");
			conn.setAutoCommit(false);
		}
		catch(Exception e){ 
			System.err.println("OpenConn:"+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 执行sql语句，返回结果集rs
	 */
	public ResultSet executeQuery(String sql){
		stmt = null;
		rs=null;

		try{
			
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("executeQuery:"+e.getMessage());
			e.printStackTrace();
		}
		return rs;
		 
	}

	/**
	 * 执行sql语句
	 */
	public int executeUpdate(String sql){
		stmt=null;
        rs=null;
        int k=0;
		try{
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			k=stmt.executeUpdate(sql);
			conn.commit();
		}
		catch(SQLException e){
			System.err.println("executeUpdate:"+e.getMessage()); 
			e.printStackTrace();
		}
		return k;
	}
	
	public void closeStmt(){
		try{
			stmt.close();
		}
		catch(SQLException e){
			System.err.println("closeStmt:"+e.getMessage()); 
		}
	}

	/**
	 * 关闭数据库连接
	 */
	public void closeConn(){
		try{
			conn.close();
		}
		catch(SQLException ex){
			System.err.println("aq.closeConn:"+ex.getMessage()); 
		}
	}
	
	
}

