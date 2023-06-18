import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import com.toedter.calendar.JDateChooser; //for jcalender
import javax.swing.*;
import java.awt.event.*;
public class TeacherLeave extends JFrame implements ActionListener{
	
	JLabel heading,empid,date,time;
	Choice empidchoice,timechoice;
	JDateChooser dobc;
	JButton submit,cancel;
	
	TeacherLeave()
	{
		setSize(500,550);
		setLocation(550,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		heading=new JLabel("Apply Leave (Teacher)");
		heading.setBounds(40,50,300,30);
		heading.setFont(new Font("Tahoma",Font.BOLD,20));
		add(heading);
		
		empid=new JLabel("Search by Employee ID");
		empid.setBounds(60,100,200,20);
		empid.setFont(new Font("Tahoma",Font.PLAIN,18));
		add(empid);
		
		empidchoice=new Choice();
		empidchoice.setBounds(60,130,200,20);
		add(empidchoice);
		
		//to fetch all roll no from stude nt table in choice
		try
		{
			Conn c=new Conn();
			String query="select * from teacher";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				empidchoice.add(rs.getString("empid"));
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
			String sempid=empidchoice.getSelectedItem();
			String sdate=((JTextField)dobc.getDateEditor().getUiComponent()).getText();
			String stime=timechoice.getSelectedItem();
			
			try
			{
				Conn c=new Conn();
				String query="insert into teacherleave values('"+sempid+"','"+sdate+"','"+stime+"')";
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
		new TeacherLeave();
	}

}
