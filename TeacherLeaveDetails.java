import java.awt.Choice;
import java.awt.Color;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;//for table
import javax.swing.*;
import java.awt.event.*;
public class TeacherLeaveDetails extends JFrame implements ActionListener{

	JLabel heading;
	Choice empid;
	JTable table;
	JButton search,print,cancel;
	
	TeacherLeaveDetails()
	{
		setSize(1500,1000);
		setLocation(300,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		heading=new JLabel("Search by Employee ID");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		empid=new Choice();
		empid.setBounds(180,20,150,20);
		add(empid);
		
		//to fetch all roll no from stude nt table in choice
		try
		{
			Conn c=new Conn();
			String query="select * from teacher";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				empid.add(rs.getString("empid"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		table=new JTable();
		
		//adding all teacher data in table
		try
		{
			Conn c=new Conn();
			String query="select * from teacherleave";
			ResultSet rs=c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JScrollPane pane=new JScrollPane(table);
		pane.setBounds(0,100,1500,900);
		add(pane);
		
		search=new JButton("Search");
		search.setBounds(20,70,80,20);
		add(search);
		search.addActionListener(this);
		
		print=new JButton("Print");
		print.setBounds(120,70,80,20);
		add(print);
		print.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(220,70,80,20);
		add(cancel);
		cancel.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==search)
		{
			try
			{
				Conn c=new Conn();
				String query="select * from teacherleave where rollno = '"+empid.getSelectedItem()+"' ";
				ResultSet rs=c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(ae.getSource()==print)
		{
			try
			{
				table.print();
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
		new TeacherLeaveDetails();

	}

}


