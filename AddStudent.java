import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import java.util.*;//for random class
import javax.swing.*;
import com.toedter.calendar.JDateChooser; //for jcalender
public class AddStudent extends JFrame implements ActionListener{

	JLabel heading,name,fname,rollno,rollnolbl,dob,address,phone,email,ssc,hsc,adharno,course,branch;
	JTextField nametext,fnametext,addresstext,phonetext,emailtext,ssctext,hsctext,adharnotext;
	JDateChooser dobc;
	JComboBox coursecombo,branchcombo;
	JButton submit,cancel;
	
	Random ran=new Random();
	long no=Math.abs((ran.nextLong() % 9000L)+1000L);
	
	AddStudent()
	{
		setSize(900,700);
		setLocation(350,50);
		setLayout(null);
		
		heading=new JLabel("New Student Details");
		heading.setBounds(310,30,500,50);
		heading.setFont(new Font("Serif",Font.BOLD,30));
		add(heading);
		
		name=new JLabel("Name");
		name.setBounds(50,150,100,30);
		name.setFont(new Font("Serif",Font.BOLD,20));
		add(name);
		
		nametext=new JTextField();
		nametext.setBounds(200,150,150,30);
		add(nametext);
		
		fname=new JLabel("Father's Name");
		fname.setBounds(400,150,200,30);
		fname.setFont(new Font("Serif",Font.BOLD,20));
		add(fname);
		
		fnametext=new JTextField();
		fnametext.setBounds(600,150,150,30);
		add(fnametext);
		
		rollno=new JLabel("Roll No");
		rollno.setBounds(50,200,200,30);
		rollno.setFont(new Font("Serif",Font.BOLD,20));
		add(rollno);
		
		rollnolbl=new JLabel("1533"+no);
		rollnolbl.setBounds(200,200,200,30);
		rollnolbl.setFont(new Font("Serif",Font.BOLD,20));
		add(rollnolbl);
		
		dob=new JLabel("Date of Birth");
		dob.setBounds(400,200,200,30);
		dob.setFont(new Font("Serif",Font.BOLD,20));
		add(dob);
		
		dobc=new JDateChooser();
		dobc.setBounds(600,200,150,30);
		add(dobc);
		
		address=new JLabel("Address");
		address.setBounds(50,250,200,30);
		address.setFont(new Font("Serif",Font.BOLD,20));
		add(address);
		
		addresstext=new JTextField();
		addresstext.setBounds(200,250,150,30);
		add(addresstext);
		
		phone=new JLabel("Phone");
		phone.setBounds(400,250,200,30);
		phone.setFont(new Font("Serif",Font.BOLD,20));
		add(phone);
		
		phonetext=new JTextField();
		phonetext.setBounds(600,250,150,30);
		add(phonetext);
		
		email=new JLabel("Email ID");
		email.setBounds(50,300,200,30);
		email.setFont(new Font("Serif",Font.BOLD,20));
		add(email);
		
		emailtext=new JTextField();
		emailtext.setBounds(200,300,150,30);
		add(emailtext);
		
		ssc=new JLabel("Class X (%)");
		ssc.setBounds(400,300,200,30);
		ssc.setFont(new Font("Serif",Font.BOLD,20));
		add(ssc);
		
		ssctext=new JTextField();
		ssctext.setBounds(600,300,150,30);
		add(ssctext);
		
		hsc=new JLabel("Class XII (%)");
		hsc.setBounds(50,350,200,30);
		hsc.setFont(new Font("Serif",Font.BOLD,20));
		add(hsc);
		
		hsctext=new JTextField();
		hsctext.setBounds(200,350,150,30);
		add(hsctext);
		
		adharno=new JLabel("Adhar No");
		adharno.setBounds(400,350,200,30);
		adharno.setFont(new Font("Serif",Font.BOLD,20));
		add(adharno);
		
		adharnotext=new JTextField();
		adharnotext.setBounds(600,350,150,30);
		add(adharnotext);
		
		course=new JLabel("Course");
		course.setBounds(50,400,200,30);
		course.setFont(new Font("Serif",Font.BOLD,20));
		add(course);
		
		String coursecomboval[]= {"BA","MA","BCS","MCS","BCA","MCA","BSC","MSC"};
		coursecombo=new JComboBox(coursecomboval);
		coursecombo.setBounds(200,400,150,30);
		coursecombo.setBackground(Color.white);
		add(coursecombo);
		
		branch=new JLabel("Branch");
		branch.setBounds(400,400,200,30);
		branch.setFont(new Font("Serif",Font.BOLD,20));
		add(branch);
		
		String branchcomboval[]= {"Computer Science","Electronics","Medical","IT","Civil","Mechanical"};
		branchcombo=new JComboBox(branchcomboval);
		branchcombo.setBounds(600,400,150,30);
		branchcombo.setBackground(Color.white);
		add(branchcombo);
		
		submit=new JButton("Submit");
		submit.setBounds(250,550,120,30);
		submit.setFont(new Font("Tahoma",Font.BOLD,15));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		add(submit);
		submit.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(450,550,120,30);
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
			String sname=nametext.getText();
			String fname=fnametext.getText();
			String srollno=rollnolbl.getText();
			String sdob=((JTextField)dobc.getDateEditor().getUiComponent()).getText();
			String saddress=addresstext.getText();
			String sphone=phonetext.getText();
			String semail=emailtext.getText();
			String sssc=ssctext.getText();
			String shsc=hsctext.getText();
			String sadhar=adharnotext.getText();
			String scourse=(String)coursecombo.getSelectedItem();
			String sbranch=(String)branchcombo.getSelectedItem();
			
			try
			{
				Conn c=new Conn();
				String query="insert into student values('"+sname+"','"+fname+"','"+srollno+"','"+sdob+"','"+saddress+"','"+sphone+"','"+semail+"','"+sssc+"','"+shsc+"','"+sadhar+"','"+scourse+"','"+sbranch+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
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
		new AddStudent();

	}

}
