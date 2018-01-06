package 学生信息管理系统;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 学生管理系统主界面
 */
public class StuMain extends JFrame implements ActionListener{
	
	
	

	//建立菜单栏
	//建立“系统管理”菜单组
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel J1 = new JLabel("学生管理");
	JLabel J2 = new JLabel("课程管理");
	JLabel J3 = new JLabel("成绩管理");
	JLabel J4 = new JLabel("信息查询");
	JLabel J5 = new JLabel("学生查询");
	JLabel J6 = new JLabel("课程查询");
	JLabel J7 = new JLabel("成绩查询");
	

	JButton buttonExit = new JButton("退出");
	JButton buttonAddS = new JButton("增加");
	JButton buttonEditS=new JButton("修改");
	JButton buttonDeleteS=new JButton("删除");
	JButton buttonChooseS = new JButton("选课");
	//建立“课程管理”菜单组
	JButton buttonAddC=new JButton("增加");
	JButton buttonEditC=new JButton("修改");
	JButton buttonDeleteC=new JButton("删除");

	JButton buttonAddG=new JButton("增加");
	JButton buttonEditG=new JButton("修改");
	JButton buttonDELG=new JButton("删除");
	//建立“信息查询”菜单组

	JButton buttonSearchStuBySnum=new JButton("按学号");
	JButton buttonSearchStuBySname=new JButton("按姓名");
	JButton buttonSearchStuBySsex=new JButton("按性别");
	JButton buttonSearchStuByScollege=new JButton("按学院");
	JButton buttonSearchStuBySmajor=new JButton("按专业");

	JButton buttonSearchStuByCname=new JButton("按课程名称");
	JButton buttonSearchStuByCteacher=new JButton("按授课教师");

	JButton buttonSearchMutGrd=new JButton("查询所有成绩");
	 public StuMain() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		//添加框架的关闭事件处理
		this.pack();
		//设置框架的大小
		//设置标题
		this.setTitle("学生管理系统");
		

		
		
		try {
			

			
			this.setSize(700,400);
			this.setLocation(300,300);
			this.setResizable(false);
			this.setLayout(new GridBagLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBackground(Color.lightGray);
			
			this.getContentPane().setBackground(Color.getHSBColor(245, 245,245));





			Container mPanel = this.getContentPane();
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(10,0,0,10);

			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 10;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(J1,c);


			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(J2,c);
			
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(J3,c);
			
			c.gridx = 0;
			c.gridy = 4;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(J4,c);
			
			c.gridx = 1;
			c.gridy = 0;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonAddS,c);
			
			c.gridx = 2;
			c.gridy = 0;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonEditS,c);
			
