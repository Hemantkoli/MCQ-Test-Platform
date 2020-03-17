import java.sql.*;
import java.util.*;
import java.io.*;
public class StudentData 
{
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://vishal:3306/database1?useSSL=true";
	String user="root";
	String pass="vishal@123";
	String sql="";
	
	Connection conn;
	PreparedStatement stat;
	Statement stat1;
	
	ResultSet rs=null;
	
	StudentData()
	{
		try
		{
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,pass);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	String getName(int r)
	{
		try
		{
			
			TimeData td=new TimeData();
			sql="update student set login='"+td.getTime()+"' where rollno=?";
			stat=conn.prepareStatement(sql);
			stat.setInt(1,r);
			
			stat.executeUpdate();
			
			sql="select name from student where rollno=?";
			stat=conn.prepareStatement(sql);
			stat.setInt(1,r);
			
			rs=stat.executeQuery();
			while(rs.next())
				return rs.getString("name");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "NOT DATA FOUND";
	}
	void getImage(int rollno)
	{
		try
		{
			stat1=conn.createStatement();
			rs=stat1.executeQuery("SELECT image from student where rollno='"+rollno+"'");
			rs.next();
			File file=new File("images/"+rollno+".png");
			FileOutputStream fos=new FileOutputStream(file);

			Blob blob=rs.getBlob("image");
			byte b[]=blob.getBytes(1,(int)blob.length());
			System.out.println(b.length);
			fos.write(b);
			fos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	String getPassword(int r)
	{
		try
		{
			sql="select password from student where rollno=?";
			stat=conn.prepareStatement(sql);
			stat.setInt(1,r);
			rs=stat.executeQuery();
			while(rs.next())
				return rs.getString("password");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "password";
	}
	
	void setMark(int r,int m,String t)
	{
		try
		{
			sql="update student set mark=?,time=?,submit='YES' where rollno=?";
			stat=conn.prepareStatement(sql);
			stat.setInt(1,m);
			stat.setString(2,t);
			stat.setInt(3,r);
			stat.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void setTime(int r,String t)
	{
		try
		{
			sql="update student set login=? where rollno=?";
			stat=conn.prepareStatement(sql);
			stat.setString(1,t);
			stat.setInt(2,r);
			stat.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	String[][] getSortedData(int sort)
	{
		String s[][]=new String[56][6];
		int i=0,j=0;
		try
		{
		
			if(sort==1)
				sql="select * from student order by rollno asc";
			else
				sql="select * from student order by mark desc,time asc";
			stat1=conn.createStatement();
			rs=stat1.executeQuery(sql);
			while(rs.next())
			{
				for( j=1;j<7;j++)
				{
					s[i][j-1]=rs.getString(j);
				}
				i++;
			}
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}
		return s;
	}
	
	public static void main(String args[])
	{
		StudentData s=new StudentData();
			/*System.out.println("password  :  "+s.getPassword(14302));
			s.setMark(14302,0,55.56+"");
		String s1[][]=s.getSortedData();
		for(int k=0;k<s1.length;k++)
			{
				for(int j=0;j<5;j++)
				{
					System.out.print(s1[k][j]+"    ");
				}
				System.out.println();
			}
			TimeData td=new TimeData();
			td.setTime();*/
			s.getImage(14302);
	}
}