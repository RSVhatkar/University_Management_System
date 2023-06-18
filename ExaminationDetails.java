import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;
public class ExaminationDetails extends JFrame implements ActionListener{
	
	JLabel heading;
	JTextField search;
	JButton submit,cancel;
	JTable table;

	ExaminationDetails()
	{
		setSize(1000,475);
		setLocation(300,100);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
	
		heading=new JLabel("Check Result");
		heading.setBounds(80,15,400,50);
		heading.setFont(new Font("Tahoma",Font.BOLD,24));
		add(heading);
		
		search=new JTextField();
		search.setBounds(80,90,200,30);
		search.setFont(new Font("Tahoma",Font.BOLD,18));
		add(search);
		
		submit=new JButton("Result");
		submit.setBounds(300,90,120,30);
		submit.setFont(new Font("Tahoma",Font.BOLD,15));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		add(submit);
		submit.addActionListener(this);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(440,90,120,30);
		cancel.setFont(new Font("Tahoma",Font.BOLD,15));
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		add(cancel);
		cancel.addActionListener(this);
		
		table=new JTable();
		table.setFont(new Font("Tahoma",Font.PLAIN,16));
		
		JScrollPane pane=new JScrollPane(table);
		pane.setBounds(0,130,1000,310);
		add(pane);
		
		//to fetch data from student table
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
		
		//to get data of particular roll no on mouse clicked event
		//means when we click on particular row then fetch that row data
		table.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent me)
			{
				int row=table.getSelectedRow();//will fetch particular row
				search.setText(table.getModel().getValueAt(row, 2).toString());//2 means roll no is in 2col so 2
			}
		});
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			setVisible(false);
			new Marks(search.getText());
		}
		else
		{
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new ExaminationDetails();

	}

}
