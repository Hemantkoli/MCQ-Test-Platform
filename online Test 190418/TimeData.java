import java.sql.*;
import java.util.*;

class TimeData 
{
	String driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://vishal:3306/time?useSSL=true";
	String user="root";
	String password="vishal@123";
	PreparedStatement stat;
	Statement stat1;
	String sql;
	Connection conn;
	TimeData()
	{
		try
		{
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
		}
		catch(Exception e){System.out.println(e);}
	}
	void setTime()
	{
		while(true)
		{
			Calendar c=Calendar.getInstance();
			String s=c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
			String sql1="update time set time=? where no=1";
			try{
			stat=conn.prepareStatement(sql1);
			stat.setString(1,s);
			stat.executeUpdate();
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception e11){}
			}
			catch(Exception e){}
		}
	}
	 String getTime()
	{
		try
		{
			sql="select * from time where no=1";
			stat1=conn.createStatement();
			ResultSet rs=stat1.executeQuery(sql);
			while(rs.next())
				return rs.getString("time");
		}
		catch(Exception e){System.out.println("as");}
		return "NO";
	}
	
	public static void  main(String args[])
	{
		TimeData t=new TimeData();
		t.setTime();
		System.out.println(t.getTime());
		/*while(true)
		{
			//System.out.println(t.getTime());
			//try
			//{
				Thread.sleep(1000);
			}
			catch(Exception e11){}
		}*/
	}
}