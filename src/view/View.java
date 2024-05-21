package view;

import java.sql.SQLException;
import java.util.Scanner;

import controller.Controller;
import controller.Controller;

public class View {

	
	
	
	public View() throws ClassNotFoundException, SQLException
	{
		 //System.out.println("      *                *  ");
		  System.out.println("      * * *           * * *");
	      System.out.println("    *       *       *        *");
	      System.out.println("  *           *   *            *");
	      System.out.println(" *              *               *");
	      System.out.println("*                                *");
	      System.out.println("*      WELCOME TO MY PROJECT     *");
	      System.out.println(" *                               *");
	      System.out.println("  *                             *");
	      System.out.println("    *                         *");
	      System.out.println("      *                     *");
	      System.out.println("        *                 *");
	      System.out.println("           *           *");
	      System.out.println("              *     *");
	      System.out.println("                 *");
		menu();
		
	}
	public void menu() throws ClassNotFoundException, SQLException{
	 boolean loop=true;
	   Scanner sc=new Scanner(System.in);
	   Controller c=new Controller();
	   
	
	while(loop)
	{
		try {
			c.LodingBar();
		} catch (InterruptedException e2) 
		{
			e2.printStackTrace();
		}
		System.out.println(":::::::LIST::::::");
	
		System.out.println("1.Add Student     :");
		System.out.println("2.Show Student    :");
		System.out.println("3.Search Student  :");
		System.out.println("4.Delete Student  :");
		System.out.println("5.Update Student  :");
		System.out.println("0.Exit            :");

	
	System.out.println("Enter Your Choice : ");
	int ch=Integer.parseInt(sc.nextLine());
	switch(ch)
	{
	case 1:
		c.insert();
		break;
	case 2:
		c.show();
		break;
	case 3:
		c.search();
		break;
	case 4:
		c.delete();
		break;
	case 5:
		c.update();
		break;
	case 0:
		System.out.println("Thank you ~");
		loop=false;
		break;
		default:
	}

	

	
	
	}}

}
