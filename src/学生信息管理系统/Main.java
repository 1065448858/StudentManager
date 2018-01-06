package 学生信息管理系统;

import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) {
		//设置运行风格
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		new login();
	}

}
