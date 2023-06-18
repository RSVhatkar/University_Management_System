import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
public class About extends JFrame{
	
	JLabel heading,background,name,contact;
	
	About()
	{
		setSize(700,500);
		setLocation(400,150);
		setLayout(null);
		
		getContentPane().setBackground(Color.white);
		
		ImageIcon img=new ImageIcon("icon/about.jpg");
		Image i=img.getImage().getScaledInstance(300,200, Image.SCALE_DEFAULT);
		ImageIcon imgnew=new ImageIcon(i);
		
		background=new JLabel("",imgnew,JLabel.CENTER);
		background.setBounds(350,0,300,200);
		add(background);
		
		heading=new JLabel("<html> University <br> Management System </html>");
		heading.setBounds(70,20,200,130);
		heading.setFont(new Font("Tahoma",Font.BOLD,30));
		add(heading);
		
		name=new JLabel("Developed By: Rajshree Vhatkar");
		name.setBounds(70,220,550,40);
		name.setFont(new Font("Tahoma",Font.BOLD,30));
		add(name);
		
		contact=new JLabel("Contact: vhatkarrajshree@gmail.com");
		contact.setBounds(70,330,550,40);
		contact.setFont(new Font("Tahoma",Font.PLAIN,30));
		add(contact);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new About();

	}

}
