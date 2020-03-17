import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;

import java.awt.geom.*;

public class Form14 extends JFrame implements ActionListener
{	
	Container co;
	JLabel l1,totq,totq1,ans,ans1,skip,skip1,cor,cor1,wro,wro1,totm,totm1,obtm,obtm1,lmrk;
	JButton jbexit;
	JSeparator []js=new JSeparator[8];
	StudentData sd;
	int w,h;
	int rno;
	String t;
 
	Label ca,wa;//color label for correctAnswer and wrong answer
	Label caval,waval;//value in 360 degree piegraph 
	JLabel cao,wao;//converted values in 100%
	JLabel rs;//result fail or pass 
	PieChart gr;
 
	int totalQuestion,answeredQuestion,correctAnswer,wrongAnswer,totalMrk,obtainedMrk;
	
	
	
	
	Form14(int rno,String t,int totalQuestion1,int answeredQuestion1,int correctAnswer1,int wrongAnswer1)
	{
		co=getContentPane();
		co.setLayout(null);
		this.rno=rno;
		
		totalQuestion=totalQuestion1;
		answeredQuestion=answeredQuestion1;
		correctAnswer=correctAnswer1;
		wrongAnswer=wrongAnswer1;
		this.t=t;
		
		sd=new StudentData();
		setResult();		
		
		for(int i=0;i<8;i++)
			js[i]=new JSeparator();
		
		w=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		h=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		l1=new JLabel("RESULT");
		l1.setFont(new Font("Arial",Font.BOLD,50));
		l1.setForeground(new Color(0,0,255));
		
		jbexit=new JButton("NEXT");
		jbexit.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		jbexit.setBackground(new Color(94,125,251));
		jbexit.setForeground(new Color(255,255,255));
		jbexit.addActionListener(this);
		
		
		totq=new JLabel("Total Questions");
		totq.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		totq.setBackground(new Color(94,125,251));
		totq1=new JLabel(":     "+totalQuestion);
		totq1.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		totq1.setBackground(new Color(94,125,251));
		
		ans=new JLabel("Attempted Questions");
		ans.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		ans1=new JLabel(":     "+answeredQuestion);
		ans1.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		
		skip=new JLabel("Skipped Questions");
		skip.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		skip.setBackground(new Color(94,125,251));
		skip1=new JLabel(":     "+(totalQuestion-answeredQuestion));
		skip1.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		skip1.setBackground(new Color(94,125,251));
		
		cor=new JLabel("Correct Answers");
		cor.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		cor1=new JLabel(":     "+correctAnswer);
		cor1.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		
		wro=new JLabel("Wrong Answers");
		wro.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		wro.setBackground(new Color(94,125,251));
		wro1=new JLabel(":     "+wrongAnswer);
		wro1.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		wro1.setBackground(new Color(94,125,251));
		
		totm=new JLabel("Out Of Marks");
		totm.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		totm1=new JLabel(":     "+totalQuestion);
		totm1.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		
		obtm=new JLabel("Obtained Marks");
		obtm.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		obtm.setBackground(new Color(94,125,251));
		obtm1=new JLabel(":     "+correctAnswer);
		obtm1.setFont(new Font("Copperplate Gothic",Font.PLAIN,20));
		obtm1.setBackground(new Color(94,125,251));
		
		lmrk=new JLabel(correctAnswer+"/"+totalQuestion);
		lmrk.setFont(new Font("Copperplate Gothic",Font.PLAIN,40));	
		//lmrk.setBounds(w/2-300,h-200,400,200);
		lmrk.setForeground(new Color(24,125,251));
		
		l1.setBounds(w/2-100,10,850,70);
		js[0].setBounds(100,65,w-200,65);
		
		totq.setBounds(w/2-500,170,250,30);
		totq1.setBounds(w/2-200,170,200,30);
		js[1].setBounds(100,205,w/2-100,205);
		
		ans.setBounds(w/2-500,230,250,30);
		ans1.setBounds(w/2-200,230,250,30);
		js[2].setBounds(100,265,w/2-100,205);
		
		skip.setBounds(w/2-500,290,250,30);
		skip1.setBounds(w/2-200,290,200,30);	
		js[3].setBounds(100,325,w/2-100,205);

		cor.setBounds(w/2-500,350,250,30);
		cor1.setBounds(w/2-200,350,200,30);
		js[4].setBounds(100,385,w/2-100,205);
		
		wro.setBounds(w/2-500,410,250,30);
		wro1.setBounds(w/2-200,410,200,30);
		js[5].setBounds(100,445,w/2-100,205);
		
		totm.setBounds(w/2-500,470,250,30);
		totm1.setBounds(w/2-200,470,200,30);
		js[6].setBounds(100,505,w/2-100,205);
		
		obtm.setBounds(w/2-500,530,250,30);
		obtm1.setBounds(w/2-200,530,200,30);
		js[7].setBounds(100,565,w/2-100,205);	
		
		lmrk.setBounds(w/2-350,h-150,100,60);
		
		jbexit.setBounds(w-270,h-120,200,50);
	
	
		gr=new PieChart(correctAnswer,totalQuestion);
		gr.setLayout(null);
		gr.setBackground(Color.red);
		gr.setBounds(w-600,170,500,400);
	
		ca=new Label();
		ca.setBackground(Color.blue);
		ca.setBounds(330,20,20,20);
		gr.add(ca);
	
			
		caval=new Label("Correct Answers");
		caval.setBackground(Color.white);
		caval.setForeground(Color.blue);
		caval.setBounds(350,20,100,20);
		gr.add(caval);
	
		cao=new JLabel(""+(float)correctAnswer/50.0*100+"%");
		cao.setBounds(350,40,250,100);
		cao.setForeground(Color.blue);
		cao.setFont(new Font("Copperplate Gothic",Font.PLAIN,50));
		gr.add(cao);
	
		
		
		wa=new Label();
		wa.setBackground(Color.red);
		wa.setBounds(330,150,20,20);
		gr.add(wa);
	
	
		waval=new Label("Wrong Answers");
		waval.setBackground(Color.white);
		waval.setForeground(Color.red);
		waval.setBounds(350,150,100,20);
		gr.add(waval);
	
	
	
			
		wao=new JLabel(""+(float)wrongAnswer/50.0*100+"%");
		wao.setBounds(350,170,250,100);
		wao.setForeground(Color.red);
		wao.setFont(new Font("Copperplate Gothic",Font.PLAIN,50));
		gr.add(wao);
	
		if(correctAnswer>=20)
		{
			rs=new JLabel("PASS");
			rs.setForeground(Color.blue);
		}
		else
		{
			rs=new JLabel("FAIL");
			rs.setForeground(Color.red);
		}
		rs.setBounds(300,300,350,100);
		rs.setFont(new Font("Copperplate Gothic",Font.PLAIN,70));
		gr.add(rs);
	
		
	
		co.add(gr);
		co.add(l1);
		co.add(jbexit);
		co.add(totq);
		co.add(totq1);
		co.add(ans);
		co.add(ans1);
		co.add(skip);
		co.add(skip1);
		co.add(cor);
		co.add(cor1);
		co.add(wro);
		co.add(wro1);
		co.add(totm);
		co.add(totm1);
		co.add(obtm);
		co.add(obtm1);
		co.add(lmrk);
		
		for(int i=0;i<8;i++)
			co.add(js[i]);
		 
		setSize(w,h);
		setUndecorated(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
	}
	
	
	void setResult()
	{
		totalMrk=totalQuestion;
		obtainedMrk=correctAnswer;
		StudentData sd=new StudentData();
		sd.setMark(rno,obtainedMrk,t);
	}	
	public void actionPerformed(ActionEvent ae)
	{
		int flg=JOptionPane.showConfirmDialog(this,"ARE YOU SURE \nYOU WANT TO GO NEXT ?","next confirm dialog",JOptionPane.YES_NO_OPTION);
		if(flg==JOptionPane.YES_OPTION)
		{
			new Feedback(sd);
			setVisible(false);
		}
	}
	public static void main(String []args)
	{
		new Form14(12,"12:12",50,0,19,31);
	}
}

class PieChart extends JPanel 
{
	double mo=0,mt=0;//marks obtained ,total marks
	double ar;
	
	

	
	PieChart(int mo,int mt)
	{
		this.mo=mo;
		this.mt=mt;
		ar=mo/50.0*360.0;
	}
	
		
		
	public void paintComponent(Graphics g) 
	{
		Graphics2D g2 = (Graphics2D) g;

		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		arc.setFrame(10, 10, 300, 300);

		// 0 - 80 degrees
		arc.setAngleStart(0);
		arc.setAngleExtent(ar);
		g2.setColor(Color.gray);
		g2.draw(arc);
		g2.setColor(Color.blue);
		g2.fill(arc);

		// 80 - 200 degrees
		arc.setAngleStart(ar);
		arc.setAngleExtent(360-ar);
		g2.setColor(Color.gray);
		g2.draw(arc);
		g2.setColor(Color.red);
		g2.fill(arc);

	}

}