			c.gridx = 3;
			c.gridy = 0;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonDeleteS,c);
			
			c.gridx = 4;
			c.gridy = 0;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonChooseS,c);
			
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonAddC,c);
			
			c.gridx = 2;
			c.gridy = 1;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonEditC,c);
			
			c.gridx = 3;
			c.gridy = 1;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonDeleteC,c);
			
			c.gridx = 1;
			c.gridy = 2;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonAddG,c);
			
			c.gridx = 2;
			c.gridy = 2;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonEditG,c);
			
			c.gridx = 3;
			c.gridy = 2;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonDELG,c);
			
			c.gridx = 1;
			c.gridy = 3;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(J5,c);
			
			c.gridx = 2;
			c.gridy = 3;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonSearchStuBySnum,c);
			
			c.gridx = 3;
			c.gridy = 3;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonSearchStuBySname,c);
			
			
			c.gridx = 4;
			c.gridy = 3;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonSearchStuBySsex,c);

			c.gridx = 5;
			c.gridy = 3;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonSearchStuBySmajor,c);

			c.gridx = 6;
			c.gridy = 3;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonSearchStuByScollege,c);

			c.gridx = 1;
			c.gridy = 4;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(J6,c);

			c.gridx = 2;
			c.gridy = 4;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonSearchStuByCname,c);

			c.gridx = 3;
			c.gridy = 4;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonSearchStuByCteacher,c);

			c.gridx = 1;
			c.gridy = 5;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(J7,c);

			c.gridx = 2;
			c.gridy = 5;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonSearchMutGrd,c);
			
			c.gridx = 6;
			c.gridy = 6;
			c.gridwidth = 1;
			c.fill = GridBagConstraints.BOTH;
			c.anchor = GridBagConstraints.CENTER;
			mPanel.add(buttonExit,c);

			//设置文本区域可以换行





			
			buttonExit.addActionListener(this);
			buttonAddS.addActionListener(this);
			buttonEditS.addActionListener(this);
			buttonDeleteS.addActionListener(this);
			buttonChooseS.addActionListener(this);
			
			buttonAddC.addActionListener(this);
			buttonEditC.addActionListener(this);
			buttonDeleteC.addActionListener(this);
			
			buttonAddG.addActionListener(this);
			buttonEditG.addActionListener(this);
			buttonDELG.addActionListener(this);
			
			
			buttonSearchStuBySnum.addActionListener(this);
			buttonSearchStuBySname.addActionListener(this);
			buttonSearchStuBySsex.addActionListener(this);
			buttonSearchStuByScollege.addActionListener(this);
			buttonSearchStuBySmajor.addActionListener(this);
			buttonSearchStuByCname.addActionListener(this);
			buttonSearchStuByCteacher.addActionListener(this);
			
			buttonSearchMutGrd.addActionListener(this);
			
			//关闭程序时的操作
			this.addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				}
			);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}



	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == buttonExit) { //退出
			System.exit(0);
		}
		else if (obj == buttonAddS) { //学生信息增加
			AddStuInfo asi = new AddStuInfo();
			asi.downInit();
			asi.pack();
			asi.setVisible(true);

		}
		else if (obj == buttonEditS) { //学生信息修改
			EditStuInfo esi = new EditStuInfo();
			esi.downInit();
			esi.pack();
			esi.setVisible(true);
		}
		else if (obj == buttonDeleteS) { //学生信息删出
			DelStuInfo dsi = new DelStuInfo();
			dsi.downInit();
			dsi.pack();
			dsi.setVisible(true);
		}
		else if (obj == buttonChooseS) { //学生选课
			SelectCourse sc = new SelectCourse();
			sc.downInit();
			sc.pack();
			sc.setVisible(true);
		}
		else if (obj == buttonAddC) { //课程增加
			AddCourseInfo aci = new AddCourseInfo();
			aci.downInit();
			aci.pack();
			aci.setVisible(true);
		}
		else if (obj == buttonEditC) { //课程修改
			EditCourseInfo eci = new EditCourseInfo();
			eci.downInit();
			eci.pack();
			eci.setVisible(true);
		}
		else if (obj == buttonDeleteC) { //课程删除
			DelCourseInfo dci = new DelCourseInfo();
			dci.downInit();
			dci.pack();
			dci.setVisible(true);
		}
		else if (obj == buttonAddG) { //成绩增加
			AddGradeInfo agi = new AddGradeInfo();
			agi.downInit();
			agi.pack();
			agi.setVisible(true);
		}
		else if (obj == buttonEditG) { //成绩修改
			EditGradeInfo egi = new EditGradeInfo();
			egi.downInit();
			egi.pack();
			egi.setVisible(true);
		}
		else if (obj == buttonDELG) { //成绩删除
			DelGradeInfo egi = new DelGradeInfo();
			egi.downInit();
			egi.pack();
			egi.setVisible(true);
		}
		
		//查询功能的事件处理
		else if (obj == buttonSearchStuBySnum) { //按学号查询
			StuSearchSnum ssSnum = new StuSearchSnum();
			ssSnum.pack();
			ssSnum.setVisible(true);
		}
		else if (obj == buttonSearchStuBySname) { //按学姓名查询
			StuSearchSname ssSname = new StuSearchSname();
			ssSname.pack();
			ssSname.setVisible(true);
		}
		else if (obj == buttonSearchStuBySsex) { //按性别查询
			StuSearchSsex ssSsex = new StuSearchSsex();
			ssSsex.pack();
			ssSsex.setVisible(true);
		}
		else if (obj == buttonSearchStuByScollege) { //按学院查询
			StuSearchScollege ssScollege = new StuSearchScollege();
			ssScollege.pack();
			ssScollege.setVisible(true);
		}
		else if (obj == buttonSearchStuBySmajor) { //按专业查询
			StuSearchSmajor ssSmajor = new StuSearchSmajor();
			ssSmajor.pack();
			ssSmajor.setVisible(true);
		}
		else if (obj == buttonSearchStuByCname) { //按课程名查询课程
			CourseSearchCname csCname = new CourseSearchCname();
			csCname.pack();
			csCname.setVisible(true);
		}
		else if (obj == buttonSearchStuByCteacher) { //按授课教师查询课程
			CourseSearchCteacher csCteacher = new CourseSearchCteacher();
			csCteacher.pack();
			csCteacher.setVisible(true);
		}
		else if (obj == buttonSearchMutGrd) { //查询所有科目成绩
			GrdSearchAllGrade gsag = new GrdSearchAllGrade();
			gsag.pack();
			gsag.setVisible(true);
		}
		
	}
	



	
}
