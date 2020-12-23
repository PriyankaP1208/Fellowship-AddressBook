package FellowshipAddressBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class AddressBookMain 
{
	private static final String LINE_SEPARATOR = null;
	public static void main(String[] args) throws IOException
	{
		int choice = 0;
		while(choice<8)
        {
        	
        		System.out.println("1.Create Adress Book 2.Add new person 3.Edit 4.Delete 5.Add Multiple person 6.Check Duplicate Entry 7.Sort by name");
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
            		case 3:
                			Edit();
                			break;
            		case 4:
                			Delete();
                			break;
            		case 5:
                			AddContact();
                			break;
            		case 6:
                			Duplicate();
                			break;
            		case 7:
                			SortByName();
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
        public static void Edit() throws IOException
        {
        	List<String> lines = new ArrayList<String>(); 
        	String line = null;
        	String address,address1,city,city1,state,state1;
        	try
        	{
        		
        		File f1 = new File("info.txt");
        		FileReader fr = new FileReader(f1);
        		BufferedReader br = new BufferedReader(fr);
        		Scanner sc=new Scanner(System.in);
        		System.out.println("Enter address:");
                address=sc.nextLine();
        		System.out.println("Enter address for replace:");
        		address1=sc.nextLine();
        		while ((line = br.readLine()) != null) 
        		{
        			if (line.contains(address))
        				line = line.replace(address, address1);
        			lines.add(line);
        		}
        		System.out.println("Enter city:");
                city=sc.nextLine();
        		System.out.println("Enter city for replace:");
        		city1=sc.nextLine();
        		while ((line = br.readLine()) != null) 
        		{
        			if (line.contains(address))
        				line = line.replace(city, city1);
        			lines.add(line);
        		}
        		fr.close();
        		br.close();
        		FileWriter fw = new FileWriter(f1);
        		BufferedWriter out = new BufferedWriter(fw);
        		for(String s : lines)
        			out.write(s);
        		out.flush();
        		out.close();
        	}
        	catch (Exception ex) 
        	{
                ex.printStackTrace();
            }
        	
        }
        public static void Delete() throws IOException
        {
        	RandomAccessFile file = new RandomAccessFile("info.txt", "rw");
            String delete;
            String task="";
            byte []tasking;
            while ((delete = file.readLine()) != null) {
                if (delete.startsWith("Sonu")) {
                    continue;
                }
                task+=delete+"\n";
            }
            System.out.println(task);
            BufferedWriter writer = new BufferedWriter(new FileWriter("info.txt"));
            writer.write(task);
            file.close();
            writer.close();
        }
        public static void AddContact() throws IOException
        {
        	Person p1=new Person();
    		p1.info();
        }
        public static void Duplicate() throws IOException
        {
        	Scanner sc1 = new Scanner(System.in);
            System.out.println("Enter Name");
            String word = sc1.next();
            boolean flag = false;
            int count = 0;
           Scanner sc2 = new Scanner(new FileInputStream("info.txt"));
            while(sc2.hasNextLine()) {
               String line = sc2.nextLine();
               System.out.println(line);
               if(line.indexOf(word)!=-1) {
                  flag = true;
                  count = count+1;
               }
            }
            if(flag) {
               System.out.println("name already present");
               
            } else
            {
            	System.out.println("No duplicate data found");
            }
        }
        public static void SortByName() throws IOException
        {
        	String inputFile = "info.txt";
    		String outputFile = "output.csv";
    		FileReader fileReader = new FileReader(inputFile);
    		BufferedReader bufferedReader = new BufferedReader(fileReader);
    		String inputLine;
    		List<String> lineList = new ArrayList<String>();
    		while ((inputLine = bufferedReader.readLine()) != null) 
    		{
    			lineList.add(inputLine);
    		}
    		fileReader.close();
    		Collections.sort(lineList);
    		FileWriter fileWriter = new FileWriter(outputFile);
    		PrintWriter out = new PrintWriter(fileWriter);
    		for (String outputLine : lineList) 
    		{
    			out.println(outputLine);
    		}
    		out.flush();
    		out.close();
    		fileWriter.close();            
    }
}
