import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
public class EnterMarks extends JFrame implements ActionListener{

	JLabel background,heading,rollno,semester,subject,marks;
	Choice rollnochoice;
	JComboBox semestercombo;
	JTextField sub1,sub2,sub3,sub4,sub5,marks1,marks2,marks3,marks4,marks5;
	JButton submit,cancel;
	
	EnterMarks()
	{
		setSize(1000,500);
		setLocation(300,150);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		ImageIcon img=new ImageIcon("icon/exam.jpg");
		Image i=img.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(500,40,400,300);
		add(background);
		
		heading=new JLabel("Enter Marks of Student");
		heading.setBounds(50,0,500,50);
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		add(heading);
		
		rollno=new JLabel("Select Roll No");
		rollno.setBounds(50,70,150,20);
		add(rollno);
		
		rollnochoice=new Choice();
		rollnochoice.setBounds(200,70,150,20);
		add(rollnochoice);
		
		semester=new JLabel("Semester");
		semester.setBounds(50,110,150,20);
		add(semester);
		
		String semestercomboval[]= {"1st semester","2nd semester","3rd semester","4th semester","5th semester","6th semester","7th semester","8th semester"};
		semestercombo=new JComboBox(semestercomboval);
		semestercombo.setBounds(200,110,150,20);
		semestercombo.setBackground(Color.white);
		add(semestercombo);
		
		subject=new JLabel("Enter Subject");
		subject.setBounds(100,150,200,40);
		add(subject);
		
		marks=new JLabel("Enter Marks");
		marks.setBounds(320,150,200,40);
		add(marks);
		
		sub1=new JTextField();
		sub1.setBounds(50,200,200,20);
		add(sub1);
		
		sub2=new JTextField();
		sub2.setBounds(50,230,200,20);
		add(sub2);
		
		sub3=new JTextField();
		sub3.setBounds(50,260,200,20);
		add(sub3);
		
		sub4=new JTextField();
		sub4.setBounds(50,290,200,20);
		add(sub4);
		
		sub5=new JTextField();
		sub5.setBounds(50,320,200,20);
		add(sub5);
		
		marks1=new JTextField();
		marks1.setBounds(250,200,200,20);
		add(marks1);
		
		marks2=new JTextField();
		marks2.setBounds(250,230,200,20);
		add(marks2);
		
		marks3=new JTextField();
		marks3.setBounds(250,260,200,20);
		add(marks3);
		
		marks4=new JTextField();
		marks4.setBounds(250,290,200,20);
		add(marks4);
		
		marks5=new JTextField();
		marks5.setBounds(250,320,200,20);
		add(marks5);
		
		//to fetch all roll no from stude nt table in choice
		try
		{
			Conn c=new Conn();
			String query="select * from student";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				rollnochoice.add(rs.getString("rollno"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		submit=new JButton("Submit");
		submit.setBounds(70,360,150,25);
		submit.setFont(new Font("Tahoma",Font.BOLD,15));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		add(submit);
		submit.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(280,360,150,25);
		cancel.setFont(new Font("Tahoma",Font.BOLD,15));
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		add(cancel);
		cancel.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			try
			{
				Conn c=new Conn();
				String query1="insert into subject values('"+rollnochoice.getSelectedItem()+"','"+semestercombo.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
				String query2="insert into marks values('"+rollnochoice.getSelectedItem()+"','"+semestercombo.getSelectedItem()+"','"+marks1.getText()+"','"+marks2.getText()+"','"+marks3.getText()+"','"+marks4.getText()+"','"+marks5.getText()+"')";
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
				setVisible(false);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new EnterMarks();

	}

}
