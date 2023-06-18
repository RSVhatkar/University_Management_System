import java.awt.Choice;
import java.awt.Color;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;//for table
import javax.swing.*;
import java.awt.event.*;
public class StudentLeaveDetails extends JFrame implements ActionListener{

	JLabel heading;
	Choice rollno;
	JTable table;
	JButton search,print,cancel;
	
	StudentLeaveDetails()
	{
		setSize(1500,1000);
		setLocation(300,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		heading=new JLabel("Search by Roll No");
		heading.setBounds(20,20,150,20);
		add(heading);
		
		rollno=new Choice();
		rollno.setBounds(180,20,150,20);
		add(rollno);
		
		//to fetch all roll no from stude nt table in choice
		try
		{
			Conn c=new Conn();
			String query="select * from student";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				rollno.add(rs.getString("rollno"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		table=new JTable();
		
		//adding all student data in table
		try
		{
			Conn c=new Conn();
			String query="select * from studentleave";
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
				String query="select * from studentleave where rollno = '"+rollno.getSelectedItem()+"' ";
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
		new StudentLeaveDetails();

	}

}

