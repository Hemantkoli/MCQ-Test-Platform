import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class Feedback extends JFrame implements ActionListener
{
	Container co;
	int w=0,h=0;
	JButton b1,b2;
	JPanel p,p1;
	JTextField t1;
	JTextArea t2;
	ImageIcon u;
	JLabel l,l1,l2;
	StudentData sd;
	JScrollPane jsb;
	
	Feedback(StudentData sd)
	{
		co=getContentPane();
		co.setLayout(null);
		
		this.sd=sd;
		
		w=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		h=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		System.out.println(w+""+h);
		Font f=new Font("Comic Sans MS Bold",Font.PLAIN,30);
		Font f1=new Font("Comic Sans MS",Font.PLAIN,20);
		Font f2=new Font("Comic Sans MS",Font.PLAIN,20);
		
		
		u=new ImageIcon("images\\load.jpg");
		
		b1=new JButton(u);
		b1.setBounds(1,1,w/2-250,h);
		b1.setBackground(new Color(255,255,255));
		b1.setFocusPainted(false);
		
		b2=new JButton("Submit");
		b2.setFont(new Font("Arial",Font.PLAIN,26));
		b2.setBackground(new Color(0,46,95));//new Color(94,125,251));
		b2.setForeground(Color.white);//new Color(255,255,255));
		b2.setBounds(w/2-180+w/2-195,500,150,30);
		
		p=new JPanel();
		p.setBounds(0,0,w,h);
		p.setBackground(new Color(0, 145, 241));
		p.setLayout(null);
		
		p1=new JPanel();
		p1.setBounds(5,800,200,100);
		p1.setBackground(Color.green);
		p1.setLayout(null);
		
		l=new JLabel("Please Give Us Your Valuable Feedback ...");
		l.setForeground(Color.white);
		l.setFont(f);
		l.setBounds(w/2-220,20,w/2,90);
		
		l1=new JLabel("Your Name  :");
		l1.setForeground(new Color(230,230,230));
		l1.setFont(f1);
		l1.setBounds(w/2-220,200,150,40);
		
		l2=new JLabel("Feedback    :");
		l2.setForeground(new Color(230,230,230));
		l2.setFont(f1);
		l2.setBounds(w/2-220,300,150,40);
		
		
		t1=new JTextField();
		t1.setMargin(new Insets(0,3,0,3));
		t1.setFont(new Font("Arial",Font.PLAIN,30));
		t1.setHorizontalAlignment(JTextField.CENTER);
		t1.setBorder(new LineBorder(new Color(47,24,248),1));
		t1.setBounds(w/2-45,200,w/2-180,40);
		
		t2=new JTextArea();
		t2.setMargin(new Insets(10,50,10,10));
		t2.setAutoscrolls(true);
		t2.setFont(new Font("Arial",Font.ITALIC,20));
		t2.setBorder(new LineBorder(new Color(47,24,248),1));
		
		jsb=new JScrollPane(t2,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsb.setBounds(w/2-45,300,w/2-180,120);
		
		co.add(p);
		p.add(p1);
		p.add(b1);
		p.add(b2);
		p.add(l);
		p.add(l1);
		p.add(l2);       
		p.add(t1);
		p.add(jsb);
		
		b2.addActionListener(this);
		
		setSize(w,h);
		setUndecorated(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String name=t1.getText();
		String feed=t2.getText();
		String s=ae.getActionCommand();
		if(s.equals("Submit"))
		{
			if(!(name.equals("")||feed.equals("")))
				JOptionPane.showMessageDialog(null,"Thank You ! For Your Kindly Feedback","Thank You",JOptionPane.INFORMATION_MESSAGE);
			//new Form15();
			setVisible(false);
			System.exit(0);
		}
	}
	public static void main(String []args)
	{
		new Feedback(new StudentData());
	}
	
}