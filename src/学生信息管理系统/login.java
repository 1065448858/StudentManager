package 学生信息管理系统;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class login extends javax.swing.JFrame {
    public login() {
        init();
    }
    //初始化login组件
    private void init() {
        JPanel jPanel1 = new JPanel();//面板1，用于放用户名,输入框
        JPanel jPanel2 = new JPanel();//面板2，用于放密码，输入框
        JPanel jPanel3 = new JPanel();//面板3，用于放ok exit 按钮
        JLabel jLabel1 = new JLabel("用户名:");//标签1（用户名），嵌在jPane1
        JLabel jLabel2 = new JLabel("密  码: ");//标签2（密码），嵌在jPane2
        JTextField Username = new JTextField(10);//用户名输入框，嵌在jPane1
        JPasswordField Password = new JPasswordField(10);//密码输入框，嵌在jPane2
        JButton Login = new JButton("登录");//登录按钮，嵌在jPane4
        JButton Exit = new JButton("退出");//退出按钮，嵌在jPane4

        jLabel1.setFont(new java.awt.Font("微软雅黑", Font.PLAIN, 14));
        jLabel2.setFont(new java.awt.Font("微软雅黑", Font.PLAIN, 14));
        Login.setFont(new java.awt.Font("微软雅黑", Font.PLAIN, 14));
        Exit.setFont(new java.awt.Font("微软雅黑",Font.PLAIN, 14));
        Username.setToolTipText("在此处输入用户名");
        Password.setToolTipText("在此处输入密码");


        //布局管理器（GridLayout）
        this.setLayout(new GridLayout(4, 3));
        jPanel1.add(jLabel1);
        jPanel1.add(Username);
        jPanel2.add(jLabel2);
        jPanel2.add(Password);

 
        
        jPanel3.add(Login);
        jPanel3.add(Exit);

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
       

        this.setTitle("用户登录");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        //Exit动作

        Exit.addActionListener(e ->System.exit(0));

        //密码框回车等于点击登录
        Password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(e.getKeyChar()=='\n'){
                    Login.doClick();
                }
            }
        });
        //Login动作

        Login.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                String user = Username.getText().trim();

                String pass = Password.getText().trim();
                String un1 = "admin";
			    String pw1 = "admin";
                

                if (user.length() == 0 && pass.length() == 0) {
                    JOptionPane.showMessageDialog(null, "用户名和密码不能为空！", "提示消息！", JOptionPane.WARNING_MESSAGE);
                } else if (user.length() == 0) {
                    JOptionPane.showMessageDialog(null, "用户名不能为空！", "提示消息！", JOptionPane.WARNING_MESSAGE);
                } else if (pass.length() == 0) {
                    JOptionPane.showMessageDialog(null, "密码不能为空！", "提示消息！", JOptionPane.WARNING_MESSAGE);
                } else if(user.equals(un1)&pass.equals(pw1)){
                	    setVisible(false);
                        new StuMain().setVisible(true);;
						}else if(!user.equals(un1)||!pass.equals(pw1)){
							JOptionPane.showMessageDialog(null, "用户名或者密码错误！", "提示消息！", JOptionPane.WARNING_MESSAGE);
	                	    Username.setText("");
	                	    Password.setText("");
							}
                    
                }
            });
        }
}
                

            
            
  


        
    








  

        







