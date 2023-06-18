import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import com.toedter.calendar.JDateChooser; //for jcalender
import javax.swing.*;
import java.awt.event.*;
public class StudentLeave extends JFrame implements ActionListener{
	
	JLabel heading,rollno,date,time;
	Choice rollnochoice,timechoice;
	JDateChooser dobc;
	JButton submit,cancel;
	
	StudentLeave()
	{
		setSize(500,550);
		setLocation(550,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		heading=new JLabel("Apply Leave (Student)");
		heading.setBounds(40,50,300,30);
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		add(heading);
		
		rollno=new JLabel("Search by Roll No");
		rollno.setBounds(60,100,200,20);
		rollno.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(rollno);
		
		rollnochoice=new Choice();
		rollnochoice.setBounds(60,130,200,20);
		add(rollnochoice);
		
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
			
		date=new JLabel("Date");
		date.setBounds(60,180,200,20);
		date.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(date);
		
		dobc=new JDateChooser();
		dobc.setBounds(60,210,200,25);
		add(dobc);
		
		time=new JLabel("Time Duration");
		time.setBounds(60,260,200,20);
		time.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(time);
		
		timechoice=new Choice();
		timechoice.setBounds(60,290,200,20);
		timechoice.add("Full Day");
		timechoice.add("Half Day");
		add(timechoice);
		
		submit=new JButton("Submit");
		submit.setBounds(60,350,100,25);
		submit.setFont(new Font("Tahoma",Font.BOLD,15));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		add(submit);
		submit.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(200,350,100,25);
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
			String srollno=rollnochoice.getSelectedItem();
			String sdate=((JTextField)dobc.getDateEditor().getUiComponent()).getText();
			String stime=timechoice.getSelectedItem();
			
			try
			{
				Conn c=new Conn();
				String query="insert into studentleave values('"+srollno+"','"+sdate+"','"+stime+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Leave confirmed");
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
		new StudentLeave();
	}

}
