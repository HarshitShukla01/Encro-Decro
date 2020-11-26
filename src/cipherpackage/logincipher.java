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


public class logincipher extends JFrame implements ActionListener{
    
    private Dbconnection db=new Dbconnection();
    private PreparedStatement ps;
    
    private JTextField namearea;
    private JPasswordField passarea;
    private JButton logbutton,signbutton;
    
    public static void main(String[] args)
	{
            logincipher frame = new logincipher();
            frame.setVisible(true);	
	}
    
    public logincipher()
    {
        setLayout(null);
        setSize(800,650);
        setLocationRelativeTo(this);        
        setTitle("Login");
       // setUndecorated(true);
       // getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
        ImageIcon img1=new ImageIcon("src/images/lg3.jpg");
        JLabel l1=new JLabel(img1);
        add(l1);
        l1.setBounds(0,0,800,650);       
        setContentPane(l1);
        l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));
        
        Container c = getContentPane(); 
        c.setLayout(null);
        
        namearea = new JTextField(); 
        namearea.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        namearea.setSize(440, 30); 
        namearea.setBorder(BorderFactory.createEmptyBorder());
        namearea.setForeground(Color.DARK_GRAY);
        namearea.setLocation(240, 258);
        c.add(namearea);
        
        passarea = new JPasswordField(); 
        passarea.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        passarea.setSize(440, 30); 
        passarea.setEchoChar('*');
        passarea.setBorder(BorderFactory.createEmptyBorder());
        passarea.setForeground(Color.DARK_GRAY);
        passarea.setLocation(240, 342);
        c.add(passarea);
        
        logbutton= new JButton(new ImageIcon()); 
        logbutton.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        logbutton.setSize(190,58); 
        logbutton.setLocation(300, 430); //220,458
        logbutton.setOpaque(false);
        logbutton.setContentAreaFilled(false);
        logbutton.setBorder(new RoundedBorder(60));
        ImageIcon icon = new ImageIcon("src/images/button4.jpg");
        logbutton.setIcon(new ImageIcon(icon.getImage().getScaledInstance(logbutton.getWidth(),logbutton.getHeight(),Image.SCALE_AREA_AVERAGING)));
        logbutton.addActionListener(this); 
        c.add(logbutton);
        
        JLabel area1 = new JLabel("Need an account? ");
        area1.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
        area1.setSize(125,20); 
        area1.setLocation(310, 500); 
        c.add(area1);        
                
                
        signbutton= new JButton("Sign up"); //new ImageIcon()
        signbutton.setFont(new Font("Times New Roman", Font.PLAIN, 15)); 
        signbutton.setSize(100,20); 
        signbutton.setForeground(Color.blue);
        signbutton.setLocation(400, 500); 
        signbutton.setOpaque(false);
        signbutton.setContentAreaFilled(false);
        signbutton.setBorderPainted(false);
        signbutton.addActionListener(this); 
        c.add(signbutton);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == logbutton)
         {
             try{
                 String s1=new String(passarea.getPassword());
                 String queryString = "SELECT * FROM login where username='"+namearea.getText()+"' and userpass= '"+s1+"';";
                 ps=db.con.prepareStatement(queryString);
                 ResultSet results = ps.executeQuery();
                
                   if(results.next()) {
                            JOptionPane.showMessageDialog(null,"Login Successfull");
                              dispose();
                              choice  frame = new choice();
	                        frame.setVisible(true);
	                      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                           }
                     else {  
                           JOptionPane.showMessageDialog(null,"Credentials are wrong"); 
                         } 
             }
             catch (Exception ex)
               {
               }
         }
         else if(e.getSource() == signbutton)
         {
             dispose();
             signup  frame = new signup();
	     frame.setVisible(true);
	     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         }
    }
}
class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}