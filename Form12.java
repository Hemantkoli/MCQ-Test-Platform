import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;
import java.io.File;
public class Form12 extends JFrame implements ActionListener
{
	Container co;
	JPanel p1;
	JPasswordField pf;
	JButton b1,b2;
	JLabel l,l1,l2,l3,pas;
	ImageIcon u;
	int w,h,no;
	String nm;
	TimeData td;
	StudentData sd;
	
	Form12(int no,String nm,StudentData sd)
	{
		super("Sign In Form");
	
		this.no=no;
		this.nm=nm;
		this.sd=sd;
		td=new TimeData();
		
		w=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		h=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		co=getContentPane();
		co.setLayout(null);
		
		l=new JLabel("SIGN IN ");
		l.setFont(new Font("Copperplate Gothic",Font.PLAIN,24));
		l.setForeground(new Color(94,125,251));
		ImageShape.setSmallImage(no);
		if(new File("images\\"+no+".png").length()==0)
			u=new ImageIcon("images/login.png");
		else
			u=new ImageIcon("images/"+no+".png");
	
		l1=new JLabel(u);
		l1.setBounds(60,15,180,230);
		
		l2=new JLabel("       Invalid Password");
		l2.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		l2.setForeground(Color.red);
		l2.setBounds(30,310,237,30);
		l2.setVisible(false);
		
		l3=new JLabel("Hii   , "+nm);
		l3.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		l3.setForeground(new Color(0,155,0));
		
		pas=new JLabel("Password");
		pas.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		pas.setForeground(new Color(94,125,251));
		pas.setBounds(32,220,234,40);

		pf=new JPasswordField();
		pf.setText("ASDF1234FF");
		pf.setFont(new Font("Copperplate Gothic",Font.PLAIN,16));
		pf.setEnabled(false);
		pf.setBounds(32,260,234,40);
		
		pf.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent me)
		{
			if(pf.isEnabled()==false)
			{	
				pf.setText("");
				pf.setEnabled(true);
			}
		}
		});
		b1=new JButton("Sign In");
		b1.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		b1.setBounds(30,340,237,40);
		b1.setBackground(new Color(94,125,251));
		b1.setForeground(new Color(255,255,255));
		
		b2=new JButton("Back");
		b2.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		b2.setBounds(30,400,237,30);
		b2.setBackground(new Color(94,125,251));
		b2.setForeground(new Color(255,255,255));
		
		p1=new JPanel();
		p1.setLayout(null);
		int x=w/2-150;
		int y=h/2-195;
		p1.setBounds(x,y,300,450);
		p1.setBackground(new Color(199,199,199));
		
		l.setBounds(x,y-90,200,40);
		
		l3.setBounds(x,y-50,350,40);
		
		co.add(l);
		co.add(l3);
		p1.add(l1);
		p1.add(pas);
		p1.add(l2);
		p1.add(pf);
		p1.add(b1);
		p1.add(b2);
		co.add(p1);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		setSize(w,h);
		setUndecorated(true);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent  ae)
	{
			  JButton jb=(JButton)ae.getSource();
			if(jb==b2)
			{
				new Form11();
				setVisible(false);
				return;
			}
			String pass1=new String(pf.getPassword());
			String pass2=sd.getPassword(no);
			if(pass1.equals(pass2))
			{
				System.out.println(td.getTime());
				sd.setTime(no,td.getTime());
				new Form13(no,nm);
				setVisible(false);
			}
			else
			{l2.setVisible(true);pf.requestFocus();return;}
	}	
	public static void main(String []args)
	{
		new  Form12(14320,"rushi",new StudentData());
	}
	
}