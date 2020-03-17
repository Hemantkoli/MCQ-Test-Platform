import java.sql.*;
import java.util.*;
public class QuestionData 
{
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://vishal:3306/database2?useSSL=true";
	String user="root";
	String password="vishal@123";
	String sql="";
	PreparedStatement stat;
	Connection conn;
	ResultSet rs;
	QuestionData()
	{
		try
		{
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			//stat=conn.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	String[][] getQuestionData()
	{
		int i=0,j=0;
		String s[][]=new String[50][8];
		Vector<Integer> v=new Vector<Integer>(51);
		int a[]=new int[50];
		for(int k=1;k<=51;k++)
			v.add(new Integer(k));
		for(int t=0;t<50;t++)
		{
			int n=(int)(Math.random()*v.size());
			//System.out.print(n+"   ");
			if(n==0)
				n=1;
			if(n==v.size())
				n=1;
			a[t]=v.get(n).intValue();
			v.remove(n);
			
		}
		//System.out.println(v.size()+"  "+v);
			//v.remove(50);
		//for(int t=0;t<50;t++)
		//System.out.print(t+" : "+a[t]+"   ");
		//System.out.println(a[i]);
		i=0;
		try
		{
			while(i<50)
			{
				sql="select * from question where qno=?";
				stat=conn.prepareStatement(sql);
				stat.setInt(1,a[i]);
				rs=stat.executeQuery();
				while(rs.next())
				{
					for(j=1;j<=8;j++)
					{
						s[i][j-1]=rs.getString(j);
					}
					//i++;
					
				}
			//	System.out.print(a[i]+" ");
				i++;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
		
	}	
	public static void main(String args[])
	{
		QuestionData q=new QuestionData();
		String s[][]=new String[50][8];
		s=q.getQuestionData();
		for(int i=0;i<50;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(s[i][j]+"   ");
			}
			System.out.println();
		}
	}
}