package FellowshipAddressBook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddressBookMain 
{
	private static final String LINE_SEPARATOR = null;
	public static void main(String[] args) throws IOException
	{
		int choice = 0;
		while(choice<8)
        {
        	
        		System.out.println("1.Create Adress Book 2.Add new person");
        		System.out.println("Enter your choice:");
        		Scanner s1=new Scanner(System.in);
        		choice=s1.nextInt();
        		switch(choice)
            	{
            		case 1:
                        	CreateAdressBook();
                        	break;
            		case 2:
                			Add();
                			break;
            	}
        }
	}
		public static void CreateAdressBook() throws IOException
        {
                String filename,fname,lname,address,city,state,zip,phno;
                Scanner sc=new Scanner(System.in);
                File f1=new File("info.txt");
                FileWriter outputfile = new FileWriter(f1);
                BufferedWriter bw=new BufferedWriter(outputfile);
                PrintWriter pw=new PrintWriter(bw);
                System.out.println("\n Enter First Name");
                fname=sc.nextLine();
                System.out.println("\n Enter Last Name");
                lname=sc.nextLine();
                System.out.println("\n Enter Address");
                address=sc.nextLine();
                System.out.println("\n Enter City");
                city=sc.nextLine();
                System.out.println("\n Enter state");
                state=sc.nextLine();
                System.out.println("\n Enter zip code");
                zip=sc.nextLine();
                System.out.println("\n Enter phone number");
                phno=sc.nextLine();
                pw.println(fname+" "+lname+" "+address+" "+city+" "+state+" "+zip+" "+phno+" ");
                pw.flush();
        }
        public static void Add() throws IOException
        {
        	Person p1=new Person();
    		p1.info();
        }
}
