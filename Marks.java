import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
public class Marks extends JFrame implements ActionListener{
	
	String rollno;
	JLabel heading,subheading,rollnolbl,semester,sub1,sub2,sub3,sub4,sub5;
	JButton cancel;
	
	Marks(String rollno)
	{
		this.rollno=rollno;
		
		setSize(500,600);
		setLocation(500,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
	
		heading=new JLabel("Delhi Technical University");
		heading.setBounds(100,10,500,25);
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		add(heading);
		
		subheading=new JLabel("Result of Examination 2022");
		subheading.setBounds(100,50,500,20);
		subheading.setFont(new Font("Tahoma",Font.BOLD,18));
		add(subheading);
		
		rollnolbl=new JLabel("Roll No "+rollno);
		rollnolbl.setBounds(60,100,500,20);
		rollnolbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(rollnolbl);
		
		semester=new JLabel();
		semester.setBounds(60,130,500,20);
		semester.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(semester);
		
		sub1=new JLabel();
		sub1.setBounds(100,200,500,20);
		sub1.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(sub1);
		
		sub2=new JLabel();
		sub2.setBounds(100,230,500,20);
		sub2.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(sub2);
		
		sub3=new JLabel();
		sub3.setBounds(100,260,500,20);
		sub3.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(sub3);
		
		sub4=new JLabel();
		sub4.setBounds(100,290,500,20);
		sub4.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(sub4);
		
		sub5=new JLabel();
		sub5.setBounds(100,320,500,20);
		sub5.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(sub5);
		
		//to fetch data of selected rollno
		try
		{
			Conn c=new Conn();
			String query="select * from subject where rollno= '"+rollno+"' ";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				sub1.setText(rs.getString("subject1"));
				sub2.setText(rs.getString("subject2"));
				sub3.setText(rs.getString("subject3"));
				sub4.setText(rs.getString("subject4"));
				sub5.setText(rs.getString("subject5"));
			}
			
			String query1="select * from marks where rollno = '"+rollno+"' ";
			ResultSet rs1=c.s.executeQuery(query1);
			while(rs1.next())
			{
				sub1.setText(sub1.getText()+"----------------"+rs1.getString("marks1"));
				sub2.setText(sub2.getText()+"----------------"+rs1.getString("marks2"));
				sub3.setText(sub3.getText()+"----------------"+rs1.getString("marks3"));
				sub4.setText(sub4.getText()+"----------------"+rs1.getString("marks4"));
				sub5.setText(sub5.getText()+"----------------"+rs1.getString("marks5"));
				semester.setText("Semester "+rs1.getString("semester"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		cancel=new JButton("Cancel");
		cancel.setBounds(250,500,120,25);
		cancel.setFont(new Font("Tahoma",Font.BOLD,15));
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		add(cancel);
		cancel.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
	}

	public static void main(String[] args) {
		new Marks("");

	}

}
