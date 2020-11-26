/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherpackage;

/**
 *
 * @author user
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import java.sql.*;


public class signup extends JFrame implements ActionListener {
    
    private Dbconnection db=new Dbconnection();
    private PreparedStatement ps;
    
    private JTextField username,emailid;
    private JButton register;
    private JPasswordField pass,confpass;
    public static void main(String[] args)
	{
            signup frame = new signup();
            frame.setVisible(true);	
	}
    
    public signup()
    {
        setLayout(null);
        setSize(600,750);//600,750
        setLocationRelativeTo(this);        
        setTitle("Sign Up");
        
        ImageIcon img1=new ImageIcon("src/images/x3.jpg");
        JLabel l1=new JLabel(img1);
        add(l1);
        l1.setBounds(0,0,600,750);       
        setContentPane(l1);
        l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));
        
        Container c = getContentPane(); 
        c.setLayout(null);
        
        JLabel area1 = new JLabel(new ImageIcon("src/images/Untitled.png"));
        area1.setSize(240,80);
        area1.setLocation(160, 120); 
        c.add(area1);
        
        username = new JTextField("Username"); 
        username.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        username.setSize(320, 30); 
        
        username.setBorder(BorderFactory.createEmptyBorder());
        username.setForeground(Color.LIGHT_GRAY);
        username.setLocation(150, 271);
        username.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                  if(emailid.getText().isEmpty()) 
                  {
                      emailid.setForeground(Color.LIGHT_GRAY);
                      emailid.setText("Emailid");
                  }
                  
                  if(new String(pass.getPassword()).isEmpty()) 
                  {
                      pass.setForeground(Color.LIGHT_GRAY);
                      pass.setEchoChar((char) 0);
                      pass.setText("Password");
                  }         
                  if(new String(confpass.getPassword()).isEmpty()) 
                  {
                      confpass.setForeground(Color.LIGHT_GRAY);
                      confpass.setEchoChar((char) 0);
                      confpass.setText("Confirm password");
                  }
                  username.setForeground(Color.black);
              if(username.getText().equals("Username"))username.setText("");
                }
        });
        c.add(username);
        
        emailid = new JTextField("Emailid"); 
        emailid.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        emailid.setForeground(Color.LIGHT_GRAY);
        emailid.setSize(320, 30); 
        emailid.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                  if(username.getText().isEmpty()) 
                  {
                      username.setForeground(Color.LIGHT_GRAY);
                      username.setText("Username");
                  }
                  
                  if(new String(pass.getPassword()).isEmpty()) 
                  {
                      pass.setForeground(Color.LIGHT_GRAY);
                      pass.setEchoChar((char) 0);
                      pass.setText("Password");
                  }         
                  if(new String(confpass.getPassword()).isEmpty()) 
                  {
                      confpass.setForeground(Color.LIGHT_GRAY);
                      confpass.setEchoChar((char) 0);
                      confpass.setText("Confirm password");
                  }
                  emailid.setForeground(Color.black);
                  if(emailid.getText().equals("Emailid"))emailid.setText("");
                }
        });
        emailid.setBorder(BorderFactory.createEmptyBorder());
       
        emailid.setLocation(150, 359);
        c.add(emailid);
        
        pass = new JPasswordField("Password"); 
        pass.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        pass.setForeground(Color.LIGHT_GRAY);
        pass.setSize(320, 30); 
        pass.setEchoChar((char) 0);
        pass.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                  if(username.getText().isEmpty()) 
                  {
                      username.setForeground(Color.LIGHT_GRAY);
                      username.setText("Username");
                  }
                  if(emailid.getText().isEmpty()) 
                  {
                      emailid.setForeground(Color.LIGHT_GRAY);
                      emailid.setText("Emailid");
                  }
                           
                  if(new String(confpass.getPassword()).isEmpty()) 
                  {
                      confpass.setForeground(Color.LIGHT_GRAY);
                      confpass.setEchoChar((char) 0);
                      confpass.setText("Confirm password");
                  }
                  pass.setForeground(Color.black);
                  pass.setEchoChar('*');
                  if(new String(pass.getPassword()).equals("Password"))pass.setText("");
                }
        });
        pass.setBorder(BorderFactory.createEmptyBorder());
    
        pass.setLocation(150, 445);
        c.add(pass);
        
        confpass =  new JPasswordField("Confirm password");
        confpass.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        confpass.setForeground(Color.LIGHT_GRAY);
        
        confpass.setSize(320, 30); 
        confpass.setEchoChar((char) 0);
        confpass.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                  if(username.getText().isEmpty()) 
                  {
                      username.setForeground(Color.LIGHT_GRAY);
                      username.setText("Username");
                  }
                   if(emailid.getText().isEmpty()) 
                  {
                      emailid.setForeground(Color.LIGHT_GRAY);
                      emailid.setText("Emailid");
                  }
                  
                  if(new String(pass.getPassword()).isEmpty()) 
                  {
                      pass.setForeground(Color.LIGHT_GRAY);
                      pass.setEchoChar((char) 0);
                      pass.setText("Password");
                  }
                  confpass.setForeground(Color.black);
                 confpass.setEchoChar('*');
                 if(new String(confpass.getPassword()).equals("Confirm password"))confpass.setText("");
                }
        });
        
        confpass.setBorder(BorderFactory.createEmptyBorder());
        confpass.setLocation(150, 533);
        c.add(confpass);
        
        register= new JButton(new ImageIcon());
        register.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        register.setSize(190,45); 
        register.setLocation(185, 595); 
        register.setForeground(Color.BLUE);
        ImageIcon icon1 = new ImageIcon("src/images/regbutton1.jpg");
        register.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(register.getWidth(),register.getHeight(),Image.SCALE_AREA_AVERAGING)));
        register.addActionListener(this); 
        c.add(register);
        
        JLabel area2 = new JLabel("Already have account?");
        area2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        area2.setSize(140,20);
        area2.setLocation(190, 650); 
        c.add(area2);
        
        JButton logup = new JButton("Log in");
        logup.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
        logup.setSize(80,20); 
        logup.setLocation(310, 650); //960,620
        logup.setForeground(Color.BLUE);
        logup.setOpaque(false);
        logup.setContentAreaFilled(false);
        logup.setBorderPainted(false);
        logup.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
                                dispose();
				logincipher frame = new logincipher();
				frame.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}); 
        c.add(logup);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
     public void actionPerformed(ActionEvent e) {
         if(e.getSource() == register)
         {
             String s1=username.getText();
             String s2=emailid.getText();
             String s3= new String(pass.getPassword());
             String s4=new String(confpass.getPassword());
             
            if(s1.isEmpty()||s1.equals("Username"))
            {
                JOptionPane.showMessageDialog(null,"Username is empty or invalid");
            }
            else if(s2.isEmpty()||s2.equals("Emailid"))
            {
                JOptionPane.showMessageDialog(null,"Emailid is empty or invalid");
            }
            else if(s3.equals("Password")||s3.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Fill password with appropriate text");
            }
            else if(s4.equals("Confirm password")||s4.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Fill confirm password with appropriate text");
            }
            else if(!s3.equals(s4))
            {
                JOptionPane.showMessageDialog(null,"confirm password is wrong");
            }
            else
            {
                try{
                ps=db.con.prepareStatement("insert into login(username,email,userpass)values('"+s1+"','"+s2+"','"+s3+"')");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Registration Successfull");
                dispose();
				logincipher frame = new logincipher();
				frame.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                }
               catch (Exception ex)
               {
               }
            }
            
         }
     }
}
