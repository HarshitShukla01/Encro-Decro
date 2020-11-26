package cipherpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class choice extends JFrame {
    public static void main(String[] args)
	{
            choice frame = new choice();
            frame.setVisible(true);	
	}
    public choice()
    {
        setLayout(null);
        setSize(450,360);
        setLocationRelativeTo(this);
        setTitle("Main menu");
        
         ImageIcon img1=new ImageIcon("src/images/pic4.jpg");
       JLabel l1=new JLabel(img1);
       add(l1);
       l1.setBounds(0,0,450,380);       
       setContentPane(l1);
      // setUndecorated(true);
       l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));
        Container c = getContentPane(); 
        c.setLayout(null);
        
        JLabel title = new JLabel("Click Your Choice"); 
        title.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 35)); 
        title.setSize(400, 40); 
        title.setLocation(60, 40);
        c.add(title);
        
        //Arial Rounded MT Bold
        
        JButton btn1= new JButton("ENCRYPTION");
        
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
                                dispose();
				encryptor frame = new encryptor();
				frame.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
        btn1.setFont(new Font("Bookman Old Style", Font.PLAIN, 35)); 
        btn1.setForeground(Color.BLUE);
        //btn1.setBackground(Color.DARK_GRAY);
        btn1.setSize(272, 40); 
        btn1.setLocation(70, 130);  
        c.add(btn1); 
        
        JButton btn2= new JButton("DECRYPTION");
        btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
                                dispose();
				decryptor frame = new decryptor();
				frame.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
        btn2.setFont(new Font("Bookman Old Style", Font.PLAIN, 35)); 
        btn2.setForeground(Color.BLUE);
        //btn2.setBackground(Color.GRAY);
        btn2.setSize(272, 40); 
        btn2.setLocation(70, 210);  
        c.add(btn2); 
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
