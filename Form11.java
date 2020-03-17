import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;

public class Form11 extends JFrame implements ActionListener
{
	Container co;
	JPanel p1;
	JTextField t1;
	JButton b1;
	JLabel l,l1,l2,pas;
	ImageIcon u;
	int w,h,no;
	String nm;
	
	StudentData sd=new StudentData();
	
	Form11()
	{
		super("Form1");
		getContentPane().setBackground(new Color(255,255,255));
		w=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		h=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		co=getContentPane();
		co.setLayout(null);
		
		l=new JLabel("SIGN IN");
		l.setFont(new Font("Copperplate Gothic",Font.PLAIN,24));
		l.setForeground(new Color(94,125,251));

		u=new ImageIcon("images/login.png");
		l1=new JLabel(u);
		l1.setBounds(60,30,180,180);
		
		l2=new JLabel("    Sorry ! Invalid Roll No");
		l2.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		l2.setForeground(Color.red);
		l2.setBounds(30,310,237,20);
		l2.setVisible(false);
		
		pas=new JLabel("Roll Number");
		pas.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		pas.setForeground(new Color(94,125,251));
		pas.setBounds(32,220,234,40);

		t1=new JTextField();
		t1.setBounds(32,260,234,40);
		t1.setFont(new Font("Copperplate Gothic",Font.PLAIN,16));
		t1.setText("ENTER ROLL NUMBER");
		t1.setEnabled(false);
		t1.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent me)
		{
			if(t1.isEnabled()==false)
			{	
				t1.setText("");
				t1.setEnabled(true);
			}
		}
		});

		b1=new JButton("Next");
		b1.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		b1.setBounds(30,340,237,40);
		b1.setBackground(new Color(94,125,251));
		b1.setForeground(new Color(255,255,255));
		
		p1=new JPanel();
		p1.setLayout(null);
		int x=w/2-150;
		int y=h/2-195;
		p1.setBounds(x,y,300,390);
		p1.setBackground(new Color(199,199,199));
		
		l.setBounds(x,y-70,200,40);
		
		
		co.add(l);
		p1.add(l1);
		p1.add(pas);
		p1.add(l2);
		p1.add(t1);
		p1.add(b1);
		co.add(p1);
		
		b1.addActionListener(this);
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		setSize(w,h);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent  ae)
	{
			try{no=Integer.parseInt(t1.getText());}
			catch(Exception e){l2.setVisible(true);return;}
			nm=sd.getName(no);
			sd.getImage(no);//get image from database & store image on client side
			if(nm.equals("NOT DATA FOUND"))
			{
				l2.setVisible(true);return;
			}
			try{	
			new Form12(no,nm,sd);
			}
			catch(Exception e){System.out.println("Error  "+  e);}
			setVisible(false);
	}
	public static void main(String []args)
	{
		new  Form11();
	}
}