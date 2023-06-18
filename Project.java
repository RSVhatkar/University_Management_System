import java.awt.Color;
import java.awt.event.*;
import java.awt.Image;

import javax.swing.*;
public class Project extends JFrame implements ActionListener{
	
	JLabel background;

	Project()
	{
		setSize(1540,850);
		
		ImageIcon img=new ImageIcon("icon/third.jpg");
		Image i=img.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		add(background);
		
		JMenuBar mb=new JMenuBar();
		setJMenuBar(mb);
		
		//new information
		JMenu newInformation=new JMenu("New Information");
		newInformation.setForeground(Color.blue);
		mb.add(newInformation);
		
		JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
		facultyInfo.setBackground(Color.white);
		facultyInfo.addActionListener(this);
		newInformation.add(facultyInfo);
		
		JMenuItem studentinfo=new JMenuItem("New Student Information");
		studentinfo.setBackground(Color.white);
		studentinfo.addActionListener(this);
		newInformation.add(studentinfo);
		
		//details
		JMenu details=new JMenu("View Details");
		details.setForeground(Color.red);
		mb.add(details);
		
		JMenuItem facultydetails=new JMenuItem("View Faculty Details");
		facultydetails.setBackground(Color.white);
		facultydetails.addActionListener(this);
		details.add(facultydetails);
		
		JMenuItem studentdetails=new JMenuItem("View Student Details");
		studentdetails.setBackground(Color.white);
		studentdetails.addActionListener(this);
		details.add(studentdetails);
		
		//leave
		JMenu leave=new JMenu("Leave");
		leave.setForeground(Color.blue);
		mb.add(leave);
		
		JMenuItem facultyleave=new JMenuItem("Faculty Leave");
		facultyleave.setBackground(Color.white);
		leave.add(facultyleave);
		facultyleave.addActionListener(this);
		
		JMenuItem studentleave=new JMenuItem("Student Leave");
		studentleave.setBackground(Color.white);
		leave.add(studentleave);
		studentleave.addActionListener(this);
		
		//leave details
		JMenu leavedetails=new JMenu("Leave Details");
		leavedetails.setForeground(Color.red);
		mb.add(leavedetails);
		
		JMenuItem facultyleavedetails=new JMenuItem("Faculty Leave Details");
		facultyleavedetails.setBackground(Color.white);
		leavedetails.add(facultyleavedetails);
		facultyleavedetails.addActionListener(this);
		
		JMenuItem studentleavedetails=new JMenuItem("Student Leave Details");
		studentleavedetails.setBackground(Color.white);
		leavedetails.add(studentleavedetails);
		studentleavedetails.addActionListener(this);
		
		//exam
		JMenu exam=new JMenu("Examination");
		exam.setForeground(Color.blue);
		mb.add(exam);
		
		JMenuItem examinationdetails=new JMenuItem("Examination Results");
		examinationdetails.setBackground(Color.white);
		exam.add(examinationdetails);
		examinationdetails.addActionListener(this);
		
		JMenuItem entermarks=new JMenuItem("Enter Marks");
		entermarks.setBackground(Color.white);
		exam.add(entermarks);
		entermarks.addActionListener(this);
		
		//update info
		JMenu updateinfo=new JMenu("Update Details");
		updateinfo.setForeground(Color.red);
		mb.add(updateinfo);
		
		JMenuItem updatefacultyinfo=new JMenuItem("Update Faculty Details");
		updatefacultyinfo.setBackground(Color.white);
		updateinfo.add(updatefacultyinfo);
		updatefacultyinfo.addActionListener(this);
		
		JMenuItem updatestudentinfo=new JMenuItem("Update Student Details");
		updatestudentinfo.setBackground(Color.white);
		updateinfo.add(updatestudentinfo);
		updatestudentinfo.addActionListener(this);
		
		//fee
		JMenu fee=new JMenu("Fee Details");
		fee.setForeground(Color.blue);
		mb.add(fee);
		
		JMenuItem feestructure=new JMenuItem("Fee Structure");
		feestructure.setBackground(Color.white);
		fee.add(feestructure);
		feestructure.addActionListener(this);
		
		JMenuItem feeform=new JMenuItem("Fee Form");
		feeform.setBackground(Color.white);
		fee.add(feeform);
		feeform.addActionListener(this);
		
		//utility
		JMenu utility=new JMenu("Utility");
		utility.setForeground(Color.red);
		mb.add(utility);
		
		JMenuItem notepad=new JMenuItem("Notepad");
		notepad.setBackground(Color.white);
		notepad.addActionListener(this);
		utility.add(notepad);
		
		JMenuItem calc=new JMenuItem("Calculator");
		calc.setBackground(Color.white);
		calc.addActionListener(this);
		utility.add(calc);
		
		//about
		JMenu about=new JMenu("About");
		about.setForeground(Color.blue);
		mb.add(about);
				
		JMenuItem ab=new JMenuItem("About");
		ab.setBackground(Color.white);
		ab.addActionListener(this);
		about.add(ab);
		ab.addActionListener(this);
		
		//exit
		JMenu exit=new JMenu("Exit");
		exit.setForeground(Color.red);
		mb.add(exit);
		
		JMenuItem ex=new JMenuItem("Exit");
		ex.setBackground(Color.white);
		ex.addActionListener(this);
		exit.add(ex);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String msg=ae.getActionCommand();
		
		if(msg.equals("Exit"))
		{
			setVisible(false);
		}
		else if(msg.equals("Calculator"))
		{
			try
			{
				Runtime.getRuntime().exec("calc.exe");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(msg.equals("Notepad"))
		{
			try
			{
				Runtime.getRuntime().exec("notepad.exe");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(msg.equals("New Faculty Information"))
		{
			new AddTeacher();
		}
		else if(msg.equals("New Student Information"))
		{
			new AddStudent();
		}
		else if(msg.equals("View Faculty Details"))
		{
			new TeacherDetails();
		}
		else if(msg.equals("View Student Details"))
		{
			new StudentDetails();
		}
		else if(msg.equals("Faculty Leave"))
		{
			new TeacherLeave();
		}
		else if(msg.equals("Student Leave"))
		{
			new StudentLeave();
		}
		else if(msg.equals("Faculty Leave Details"))
		{
			new TeacherLeaveDetails();
		}
		else if(msg.equals("Student Leave Details"))
		{
			new StudentLeaveDetails();
		}
		else if(msg.equals("Update Faculty Details"))
		{
			new UpdateTeacher();
		}
		else if(msg.equals("Update Student Details"))
		{
			new UpdateStudent();
		}
		else if(msg.equals("Enter Marks"))
		{
			new EnterMarks();
		}
		else if(msg.equals("Examination Results"))
		{
			new ExaminationDetails();
		}
		else if(msg.equals("Fee Structure"))
		{
			new FeeStructure();
		}
		else if(msg.equals("About"))
		{
			new About();
		}
		else if(msg.equals("Fee Form"))
		{
			new StudentFeeForm();
		}
	}
	
	public static void main(String[] args) {
		new Project();

	}

}
