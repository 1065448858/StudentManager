# 学生信息管理系统

## 简要说明：采用eclipse开发，用jdbc驱动连接mysql，完成操作。。。留做学习和复习备用

### 开发功能有，学生信息的增删改查，学生选课的添加，成绩的增删改查

**运行前windows系统里至少有不低于jdk8的java运行环境，装有mysql数据库软件并建表
这样就就可以直接运行打包好的jar文件夹里程序了**
------
核心的类：DataBase.java,代码如下
------
```java
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
```
