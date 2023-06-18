import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.awt.event.*;
import javax.swing.*;
public class StudentFeeForm extends JFrame implements ActionListener{
	
	JLabel background,rollno,name,nametext,fname,fnametext,course,branch,semester,total,labeltotal;
	Choice rollnochoice;
	JComboBox coursecombo,branchcombo,semestercombo;
	JButton update,payfee,back;
	
	StudentFeeForm()
	{
		setSize(900,500);
		setLocation(300,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		ImageIcon img=new ImageIcon("icon/fee.jpg");
		Image i=img.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(400,50,500,300);
		add(background);
		
		rollno=new JLabel("Select Roll No");
		rollno.setBounds(40,60,150,20);
		rollno.setFont(new Font("Serif",Font.BOLD,16));
		add(rollno);
		
		rollnochoice=new Choice();
		rollnochoice.setBounds(200,60,150,20);
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
		name.setBounds(40,100,150,20);
		name.setFont(new Font("Serif",Font.BOLD,16));
		add(name);
		
		nametext=new JLabel();
		nametext.setBounds(200,100,150,20);
		nametext.setFont(new Font("Serif",Font.PLAIN,16));
		add(nametext);
		
		fname=new JLabel("Father's Name");
		fname.setBounds(40,140,150,20);
		fname.setFont(new Font("Serif",Font.BOLD,16));
		add(fname);
		
		fnametext=new JLabel();
		fnametext.setBounds(200,140,150,20);
		fnametext.setFont(new Font("Serif",Font.PLAIN,16));
		add(fnametext);
		
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
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
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
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		course=new JLabel("Course");
		course.setBounds(40,180,150,20);
		course.setFont(new Font("Serif",Font.BOLD,16));
		add(course);
		
		String coursecomboval[]= {"BTech","BSc","BCA","MTech","MSC","MCA","BCom","MCom	"};
		coursecombo=new JComboBox(coursecomboval);
		coursecombo.setBounds(200,180,150,20);
		coursecombo.setBackground(Color.white);
		add(coursecombo);
		
		branch=new JLabel("Branch");
		branch.setBounds(40,220,150,20);
		branch.setFont(new Font("Serif",Font.BOLD,16));
		add(branch);
		
		String branchcomboval[]= {"Computer Science","Electronics","Medical","IT","Civil","Mechanical"};
		branchcombo=new JComboBox(branchcomboval);
		branchcombo.setBounds(200,220,150,20);
		branchcombo.setBackground(Color.white);
		add(branchcombo);
		
		semester=new JLabel("Semester");
		semester.setBounds(40,260,150,20);
		semester.setFont(new Font("Serif",Font.BOLD,16));
		add(semester);
		
		String semestercomboval[]= {"semester1","semester2","semester3","semester4","semester5","semester6","semester7","semester8"};
		semestercombo=new JComboBox(semestercomboval);
		semestercombo.setBounds(200,260,150,20);
		semestercombo.setBackground(Color.white);
		add(semestercombo);
		
		total=new JLabel("Total Payable");
		total.setBounds(40,300,150,20);
		total.setFont(new Font("Serif",Font.BOLD,16));
		add(total);
		
		labeltotal=new JLabel();
		labeltotal.setBounds(200,300,150,20);
		labeltotal.setFont(new Font("Serif",Font.PLAIN,16));
		add(labeltotal);
		
		update=new JButton("Update");
		update.setBounds(30,380,100,25);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		add(update);
		update.addActionListener(this);
		
		payfee=new JButton("Pay Fee");
		payfee.setBounds(150,380,100,25);
		payfee.setBackground(Color.black);
		payfee.setForeground(Color.white);
		add(payfee);
		payfee.addActionListener(this);
		
		back=new JButton("Back");
		back.setBounds(270,380,100,25);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==update)
		{
			String scourse=(String)coursecombo.getSelectedItem();
			String ssemester=(String)semestercombo.getSelectedItem();
			try
			{
				Conn c=new Conn();
				String query="select * from fee where course = '"+scourse+"' ";
				ResultSet rs=c.s.executeQuery(query);
				while(rs.next())
				{
					labeltotal.setText(rs.getString(ssemester));
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==payfee)
		{
			String srollno=rollnochoice.getSelectedItem();
			String scourse=(String)coursecombo.getSelectedItem();
			String ssemester=(String)semestercombo.getSelectedItem();
			String sbranch=(String)branchcombo.getSelectedItem();
			String stotal=labeltotal.getText();
			
			try
			{
				Conn c=new Conn();
				String query="insert into collegefee values('"+srollno+"','"+scourse+"','"+sbranch+"','"+ssemester+"','"+stotal+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "College fee submitted successfully");
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
		new StudentFeeForm();

	}

}
