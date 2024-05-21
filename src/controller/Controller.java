package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

import model.Model;

import model.Model;
class Connect{
	static Connection conectivity() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentt","root","abc123");
		Statement st=con.createStatement();
		return con;
	
	}

}



public class Controller 
{
	public void LodingBar() throws InterruptedException
	{
		 System.out.print("Loding");
		  
	       for (int i = 0; i <=10; i++) {
	       	System.out.print(".");
	           Thread.sleep(100); 
	          
	       }
	       System.out.println("\nLoading Completed!");
	       System.out.println("---------------------");

		
		
		
	}

Scanner s=new Scanner (System.in);

	public void insert() throws ClassNotFoundException, SQLException{
		
		
		try{
		System.out.println("Enter the no. of Student");
		int	no=Integer.parseInt(s.nextLine());
		for(int i=0;i<no;i++){
			System.out.println(i+1+" :Enter the roll no");
	   int  roll=Integer.parseInt(s.nextLine());
	     System.out.println("Enter the name");
	   String   name=s.nextLine();
	     System.out.println("Enter the address");
	   String  address =s.nextLine();
	   Connection c=Connect.conectivity();
	   Statement st =c.createStatement();
	    int a = st.executeUpdate("INSERT INTO stu VALUES("+roll+",'"+name+"','"+address+"')");
			if(a>0)	{
				
				System.out.println("data inserted");
				System.out.println("Step 4 done");
				
			}
			else{
				System.out.println("data not inserted");
			}
		
		}
		}
		catch (Exception p){
			System.out.println("Roll no. is reapeted data not inserted :"+p);
			 
		}
		
	}
	
	public void show() throws ClassNotFoundException, SQLException{
		Connection c=Connect.conectivity();
		   Statement st =c.createStatement();
		 ResultSet rs = st.executeQuery("SELECT * FROM stu");
		    while (rs.next()) {
		      
	        	        System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		    }

			
			
		
	}
	public void search() throws ClassNotFoundException, SQLException{
		
		try{
		boolean found= false;
				Connection c=Connect.conectivity();
               Statement st =c.createStatement();

			    System.out.print("Enter the roll no to search: ");
	            int searchroll = Integer.parseInt(s.nextLine());
	         //   String sql = ("SELECT * FROM stu WHERE id = ?");
//	            PreparedStatement st1 = c.prepareStatement(sql);
//	            st1.setInt(1, searchroll);
	            ResultSet rs = st.executeQuery("SELECT * FROM stu WHERE id = "+searchroll+"");
	            while (rs.next()) {
//	            	int id =rs.getInt("id");
					System.out.println(rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getString(3));
                found=true;
	            }
	            if(!found){
	            	System.out.println("Student not found");
	            }
		
		}
		catch (Exception p){
			System.out.println("Enter the no. :"+p);
			 
		}
	            
		}
	
	public void delete() throws ClassNotFoundException, SQLException{
		try{
		Connection c=Connect.conectivity();
        Statement st =c.createStatement();
		boolean delete=false;
		System.out.println("enter the roll no. to delete");
	int	roll=Integer.parseInt(s.nextLine());
	
	if	(roll==roll){
			 int d=st.executeUpdate("DELETE FROM stu WHERE id="+roll+"");
				System.out.println("data deleted");
				delete =true;

		}
		if(!delete){
			System.out.println("Student not found");
		}
		}
		catch (Exception p){
			System.out.println("Enter the no. :"+p);
			 
		}
		
	
	}
	public void update() throws ClassNotFoundException, SQLException{
		try{
		
		Connection c=Connect.conectivity();
        Statement st =c.createStatement();
		System.out.println("What do you want to update");
		System.out.println("1.Name");
		System.out.println("2.Address");
		System.out.println("Enter the choice");
		int cho=Integer.parseInt(s.nextLine());
		switch(cho)
		{ 
		
		case 1:
		System.out.println("enter the roll no");
	int	roll=Integer.parseInt(s.nextLine());
		System.out.println("Enter the name");
	String	name=s.nextLine();
		 int b=st.executeUpdate("UPDATE stu SET name = '"+name+"'  WHERE id = "+roll+"");
            if(b>0){
            	System.out.println("Data updated");
            }
            else{
            	System.out.println("Student not found");
            }
		
				
            break;
            
		case 2:
			boolean update=false;
			System.out.println("enter the roll no");
			roll=Integer.parseInt(s.nextLine());
		
			System.out.println("Enter the address");
			 String address=s.nextLine();
			
			 int d=st.executeUpdate("UPDATE stu SET address = '"+address+"'  WHERE id = "+roll+"");
	            if(d>0){
	            	System.out.println("Data updated");
	            }
	            else{
	            	System.out.println("Student not found");
	            }
	        break;
		        }
		}
		catch (Exception p){
			System.out.println("Enter the no :(  "+p);
			 
		}
		
	}
}
	

