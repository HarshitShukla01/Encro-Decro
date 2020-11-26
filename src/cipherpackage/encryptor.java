package cipherpackage;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class encryptor extends JFrame implements ActionListener {
    
    String types[]={"...", "Type1", "Type2","Type3"},patt,satt,datt;
    private JLabel labelp,labels,labeld,labelc,areas,areap;
    private JTextField aread,aream;
    private JButton submit,copy,close;
    private JComboBox typechoice;
    
    private String type1(String s)
     {
        StringBuilder sb=new StringBuilder();
	for(int i=0;i<s.length();i++)
        {
          sb.append((char)(s.charAt(i)+1));
        }
             
         return sb.toString();
     }
    
    private String type2(String s)
     {
        StringBuilder sb=new StringBuilder();
	for(int i=0;i<s.length();i++)
        {
          sb.append((char)(s.charAt(i)+2));
        }
        return sb.toString();
     }
    
    private String type3(String s)
     {
        StringBuilder sb=new StringBuilder();
	for(int i=0;i<s.length();i++)
        {
          sb.append((char)(s.charAt(i)+3));
        }
        
        return sb.toString();
        
     }
    public void encry(String s,int t)
    {
         if(t==1) datt=type1(s);
         else if(t==2) datt=type2(s);
         else if(t==3) datt=type3(s);
         
         int r = (int) (Math.random() * (6 - 2 + 1) + 2);
         int c = (int) (Math.random() * (4 - 1 + 1) + 1);
         int forsk = (int) (Math.random() * (3 - 1 + 1) + 1);
         int forpk = (int) (Math.random() * (3 - 1 + 1) + 1);
         
         String pk,sk;
         pk = Integer.toString(r);
         sk = Integer.toString(forpk) + Integer.toString(c);
         
         if(forsk==1) sk = type1(sk);
         else if(forsk==2) sk = type2(sk);
         else if(forsk==3) sk = type3(sk);
         
         if(forsk==1) sk = "@"+sk;
         else if(forsk==2) sk = "$"+sk;
         else if(forsk==3) sk = "#"+sk;
         
         int dec = r+c-t;
         
         pk = pk+Integer.toString(dec);
         
         if(forpk==1) pk = type1(pk);
         else if(forpk==2) pk = type2(pk);
         else if(forpk==3) pk = type3(pk);
         
         patt=pk;
         satt=sk;
    }
    
    public static void main(String[] args)
	{
            encryptor frame = new encryptor();
            frame.setVisible(true);	
	}
    
    public encryptor()
    {
        setLayout(null);
        setSize(1200,750);
        setLocationRelativeTo(this);        
        setTitle("Encryption");
        
        ImageIcon img1=new ImageIcon("src/images/m6.jpg");
        JLabel l1=new JLabel(img1);
        add(l1);
        l1.setBounds(0,0,1200,750);       
        setContentPane(l1);
        l1.setIcon(new ImageIcon(img1.getImage().getScaledInstance(l1.getWidth(),l1.getHeight(),Image.SCALE_AREA_AVERAGING)));
        
        Container c = getContentPane(); 
        c.setLayout(null);
        
        JLabel title = new JLabel("ENCRYTPTION"); 
        title.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 50)); 
        title.setSize(400, 55); 
        title.setLocation(400, 20);
        c.add(title);
        
        JLabel labele = new JLabel("Enter The Message"); 
        labele.setFont(new Font("Times New Roman", Font.PLAIN,30)); 
        labele.setSize(300, 35); 
        //labele.setForeground(Color.red);
        labele.setLocation(50, 150);
        c.add(labele);
        
        aream = new JTextField(); 
        aream.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        aream.setSize(600,32); 
        aream.setLocation(350, 150);
        c.add(aream);
        
        JLabel labelt = new JLabel("Choose your encryption type"); 
        labelt.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        labelt.setSize(400, 30); 
        labelt.setLocation(50, 230);
        c.add(labelt);
        
        typechoice = new JComboBox(types); 
        typechoice.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
        typechoice.setSize(100, 27); 
        typechoice.setLocation(440, 235); 
        c.add(typechoice); 
        
        submit = new JButton(); 
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        submit.setSize(150,40); 
        submit.setForeground(Color.BLUE);
        ImageIcon icon1 = new ImageIcon("src/images/button3.jpg");
        submit.setIcon(new ImageIcon(icon1.getImage().getScaledInstance(submit.getWidth(),submit.getHeight(),Image.SCALE_AREA_AVERAGING)));
        submit.setLocation(480, 320); 
        submit.addActionListener(this); 
        c.add(submit);
        
        labelp = new JLabel("Primary Key"); 
        labelp.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        labelp.setSize(400, 30); 
        labelp.setLocation(50, 390);
        c.add(labelp);
        labelp.setVisible(false);
      
        
        areap = new JLabel(); 
        areap.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        areap.setSize(350,32); 
        areap.setLocation(350, 390);
        areap.setBackground(Color.white);
        areap.setOpaque(true);
        c.add(areap);
        areap.setVisible(false);
        
        labels = new JLabel("Secondary Key"); 
        labels.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        labels.setSize(400, 30); 
        labels.setLocation(50, 460);
        c.add(labels);
        labels.setVisible(false);
        
        areas = new JLabel(); 
        areas.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        areas.setSize(350,32); 
        areas.setLocation(350, 460);
        areas.setBackground(Color.white);
        areas.setOpaque(true);
        c.add(areas);
        areas.setVisible(false);
        
        labeld = new JLabel("Encrypted Data"); 
        labeld.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        labeld.setSize(400, 30); 
        labeld.setLocation(50, 530);
        c.add(labeld);
        labeld.setVisible(false);
        
        aread = new JTextField(); 
        aread.setFont(new Font("Times New Roman", Font.PLAIN,25)); 
        aread.setSize(600,32); 
        aread.setLocation(350, 530);
        c.add(aread);
        aread.setVisible(false);
        
        labelc = new JLabel("To copy content :"); 
        labelc.setFont(new Font("Times New Roman", Font.PLAIN,20)); 
        labelc.setSize(400, 25); 
        labelc.setLocation(280, 623); //280,623
        c.add(labelc);
        labelc.setVisible(false);
        
        copy = new JButton("COPY"); 
        copy.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        copy.setSize(150,30); 
        copy.setLocation(480, 620); //480,620
        copy.setForeground(Color.BLUE);
        copy.addActionListener(this); 
        c.add(copy);
        copy.setVisible(false);
        
        close= new JButton(); 
        close.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        close.setSize(120,30); 
        close.setLocation(1040, 620); //1040,620
        ImageIcon icon = new ImageIcon("src/images/button1.jpg");
        close.setIcon(new ImageIcon(icon.getImage().getScaledInstance(close.getWidth(),close.getHeight(),Image.SCALE_AREA_AVERAGING)));
        close.setForeground(Color.BLUE);
        close.addActionListener(this); 
        c.add(close);
        
        JButton backtomenu = new JButton("Main menu");
        backtomenu.setFont(new Font("Times New Roman", Font.PLAIN, 25)); 
        backtomenu.setSize(150,30); 
        backtomenu.setLocation(840, 620); //960,620
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
         Object sd = typechoice.getSelectedItem();
         String st = aream.getText();
         if(sd.equals("...")||st.isEmpty())
         {
             JLabel label = new JLabel("Please enter the information");
             label.setFont(new Font("Dialog",Font.PLAIN, 20));
             JOptionPane.showMessageDialog(null,label);
         }
         else{
             
             JLabel label = new JLabel("Data Encrypted....");
             label.setFont(new Font("Dialog",Font.PLAIN, 20));
             JOptionPane.showMessageDialog(null,label);
         
         labelp.setVisible(true);
         areap.setVisible(true);
         labels.setVisible(true);
         areas.setVisible(true);
         labeld.setVisible(true);
         aread.setVisible(true);
         labelc.setVisible(true);
         copy.setVisible(true);
         
         
         int r=0;
         if(sd.equals("Type1")) r=1;
         else if(sd.equals("Type2")) r=2;
         else if(sd.equals("Type3")) r=3;
         
         encry(st,r);
         
         areap.setText(patt);
         areas.setText(satt);
         aread.setText(datt);}
     }
     
     else if(e.getSource() == close)
     {
         dispose();
     }
     
     else if(e.getSource() == copy)
     {
         String str = "D:\\encryption.txt";
         if (new File(str).exists()) 
         {
           System.out.println("File exists");
         } 
         else
         {
             try{
             File file = new File(str);
             boolean result = file.createNewFile();  }
             catch (Exception exx)
             {}   
         }
         
         try{
          File f = new File(str);
          FileOutputStream fos = new FileOutputStream(f);
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
          bw.write(areap.getText());
          bw.newLine();
          bw.write(areas.getText());
          bw.newLine();
          bw.write(aread.getText());
          bw.newLine();
          bw.close();  
         }
         catch(Exception exx)
         {}
         JLabel label = new JLabel("Data is written \nat Location - "+str);
         label.setFont(new Font("Dialog",Font.PLAIN, 20));
         JOptionPane.showMessageDialog(null,label);
     }
     
    }
}
