import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;

public class Form15 extends JFrame implements ActionListener
{	
	Container co;
 
	JLabel l1,l2,l3,l4;
	JButton jbstart;
	int w,h;
	
	Form15()
	{
		co=getContentPane();
		co.setLayout(null);
	 
		w=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		h=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	
		 
		l1=new JLabel("Thanks To");
		l1.setFont(new Font("Arial",Font.PLAIN,40));
		l1.setForeground(new Color(0,0,255));
		l1.setBounds(w/2-100,h/2-200,1500,100);

		l2=new JLabel("Prof. H. L. Deshpande");
		l2.setFont(new Font("Arial",Font.PLAIN,40));
		l2.setForeground(new Color(255,0,0));
		l2.setBounds(w/2-500,h/2,1500,100);

		l3=new JLabel("Mr. Sandip B. Shintre");
		l3.setFont(new Font("Arial",Font.PLAIN,40));
		l3.setForeground(new Color(255,0,0));
		l3.setBounds(w/2+100,h/2,1500,100);

		l4=new JLabel("for there guidence");
		l4.setFont(new Font("Arial",Font.PLAIN,40));
		l4.setForeground(new Color(0,0,255));
		l4.setBounds(w/2-170,h/2+200,1500,100);
		
		jbstart=new JButton("CLOSE  TEST");
		jbstart.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		jbstart.setBackground(new Color(94,125,251));
		jbstart.setForeground(new Color(255,255,255));
		jbstart.addActionListener(this);
		jbstart.setBounds(w-270,h-120,200,50);
		
	 
		co.add(l1);
 		co.add(l2);
		co.add(l3);
		co.add(l4);
		co.add(jbstart);
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(w,h);
		setUndecorated(true);
		setVisible(true);
	}
	 
	public void actionPerformed(ActionEvent ae)
	{ 	 
		System.exit(0);
	}
	public static void main(String []arga)
	{
		new Form15();
	}
}