import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
class QuestionPanel extends JPanel implements ActionListener
{
	JLabel jq,limg;
	JRadioButton a,b,c,d;
	ButtonGroup bg;	
	JPanel p1,p2;
	JScrollPane jsb1,jsb2,jsb3;
	
	String cans=null;
	
	int r1=255,g1=255,b2=255;

	int w=0,h=0;
	
	QuestionPanel(Panel jp)
	{
		jq=new JLabel("");
		jq.setFont(new Font("Arial",Font.PLAIN,24));
		jq.setBackground(Color.white);
		
		jp.setLayout(null);
		
		w=jp.getWidth();
		h=jp.getHeight();
	
		a=new JRadioButton("");
		a.setFont(new Font("Arial",Font.PLAIN,20));
		a.addActionListener(this); 
		b=new JRadioButton("");
		b.setFont(new Font("Arial",Font.PLAIN,20));
		b.addActionListener(this);
		c=new JRadioButton("");
		c.setFont(new Font("Arial",Font.PLAIN,20));
		c.addActionListener(this);
		d=new JRadioButton("");
		d.setFont(new Font("Arial",Font.PLAIN,20));	
		d.addActionListener(this);	
		
		
		int r11=0,g11=0,b22=255;
		
		a.setBackground(new Color(255,255,255));
		b.setBackground(new Color(255,255,255));
		c.setBackground(new Color(255,255,255));
		d.setBackground(new Color(255,255,255));
		
		a.setForeground(new Color(r11,g11,b22));
		b.setForeground(new Color(r11,g11,b22));
		c.setForeground(new Color(r11,g11,b22));
		d.setForeground(new Color(r11,g11,b22));
		
		bg=new ButtonGroup();
		bg.add(a);
		bg.add(b);
		bg.add(c);
		bg.add(d);	
	
		p1=new JPanel();
		p1.add(jq);
		jsb1=new JScrollPane(p1,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		p2=new JPanel();
		p2.setLayout(new GridLayout(4,1,2,5));
		jsb2=new JScrollPane(p2,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p2.add(a);
		p2.add(b);
		p2.add(c);
		p2.add(d);
		
		limg=new JLabel();
		jsb3=new JScrollPane(limg,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		int h1=h*35/100;
		jsb1.setBounds(0,0,w,h1);
		jsb1.setBackground(new Color(r1,g1,b2));
		jq.setForeground(Color.blue);
		
		int w1=w*50/100;
		int h2=h*65/100;
		jsb2.setBounds(0,h1,w1,h2);
		jsb2.setBackground(new Color(r1,g1,b2));
		
		jsb3.setBounds(w1,h1,w1,h2);
		jsb3.setBackground(new Color(r1,g1,b2));
			
		jp.add(jsb1);
		jp.add(jsb2);
		jp.add(jsb3);
		
		setSize(w,h);
	}	
	
	public void actionPerformed(ActionEvent ae)
	{
		JRadioButton jrb=(JRadioButton)ae.getSource();
		if(jrb==a)
			cans="a";
		if(jrb==b)
			cans="b";
		if(jrb==c)
			cans="c";
		if(jrb==d)
			cans="d";
	}
	String getClientAnswer(){return cans;}
	
	void setQuestion(Question q,String cans)
	{
		
		jq.setText("<html>"+q.que.replaceAll("\n","<br>")+"</html>");
		a.setText(q.a);
		b.setText(q.b);
		c.setText(q.c);
		d.setText(q.d);
		limg.setIcon(new ImageIcon("images/"+q.img+".jpg"));
		this.cans=cans;
		if(cans==null)
			bg.clearSelection();
		else
		{
			if(cans.equals("a"))
				a.setSelected(true);
			if(cans.equals("b"))
				b.setSelected(true);
			if(cans.equals("c"))
				c.setSelected(true);
			if(cans.equals("d"))
				d.setSelected(true);
		}
	}
}

class Question
{
	String que,a,b,c,d,img,sans,cans=null;
 
	
	Question(String q,String a1,String b1,String c1,String d1,String i,String ans)
	{
		 que=q;
		 a=a1;
		 b=b1;
		 c=c1;
		 d=d1;
		 img=i;
		 sans=ans;
	}	
	String getClientAnswer(){return cans;}
	String getServerAnswer(){return sans;}
	void setClientAnswer(String str){cans=str;}
}

class QuestionBank
{
	Question [] que=new Question[50];
	
	QuestionData qd;
	 
	int current_question=0;
	
	String [][]str=new String[50][8];
	QuestionBank()
	{
		for(int i=0;i<50;i++)
			que[i]=null;
			
		qd=new QuestionData();
	}
	
	void setQuestion(int index,String q,String a,String b,String c,String d,String img,String sans)
	{
		que[index]=new Question(q,a,b,c,d,img,sans);
		 
	}
	void setQuestions()
	{
		str=qd.getQuestionData();
		for(int j=0,i=0;j<50;j++,i++)
		{
			setQuestion(i,str[i][1],str[i][2],str[i][3],str[i][4],str[i][5],str[i][6],str[i][7]);
			//setQuestion(j,"que"+i,"opt1"+i,"opt2"+i,"opt3"+i,"opt4"+i,"null","a");
		}
		
	}
	Question getQuestion(int ind)
	{
			return que[ind];
 	}
	Question getCurrentQuestion()
	{
			return que[current_question];
	}	
}




public class Online extends JFrame implements ActionListener,Runnable
{
	JLabel jnm,jrno,jtime,jtir,jerno;
	JPanel jstuInfo;

	JButton jbque[]=new JButton[50];
 
	JPanel jpqueBtn;
	JScrollPane jsb;

	JButton jbprev,jbsubmit,jbskip,jbsubmitTest;
	JPanel jnav;

	Panel jpque;
	
	QuestionBank qb;
	QuestionPanel qpan;
	
	int rno,m,s;
	
	boolean thrdFlg=true;
	
	int w=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	int h=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	String mstr="",sstr="";
	public Online(int rno,String nm)
	{
		setLayout(null);
		
		this.rno=rno;
		
		Font f=new Font("Arial",Font.PLAIN,20);
		
		jstuInfo=new JPanel();
		jstuInfo.setLayout(null);
		jstuInfo.setBackground(new Color(0, 145, 241));//0, 175, 241));
		
		jnm=new JLabel("<html>&nbsp;Name     : <strong color=white>"+nm+"<strong></html>");
		jnm.setForeground(Color.black);
		jnm.setFont(f);
		
		jrno=new JLabel("<html>&nbsp;Roll No  : <strong color=white>"+rno+"<strong></html>");
		jrno.setForeground(Color.black);
		jrno.setFont(f);
		
		jerno=new JLabel("<html>&nbsp;Status  : <strong color=white> logged in <strong></html>");
		jerno.setForeground(Color.black);
		jerno.setFont(f);
		
		jtime=new JLabel("<html>01<sub style=\"font-size: 20px;color:black;\">H</sub>:00<sub style=\"font-size: 20px;color:black;\">M</sub>:00<sub style=\"font-size: 20px;color:black;\">S</sub></html>");
		jtime.setFont(new Font("Digital-7",Font.PLAIN,55));
		jtime.setForeground(Color.white);
		
		jtir=new JLabel("Remaining Time");
		jtir.setFont(new Font("Digital-7",Font.PLAIN,22));
		jtir.setForeground(Color.white);
		
		jbsubmitTest=new JButton("End Test");
		jbsubmitTest.addActionListener(this);
		jbsubmitTest.setBackground(new Color(0,46,95));
		jbsubmitTest.setForeground(Color.white);
		jbsubmitTest.setFont(new Font("Arial",Font.PLAIN,26));
		jbsubmitTest.setBorder(null);
		jbsubmitTest.setFocusPainted(false);
			
		jpqueBtn=new JPanel();
		jpqueBtn.setLayout(new GridLayout(10,5,1,1));

		jsb=new JScrollPane(jpqueBtn,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		for(int i=0;i<50;i++)
		{
			jbque[i]=new JButton(""+(i+1));
			jpqueBtn.add(jbque[i]);
			jbque[i].setFont(new Font("Times New Roman",Font.PLAIN,20));
			jbque[i].setBackground(new Color(0, 145, 241));
			jbque[i].setForeground(Color.white);
			jbque[i].addActionListener(this);
			jbque[i].setBorder(new LineBorder(new Color(25, 25, 25),4));
			jbque[i].setBorderPainted(false);
			
		}
		
		jpque=new Panel();
		jpque.setForeground(Color.white);//new Color(255,255,255));
		jpque.setBackground(Color.white);//new Color(255,255,255));
		
		jnav=new JPanel();
		jnav.setLayout(new GridLayout(1,3,5,5));
		
		jbprev=new JButton("PREVIOUS");//new ImageIcon("images/previous.png"));
		jbprev.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		jbprev.addActionListener(this);
		jbprev.setBackground(new Color(0, 145, 241));//238,238,238));
		jbprev.setForeground(Color.white);
		jbprev.setBorder(null);
		jbprev.setFocusPainted(false);
		
		jbsubmit=new JButton("SUBMIT");//new ImageIcon("images/submit.png"));
		jbsubmit.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		jbsubmit.addActionListener(this);
		jbsubmit.setBackground(new Color(0, 145, 241));//238,238,238));
		jbsubmit.setForeground(Color.white);
		jbsubmit.setBorder(null);
		jbsubmit.setFocusPainted(false);
		
		jbskip=new JButton("SKIP");//new ImageIcon("images/skip.png"));
		jbskip.setFont(new Font("Copperplate Gothic",Font.PLAIN,18));
		jbskip.addActionListener(this);
		jbskip.setBackground(new Color(0, 145, 241));//238,238,238));
		jbskip.setForeground(Color.white);
		jbskip.setBorder(null);
		jbskip.setFocusPainted(false);
		
		jrno.setBounds(0,0,500,30);
		jnm.setBounds(0,50,500,30);
		jerno.setBounds(0,100,500,30);
		jtime.setBounds(w-600,50,500,80);
		jtir.setBounds(w-600,10,500,30);
		
		int w1=w*20/100;
		int w2=w*10/100;
		jbsubmitTest.setBounds(w-w1,20,w2+60,50);
		
		int y1=h/100*20;
		jstuInfo.setBounds(0,0,w,y1);
	
		int y=(h/100*75);
		w1=w/100*25;
		jsb.setBounds(0,y1+10,w1,y+38);
		
		w2=(w/100*74);
		int h2=(h/100*75);
	
		int h3=y1+h2+(h/100*2);
		
		w1=w1+(w/100*1);
		jpque.setBounds(w1,y1+10,w2,h2);
		jnav.setBounds(w1,h3,w2,40);
		
		jnav.add(jbprev);
		jnav.add(jbsubmit);
		jnav.add(jbskip);
				
		jstuInfo.add(jrno);
		jstuInfo.add(jnm);
		jstuInfo.add(jtime);
		jstuInfo.add(jtir);
		jstuInfo.add(jerno);
		jstuInfo.add(jbsubmitTest);
	
		add(jstuInfo);
		add(jsb);
		add(jpque);
		add(jnav);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowStateChanged(WindowEvent we)
			{
				stop();
			}
			public void windowFocusLost(WindowEvent we)
			{
				stop();
			}
			public void windowIconified(WindowEvent we)
			{
				stop();
			}
		});

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setAlwaysOnTop(true);
		setSize(w,h);
		setUndecorated(true);
		setVisible(true);
		
		qb=new QuestionBank();
		qpan=new QuestionPanel(jpque);
		qb.setQuestions();
		
		JOptionPane.showMessageDialog(this,"\n\nCAN WE START THE TEST  ?\n\n","start test confirm dialog",JOptionPane.INFORMATION_MESSAGE,null);	
		Thread t=new Thread(this);
		t.start();
		qpan.setQuestion(qb.getCurrentQuestion(),qb.getCurrentQuestion().getClientAnswer());
		jbque[qb.current_question].setBorderPainted(true);
	}
	
	public void run()
	{
		for(m=59,s=59;m>=0&&thrdFlg==true;s--)
		{
			try{Thread.sleep(995);}catch(Exception e1){}
			jtime.setText("<html>00<sub style=\"font-size: 20px;color:black;\">H</sub>:"+mstr+m+"<sub style=\"font-size: 20px;color:black;\">M</sub>:"+sstr+s+"<sub style=\"font-size: 20px;color:black;\">S</sub></html>");
			if(s==0)
			{
				s=59;m--;
				if(m==4)
					jtime.setForeground(Color.red);
				sstr="";
				if(m==9)
					mstr="0";
			}
			if(s==10)
				sstr="0";      //for time=0:59:9  >>>>0:59:09  0 prefix for less than 10 sec 
		}
		if(m==-1)
			stop();
	}
	

	public void actionPerformed(ActionEvent ae)
	{
			JButton jb=(JButton)ae.getSource();
			
			if(jb==jbsubmit)
			{
				if(qb.current_question<49)
				{
					if(qpan.getClientAnswer()==null)
					{
						jbque[qb.current_question].setBackground(new Color(230, 33, 1));	
					}
					else
					{
						jbque[qb.current_question].setBackground(new Color(43, 187, 38));
						qb.que[qb.current_question].setClientAnswer(qpan.getClientAnswer());
						
					}
					
					jbque[qb.current_question].setBorderPainted(false);
					qb.current_question++;	
					jbque[qb.current_question].setBorderPainted(true);				 
					qpan.setQuestion(qb.getQuestion(qb.current_question),qb.getCurrentQuestion().getClientAnswer());
					return;
				}
				else if(qb.current_question==49)
				{
					if(qpan.getClientAnswer()==null)
					{
						jbque[qb.current_question].setBackground(new Color(230, 33, 1));	
					}
					else
					{
						jbque[qb.current_question].setBackground(new Color(43, 187, 38));
						qb.que[qb.current_question].setClientAnswer(qpan.getClientAnswer());
						
					}
					
					jbque[qb.current_question].setBorderPainted(false);
					qb.current_question=0;					 
					jbque[qb.current_question].setBorderPainted(true);
					qpan.setQuestion(qb.getQuestion(qb.current_question),qb.getCurrentQuestion().getClientAnswer());
					return;
				}
			}
			
			if(jb==jbskip)
			{
				if(qb.current_question<49)
				{
					if(jbque[qb.current_question].getBackground()!=new Color(43, 187, 38))
						jbque[qb.current_question].setBackground(new Color(230, 33, 1));
					jbque[qb.current_question].setBorderPainted(false);
					qb.current_question++;
					qpan.setQuestion(qb.getQuestion(qb.current_question),qb.getCurrentQuestion().getClientAnswer());
					jbque[qb.current_question].setBorderPainted(true);
					return;
				}
				else if(qb.current_question==49)
				{
					if(jbque[qb.current_question].getBackground()!=new Color(43, 187, 38))
						jbque[qb.current_question].setBackground(new Color(230, 33, 1));
					jbque[qb.current_question].setBorderPainted(false);
					qb.current_question=0;
					qpan.setQuestion(qb.getQuestion(qb.current_question),qb.getCurrentQuestion().getClientAnswer());
					jbque[qb.current_question].setBorderPainted(true);
					return;
				}
			}
			
			if(jb==jbprev)
			{
				if(qpan.getClientAnswer()==null)
				{
					jbque[qb.current_question].setBackground(new Color(230, 33, 1));	
				}
				if(qb.current_question>0)
				{
					jbque[qb.current_question].setBorderPainted(false);
					qb.current_question--;
					qpan.setQuestion(qb.getQuestion(qb.current_question),qb.getCurrentQuestion().getClientAnswer());
					jbque[qb.current_question].setBorderPainted(true);
					return;
				}
				else if(qb.current_question==0)
				{
					jbque[qb.current_question].setBorderPainted(false);
					qb.current_question=49;
					qpan.setQuestion(qb.getQuestion(qb.current_question),qb.getCurrentQuestion().getClientAnswer());
					jbque[qb.current_question].setBorderPainted(true);
					return;
				}
			}
			
			if(jb==jbsubmitTest)
			{
				int flg=JOptionPane.showConfirmDialog(this,"\nARE YOU SURE ?\n\nYOU WANT TO SUBMIT THE TEST ?  \n\n","submit test confirm dialog",JOptionPane.YES_NO_OPTION);
				if(flg==JOptionPane.YES_OPTION)
				{
					thrdFlg=false;
					m=59-m;
					s=60-s;
					calculateResult();
				}
			}
			
			else
			{
				if(qpan.getClientAnswer()==null)
				{
					jbque[qb.current_question].setBackground(new Color(230, 33, 1));	
				}
				jbque[qb.current_question].setBorderPainted(false);
				qb.current_question=(Integer.parseInt(jb.getText()))-1;
				jbque[qb.current_question].setBorderPainted(true);
				qpan.setQuestion(qb.getQuestion(qb.current_question),qb.getCurrentQuestion().getClientAnswer());
			}
	}
	
	void stop()
	{
		JOptionPane.showMessageDialog(this,"\nYOUR TIME LIMIT IS FINISHED \n\nWE ARE GOING TO CLOSE THE TEST. \n\n","close test confirm dialog",JOptionPane.INFORMATION_MESSAGE,null);	
		m=60;
		s=0;
		calculateResult();
	}
	
	void calculateResult()
	{
		String []sans=new String[50];
		String []cans=new String[50];
		
		int totalQue=0,answeredQue=0,correctAnswer=0,wrongAnswer=0;
		
		totalQue=50;
		
		for(int i=0;i<50;i++)
		{
			sans[i]=qb.getQuestion(i).getServerAnswer();
			cans[i]=qb.getQuestion(i).getClientAnswer();
			
			if(cans[i]!=null)
			{
				if(cans[i].equalsIgnoreCase(sans[i]))
					correctAnswer++;
				else
					wrongAnswer++;		
			}		
		}
		answeredQue=correctAnswer+wrongAnswer;
		String t=""+m+":"+s;
		new Form14(rno,t,totalQue,answeredQue,correctAnswer,wrongAnswer);
		setVisible(false);
		getContentPane().setBackground(Color.white);
	}
	
	
	public static void main(String []arga)
	{
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//"com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e){}
		new Online(14301,"Uday Sanjay Barkade");
	}
	
}

