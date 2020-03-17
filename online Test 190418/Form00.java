import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class Form00 extends JFrame
{
	Container co;
	int w,h;
	JLabel l1,l2,l3,l4,limg;
	
	JPanel p;
	BufferedImage img;
	public Form00()
	{
		co=getContentPane();
		co.setLayout(null);

		w=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		h=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		Font f=new Font("Arial",Font.PLAIN,50);
		
		l1=new JLabel("JAVA's ONLINE TEST");
		l1.setFont(f);
		l1.setForeground(new Color(15,15,255));
		l1.setBounds(w/2-270,50,700,100);
		
		l2=new JLabel("( M.C.Q. )");
		f=new Font("Arial",Font.PLAIN,40);
		l2.setFont(f);
		l2.setForeground(new Color(0,0,255));
		l2.setBounds(w/2-90,150,700,100);
		
		limg=new JLabel(new ImageIcon("images\\team.jpg"));
		
		limg.setBounds(0,140,w-20,h-70);	
		limg.setBackground(Color.red);
		
		co.add(limg);
		co.add(l1);
		co.add(l2);
		 
		co.setBackground(new Color(255,255,255)); 
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(w,h);
		setUndecorated(true);
		setVisible(true);
		 
		try{Thread.sleep(5000);}
		catch(Exception e){} 
		new Form11();
		setVisible(false);
	}
	public static void main(String []args)
	{
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e){}
		new  Form00();
	}
	
}
		