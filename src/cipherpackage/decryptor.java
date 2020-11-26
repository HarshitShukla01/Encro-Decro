package cipherpackage;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

public class decryptor extends JFrame implements ActionListener {
    private JButton submit,close,openfile;
    private JLabel selectadd,labeld;
    private String showing,patt,satt,datt;
    private JTextField aread;
    
     private String type1(String s)
     {
        StringBuilder sb=new StringBuilder();
	for(int i=0;i<s.length();i++)
        {
          sb.append((char)(s.charAt(i)-1));
        }
             
         return sb.toString();
     }
    
    private String type2(String s)
     {
        StringBuilder sb=new StringBuilder();
	for(int i=0;i<s.length();i++)
        {
          sb.append((char)(s.charAt(i)-2));
        }
        return sb.toString();
     }
    
    private String type3(String s)
     {
        StringBuilder sb=new StringBuilder();
	for(int i=0;i<s.length();i++)
        {
          sb.append((char)(s.charAt(i)-3));
        }
        
        return sb.toString();
        
     }
    
    private String decry()
    {
      String sk="",pk="",dk="";
      int pkey,dkey,c,t,dec,r;
      if(satt.charAt(0)=='@') sk=type1(satt.substring(1,3));
      else if(satt.charAt(0)=='$') sk=type2(satt.substring(1,3));
      else if(satt.charAt(0)=='#') sk=type3(satt.substring(1,3));
      
      if(sk.charAt(0)=='1') pk=type1(patt);
      else if(sk.charAt(0)=='2') pk=type2(patt);
      else if(sk.charAt(0)=='3') pk=type3(patt);
      
      c=sk.charAt(1)-'0';
      r=pk.charAt(0)-'0';
      t=pk.charAt(1)-'0';
      
      dec=r+c-t;
      
      if(dec==1) dk=type1(datt);
      else if(dec==2) dk=type2(datt);
      else if(dec==3) dk=type3(datt);
      
      
      return dk;  
    }   
    
    public static void main(String[] args)
	{
            decryptor frame = new decryptor();
            frame.setVisible(true);	
	}
    
    public decryptor()
    {
        setLayout(null);
        setSize(1200,750);
        setLocationRelativeTo(this);        
        setTitle("Decryption");
        
        ImageIcon img1=new ImageIcon("src/images/x1.jpg");
        JLabel l1=new JLabel(img1);
        add(l1);
        l1.setBounds(0,0,1200,750);       
        setContentPane(l1);
        l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));
        
        Container c = getContentPane(); 
        c.setLayout(null);
        
        JLabel title = new JLabel("DECRYPTION"); 
        title.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50)); 
        title.setSize(400, 55); 
        title.setLocation(400, 20);
        c.add(title);
        
        JLabel labele = new JLabel("Select the file :"); 
        labele.setFont(new Font("Arial", Font.PLAIN,30)); 
        labele.setSize(300, 35); 
        labele.setLocation(340, 150);
        c.add(labele);
        
        openfile = new JButton("Open File"); 
        openfile.setFont(new Font("Times New Roman", Font.PLAIN, 30)); 
        openfile.setSize(160,35); 
        openfile.setForeground(Color.BLUE);
        openfile.setLocation(600, 150); 
        openfile.addActionListener(this); 
        c.add(openfile);
        
        selectadd = new JLabel(); 
        selectadd.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        selectadd.setSize(560, 30); 
        selectadd.setLocation(270, 230);
        Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);
        selectadd.setBorder(border);
        selectadd.setBackground(Color.white);
        selectadd.setOpaque(true);
        c.add(selectadd);
        selectadd.setVisible(false);
        
        submit = new JButton(); 
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        submit.setSize(150,40); 
        submit.setLocation(480, 320); 
        ImageIcon icon1 = new ImageIcon("src/images/button3.jpg");
        submit.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(submit.getWidth(),submit.getHeight(),Image.SCALE_AREA_AVERAGING)));
        submit.setForeground(Color.BLUE);
        submit.addActionListener(this); 
        c.add(submit);
        submit.setVisible(false);
        
        labeld = new JLabel("Decrypted Data "); 
        labeld.setFont(new Font("Arial", Font.PLAIN,30)); 
        labeld.setSize(300, 35); 
        labeld.setLocation(140, 460);
        c.add(labeld);
        labeld.setVisible(false);
                
        aread = new JTextField(); 
        aread.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        aread.setSize(560, 32); 
        aread.setLocation(370, 460);
        c.add(aread);
        aread.setVisible(false);
        
        close= new JButton(new ImageIcon());
        close.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        close.setSize(120,30); 
        close.setLocation(990, 620); 
        close.setForeground(Color.BLUE);
        ImageIcon icon = new ImageIcon("src/images/button1.jpg");
        close.setIcon(new ImageIcon(icon.getImage().getScaledInstance(close.getWidth(),close.getHeight(),Image.SCALE_AREA_AVERAGING)));
        close.addActionListener(this); 
        c.add(close);
        
        
       
        JButton backtomenu = new JButton("Main menu");
        backtomenu.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        backtomenu.setSize(150,30); 
        backtomenu.setLocation(790, 620); //960,620
        backtomenu.setForeground(Color.BLUE);
        backtomenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
                                dispose();
				choice frame = new choice();
				frame.setVisible(true);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		}); 
        c.add(backtomenu);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == submit)
         {
             if(showing.equals(""))
             {
                 JLabel label = new JLabel("Please select the file");
                 label.setFont(new Font("Dialog",Font.PLAIN, 20));
                 JOptionPane.showMessageDialog(null,label);
             }
             else
             {
                 
                try{
                 File f1=new File(showing);
                 FileReader fr = new FileReader(f1);  
                 BufferedReader br = new BufferedReader(fr);
           
                 String s; 
                 String[] words=null;
                 String arr[] = new String[3];
                 int i=0;
                 while((s=br.readLine())!=null)  
                 {
            	  if(s!="\n"&&i==0)
                    patt=s;
                   else if(s!="\n"&&i==1)
                    satt=s;
                   else if(s!="\n"&&i==2)
                     datt=s;
                    i++;
                 }
                 fr.close();
                 
               }
                 catch  (Exception exx)
               {
                  System.out.println("Exception occured");
               }
                 
                 aread.setText(decry());
                 aread.setVisible(true);
                 labeld.setVisible(true);
             }
             
         }
         else if(e.getSource() == openfile)
         {
            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
            int r = j.showOpenDialog(null); 
            if (r == JFileChooser.APPROVE_OPTION) 
            { 
                showing = j.getSelectedFile().getAbsolutePath(); 
                selectadd.setText(showing);
                submit.setVisible(true);
                selectadd.setVisible(true);
            } 
            else
               { System.out.println("the user cancelled the operation");
                 showing="";}
             
         }
         else if(e.getSource() == close)
         {
             dispose();
         }
    }
    
}
