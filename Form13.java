import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;

public class Form13 extends JFrame implements ActionListener
{	
	Container co;
 
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton jbstart;
	int w,h;
	int no=0;
	String nm="null";
	
	Form13(int no,String nm)
	{
		co=getContentPane();
		co.setLayout(null);
		this.no=no;
		this.nm=nm;

		w=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		h=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		
		l1=new JLabel("<html>Hiii , <strong color =red>"+nm+"</strong>  welcome to JAVA's online test !");
		l1.setFont(new Font("Arial",Font.PLAIN,30));
		l1.setForeground(new Color(0,0,255));
		l1.setBounds(w/2-500,10,850,70);
		
		l2=new JLabel("Rules About Test");
		l2.setFont(new Font("Arial",Font.PLAIN,30));
		l2.setForeground(new Color(255,82,23));
		l2.setBounds(w/2-500,110,850,30);
		 
		
		l3=new JLabel("1.  This is a 50 questions MCQ test    ( All questions are compulsary )");
		l3.setFont(new Font("Arial",Font.PLAIN,20));
		l3.setForeground(new Color(120,120,120));
		l3.setBounds(w/2-500,170,850,30);
		 
		
		l4=new JLabel("2.  Each Question has 1 mark    ( 50 Q X 1 M = 50 Marks Test )");
		l4.setFont(new Font("Arial",Font.PLAIN,20));
		l4.setForeground(new Color(120,120,120));
		l4.setBounds(w/2-500,230,850,30);
		 
		
		l5=new JLabel("3.  Time Period is 1 Hour     ( 60 minutes )");
		l5.setFont(new Font("Arial",Font.PLAIN,20));
		l5.setForeground(new Color(120,120,120));
		l5.setBounds(w/2-500,290,850,30);
	 
		
		l6=new JLabel("<html>4.  In this test <strong color=rgb(0,145,241)> BLUE </strong>color is used to indicated Question is un-seened</html>");
		l6.setFont(new Font("Arial",Font.PLAIN,20));
		l6.setForeground(new Color(120,120,120));
		l6.setBounds(w/2-500,350,850,30);
	 
		
		l7=new JLabel("<html>5.  In this test <strong color=green> GREEN </strong> color is used to indicated Question is seened and submitted</html>");
		l7.setFont(new Font("Arial",Font.PLAIN,20));
		l7.setForeground(new Color(120,120,120));
		l7.setBounds(w/2-500,410,850,30);
	 
	 	l8=new JLabel("<html>6.  In this test <strong color=red>RED</strong> color is used to indicated Question is seened but not submitted</html>");
		l8.setFont(new Font("Arial",Font.PLAIN,20));
		l8.setForeground(new Color(120,120,120));
		l8.setBounds(w/2-500,470,850,30);
		
		l9=new JLabel("<html>7.  Don't <strong color=red> MINIMIZE </strong> or <strong color=red> CHANGE </strong> application window, otherwise you gets <strong color=red> FAIL </strong>");
		l9.setFont(new Font("Arial",Font.PLAIN,20));
		l9.setForeground(new Color(120,120,120));
		l9.setBounds(w/2-500,530,850,30);
		
		
		jbstart=new JButton("NEXT");
		jbstart.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		jbstart.setBackground(new Color(94,125,251));
		jbstart.setForeground(new Color(255,255,255));
		jbstart.addActionListener(this);
		jbstart.setBounds(w-270,h-120,200,50);
		
	 
		co.add(l1);
		co.add(l2);
		co.add(l3);
		co.add(l4);
		co.add(l5);
		co.add(l6);
		co.add(l7);
		co.add(l8);
		co.add(l9);
		co.add(jbstart);
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(w,h);
		setUndecorated(true);
		setVisible(true);
	}
	 
	public void actionPerformed(ActionEvent ae)
	{
			new BestLuck(no,nm);
			setVisible(false);
	}
	public static void main(String []arga)
	{
		new Form13(1001,"ABCDEF");
	}
	
}
		