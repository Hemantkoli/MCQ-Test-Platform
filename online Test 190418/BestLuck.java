import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;

public class BestLuck extends JFrame implements ActionListener
{	
	Container co;
 
	JLabel l1;
	JButton jbstart;
	int w,h;
	int no=0;
	String nm="null";
	String []name;
	
	BestLuck(int no,String nm)
	{
		co=getContentPane();
		co.setLayout(null);
		this.no=no;
		this.nm=nm;

		w=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		h=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	
		name=nm.split(" ");	
		l1=new JLabel("<html><strong>"+name[1]+"</strong> &nbsp;,&nbsp;  BEST&nbsp;  LUCK&nbsp;  to&nbsp;  JAVA's&nbsp;  online&nbsp;  test&nbsp;  ! </html>");
		l1.setFont(new Font("Arial",Font.PLAIN,40));
		l1.setForeground(new Color(0,0,255));
		l1.setBounds(w/2-400,h/2-100,1500,100);
		
		jbstart=new JButton("START  TEST");
		jbstart.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		jbstart.setBackground(new Color(94,125,251));
		jbstart.setForeground(new Color(255,255,255));
		jbstart.addActionListener(this);
		jbstart.setBounds(w-270,h-120,200,50);
		
	 
		co.add(l1);
 
		co.add(jbstart);
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(w,h);
		setUndecorated(true);
		setVisible(true);
	}
	 
	public void actionPerformed(ActionEvent ae)
	{
		int flg=JOptionPane.showConfirmDialog(this,"ARE YOU SURE \n\nYOU WANT TO START THE TEST  ?\n\n","start test confirm dialog",JOptionPane.YES_NO_OPTION);
		if(flg==JOptionPane.YES_OPTION)
		{
			new Online(no,nm);
			setVisible(false);
		}
	}
	
	/*
	public static void main(String []arga)
	{
		new BestLuck(14301,"Barkade Uday Sanjay");
	}
	*/
}
		