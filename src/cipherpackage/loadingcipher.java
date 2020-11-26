package cipherpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class loadingcipher extends JFrame {
      
 
    
    public static void main(String[] args) {
        
        loadingcipher frame = new loadingcipher();
        
    }
    
    public loadingcipher()
    {
      setBounds(600, 300, 346, 260);
      ImageIcon img1=new ImageIcon("src/images/gif1.gif");
      JLabel l1=new JLabel(img1);
      add(l1);
      setContentPane(l1);
      setLocationRelativeTo(this);
      setUndecorated(true);
      setVisible(true);
      try
      {
          Thread.sleep(10000);
          dispose();
	  logincipher  frame = new logincipher();
	  frame.setVisible(true);
	  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
      catch(Exception e){
        
        }
       
    }
}
