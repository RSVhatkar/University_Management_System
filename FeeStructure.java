import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;//for table
public class FeeStructure extends JFrame{

	JLabel heading;
	JTable table;
	
	FeeStructure()
	{
		setSize(1000,700);
		setLocation(250,50);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		heading=new JLabel("Fee Structure");
		heading.setBounds(50,10,400,30);
		heading.setFont(new Font("Tahoma",Font.BOLD,30));
		add(heading);
		
		table=new JTable();
		
		JScrollPane pane=new JScrollPane(table);
		pane.setBounds(0,60,1000,700);
		add(pane);
		
		//to fetch data from fee table
		try
		{
			Conn c=new Conn();
			String query="select * from fee";
			ResultSet rs=c.s.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FeeStructure();
	}

}
