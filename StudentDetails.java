import java.awt.Choice;
import java.awt.Color;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;//for table
import javax.swing.*;
import java.awt.event.*;
public class StudentDetails extends JFrame implements ActionListener{

	JLabel heading;
	Choice rollno;
	JTable table;
	JButton search,print,update,add,cancel;
	
	StudentDetails()
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
			String query="select * from student";
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
		
		add=new JButton("Add");
		add.setBounds(220,70,80,20);
		add(add);
		add.addActionListener(this);
		
		update=new JButton("Update");
		update.setBounds(320,70,80,20);
		add(update);
		update.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(420,70,80,20);
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
				String query="select * from student where rollno = '"+rollno.getSelectedItem()+"' ";
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
		else if(ae.getSource()==add)
		{
			setVisible(false);
			new AddStudent();
		}
		else if(ae.getSource()==update)
		{
			setVisible(false);
			new UpdateStudent();
		}
		else if(ae.getSource()==cancel)
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new StudentDetails();

	}

}
