import java.awt.Choice;
import java.awt.Color;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.Font;
import javax.swing.*;
import com.toedter.calendar.JDateChooser; //for jcalender
public class UpdateStudent extends JFrame implements ActionListener{

	JLabel heading,name,nametext,fname,fnametext,rollno1,rollno,rollnolbl,dob,dobc,address,phone,email,ssc,ssctext,hsc,hsctext,adharno,adharnotext,course,branch;
	JTextField addresstext,phonetext,emailtext,coursetext,branchtext;
	JButton update,cancel;
	Choice rollnochoice;
	
	UpdateStudent()
	{
		setSize(900,650);
		setLocation(350,50);
		setLayout(null);
		
		heading=new JLabel("Update Student Details");
		heading.setBounds(50,10,500,50);
		heading.setFont(new Font("Tahoma",Font.ITALIC,35));
		add(heading);
		
		rollno1=new JLabel("Select Roll No");
		rollno1.setBounds(50,100,200,20);
		rollno1.setFont(new Font("Serif",Font.PLAIN,20));
		add(rollno1);
		
		rollnochoice=new Choice();
		rollnochoice.setBounds(250,100,200,20);
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
		
		
		name=new JLabel("Name");
		name.setBounds(50,150,100,30);
		name.setFont(new Font("Serif",Font.BOLD,20));
		add(name);
		
		nametext=new JLabel();
		nametext.setBounds(200,150,150,30);
		nametext.setFont(new Font("Serif",Font.PLAIN,20));
		add(nametext);
		
		fname=new JLabel("Father's Name");
		fname.setBounds(400,150,200,30);
		fname.setFont(new Font("Serif",Font.BOLD,20));
		add(fname);
		
		fnametext=new JLabel();
		fnametext.setBounds(600,150,150,30);
		fnametext.setFont(new Font("Serif",Font.PLAIN,20));
		add(fnametext);
		
		rollno=new JLabel("Roll No");
		rollno.setBounds(50,200,200,30);
		rollno.setFont(new Font("Serif",Font.BOLD,20));
		add(rollno);
		
		rollnolbl=new JLabel();
		rollnolbl.setBounds(200,200,200,30);
		rollnolbl.setFont(new Font("Serif",Font.PLAIN,20));
		add(rollnolbl);
		
		dob=new JLabel("Date of Birth");
		dob.setBounds(400,200,200,30);
		dob.setFont(new Font("Serif",Font.BOLD,20));
		add(dob);
		
		dobc=new JLabel();
		dobc.setBounds(600,200,150,30);
		dobc.setFont(new Font("Serif",Font.PLAIN,20));
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
		
		ssctext=new JLabel();
		ssctext.setBounds(600,300,150,30);
		ssctext.setFont(new Font("Serif",Font.PLAIN,20));
		add(ssctext);
		
		hsc=new JLabel("Class XII (%)");
		hsc.setBounds(50,350,200,30);
		hsc.setFont(new Font("Serif",Font.BOLD,20));
		add(hsc);
		
		hsctext=new JLabel();
		hsctext.setBounds(200,350,150,30);
		hsctext.setFont(new Font("Serif",Font.PLAIN,20));
		add(hsctext);
		
		adharno=new JLabel("Adhar No");
		adharno.setBounds(400,350,200,30);
		adharno.setFont(new Font("Serif",Font.BOLD,20));
		add(adharno);
		
		adharnotext=new JLabel();
		adharnotext.setBounds(600,350,150,30);
		adharnotext.setFont(new Font("Serif",Font.PLAIN,20));
		add(adharnotext);
		
		course=new JLabel("Course");
		course.setBounds(50,400,200,30);
		course.setFont(new Font("Serif",Font.BOLD,20));
		add(course);
		
		coursetext=new JTextField();
		coursetext.setBounds(200,400,150,30);
		add(coursetext);
		
		branch=new JLabel("Branch");
		branch.setBounds(400,400,200,30);
		branch.setFont(new Font("Serif",Font.BOLD,20));
		add(branch);
		
		branchtext=new JTextField();
		branchtext.setBounds(600,400,150,30);
		add(branchtext);
		
		
		
		//to fetch data of selected rollno
		rollnochoice.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				//to fetch value from table
				try
				{
					Conn c=new Conn();
					String query="select * from student where rollno = '"+rollnochoice.getSelectedItem()+"' ";
					ResultSet rs=c.s.executeQuery(query);
					while(rs.next())
					{
						nametext.setText(rs.getString("name"));
						fnametext.setText(rs.getString("fname"));
						rollnolbl.setText(rs.getString("rollno"));
						dobc.setText(rs.getString("dob"));
						addresstext.setText(rs.getString("address"));
						phonetext.setText(rs.getString("phone"));
						emailtext.setText(rs.getString("emailid"));
						ssctext.setText(rs.getString("ssc"));
						hsctext.setText(rs.getString("hsc"));
						adharnotext.setText(rs.getString("adharno"));
						coursetext.setText(rs.getString("course"));
						branchtext.setText(rs.getString("branch"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		update=new JButton("Update");
		update.setBounds(250,500,120,30);
		update.setFont(new Font("Tahoma",Font.BOLD,15));
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		add(update);
		update.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(450,500,120,30);
		cancel.setFont(new Font("Tahoma",Font.BOLD,15));
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		add(cancel);
		cancel.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==update)
		{
			String sname=nametext.getText();
			String fname=fnametext.getText();
			String srollno=rollnolbl.getText();
			String sdob=dobc.getText();
			String saddress=addresstext.getText();
			String sphone=phonetext.getText();
			String semail=emailtext.getText();
			String sssc=ssctext.getText();
			String shsc=hsctext.getText();
			String sadhar=adharnotext.getText();
			String scourse=coursetext.getText();
			String sbranch=branchtext.getText();
			
			try
			{
				Conn c=new Conn();
				String query="update student set name = '"+sname+"',fname = '"+fname+"' , rollno = '"+srollno+"', dob = '"+sdob+"', address = '"+saddress+"', phone = '"+sphone+"',emailid = '"+semail+"', ssc = '"+sssc+"', hsc = '"+shsc+"', adharno = '"+sadhar+"', course = '"+scourse+"', branch = '"+sbranch+"' where rollno = '"+rollnochoice.getSelectedItem()+"' ";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
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
		new UpdateStudent();

	}

}
