//Michelle Pinnock

import java.util.Scanner;
import java.io.*;
import java.text.DateFormat;

class Date     //3h Aggregation   
   {
   	String month;     
   	String day;
   	String year;
   	
   	Date()
      	{
      		month = "";
            day = "";
            year = "";
      	}
   	Date(String mth, String dy, String yr)
      	{
      		month = mth;
      		day = dy;
      		year = yr;
      	}
   	public void setMonth(String mth)
   	   {	
            month = mth;
         }
   	public void setDay(String dy)
   	   {	
            day = dy;
         }
   	public void setYear(String yr)
   	   {	
            year = yr;
         }
   	public String getMonth()
   	   {	
            return month;
         }
   	public String getDay()
   	   {	
            return day;
         }
   	public String getYear()
   	   {	
            return year;
         }
   	public String toString()
      	{
      		String str = "Date: " + month + "/"
      						+ day + "/" + year;
      		return str;
      	}
   }

class Employee    //3a Superclass
   {
         private String name;    //3a Data members
         private String id;      //3a Data members
         private Date date;      //3h Aggregation
         
         public Employee()
            {
               name = null;
               id = null;
               date = null;
            }
         public Employee(String n, String i, Date d)
            {
               name = n;
               id = i;
               date = d;
            }
         public void setName (String n)      //3a Mutator
            {
               name = n;
            }
         public void setID (String i) throws InvalidEmployeeID    //3a Mutator //2 Exceptopn Handling
            {
               if(i.length() != 5)
                  throw new InvalidEmployeeID(i);
                  
               id = i;
            }
         public void setDate (Date d)     //3a Mutator
            {
               date = d;
            }
         public String getName ()   //3a Accessor
            {
               return name;
            }
         public String getID ()     //3a Accessor
            {
               return id;
            }
         public Date getDate ()     //3a Accesor
            {
               return date;
            }
         public String toString()      //3a toString method
            {
               String str = "Employee name is " + name 
                                               +"\nEmployee id is " + id
                                               +"\nEmployee was hired on " + date.toString();
               return str;
            }
} 

class SalesManager extends Employee    //3b Subclass
   {
      private static int shift;     //3b Data Member //3f Static Member 
      private int annualPay;     //3b Data Member

      
      public SalesManager()
         {
            super();
            shift = 0;
            annualPay = 0;
         }
      public SalesManager(String n, String i, Date d, int s, int p)
         {
           super(n, i, d);
           shift = s;
           annualPay = p;
         }    
      public void setShift(int s) throws InvalidShift    //3b Mutator //2 Exceptopn Handling
         {
            if(s == 1 || s == 2)
               shift = s;
            else
               throw new InvalidShift(s);
         }
      public int getShift()      //3b Accessor
         {
            return shift;
         }
      public void setAnnualPay(int p) throws InvalidAnnualPay     //3b Mutator //2 Exceptopn Handling
         {
            if(p < 30000)
               throw new InvalidAnnualPay(p);
            if(p > 50000)
               throw new InvalidAnnualPay(p);
            annualPay = p;
         }
      public int getAnnualPay()     //3b Accessor
         {
            return annualPay;
         }
      public String toString()      //3b toString method //3e Method Overriding
         {
            String str = "Employee name is " + getName() 
                                               +"\nEmployee id is " + getID()
                                               +"\nEmployee was hired on " + getDate()
                                               +"\nEmployee works shift: " + shift 
                                               +"\nEmployee's annual pay rate is " + annualPay; 
                                   
            return str ;                       
         }
         
   }

class InvalidEmployeeID extends Exception    //2 Exception Handling
   {
      public InvalidEmployeeID()
         {
            super("Error: Invalid employee id entered.");
         }
      public InvalidEmployeeID(String id)
         {
            super("Error: Invalid employee id entered: " + id);
         }
   }

class InvalidShift extends Exception      //2 Exception Handling
   {
      public InvalidShift()
         {
            super("Error: Invalid shift was entered.");
         }
      public InvalidShift(int shift)
         {
            super("Error: Invalid shift was entered: " + shift);
         }
   }

class InvalidAnnualPay extends Exception     //2 Exception Handling
   {
      public InvalidAnnualPay()
         {
            super("Error: Invalid annual pay was entered.");
         }
      public InvalidAnnualPay(int annualPay)
         {
            super("Error: Invalid annual pay was entered: " + annualPay);
         }
   }

interface Run     //3c Interface
   {
       public abstract void hold();    //3c Abstract Method
       public abstract void process();    //3c Abstract Method
   }
class Message implements Run
   {
      public void hold()
         {
            System.out.println("\nOne moment please ...");
         }
      public void process()
         {
            System.out.println("System will calculate hours worked this week");
         }
   }
class Rating
   {
      void sum (int a)     
         {
            System.out.println("Your service skills rating is " + (a) + "/10") ;
         }
      void sum (double a)     //3d Method Overloading
         {
            System.out.println("Your orienation rating is " + (a) + "/10");
         }
   }
public class EmployeeRecord
   {
      static void display()      //3f Static Method
         {
            System.out.println("Greetings!!\n");
         }
      public static void main(String[] args) throws IOException
         {  
            display();
            System.out.println("Notice:\n If wrong information is enter, system will show error" 
                                          + " and automatically sign out you. \nYou will be required" 
                                          + " to re-eneter your information");       
            while(true)
               {
                  try      //2 Exception Handling
                     {
                        Scanner keyboard = new Scanner(System.in);
                        int annualPayAmt;
                        int shiftNum;
                        String _id;
                        
                        SalesManager m1 = new SalesManager();     //3g Polyorphism
                        
                        m1.setName("Jacob Latimore");
                        Date empDate = new Date("7", "19", "2005");
                        
                        m1.setDate(empDate);
                        
                        System.out.println("");
                        
                        System.out.print("Enter your five character employee id" 
                                          + "\nId can be a mix of numbers, letters, or sysmbols (EX: 22222): ");
                        _id = keyboard.nextLine();
                        m1.setID(_id);
                        
                        System.out.print("Enter shift 1 to indicate you work the weekday shift \nEnter shift 2 to indicate you work the weekend shift: ");
                        shiftNum = keyboard.nextInt();
                        ((SalesManager)m1).setShift(shiftNum);
                                 
                        System.out.print("Enter your annual pay(between $30000-$50000): ");
                        annualPayAmt = keyboard.nextInt();
                        ((SalesManager)m1).setAnnualPay(annualPayAmt);
                        
                        System.out.println("\n" + m1);
                        break;   
                     }
             
            catch(InvalidEmployeeID e)
               {
                  System.out.println(e.getMessage());
               }
            catch(InvalidShift e)
               {
                  System.out.println(e.getMessage());
               }
            catch(InvalidAnnualPay e)
               {
                  System.out.println(e.getMessage());
               }
            catch(Exception e)
               {
                  System.out.println(e.getMessage());
               }
            }
            Scanner keyboard = new Scanner(System.in);
            int totalHr = 0;
            String fileName;
            
            System.out.print("\nEnter the file name: ");      //1 File input & output     /Users/Mishy/Desktop/TimeCard.txt
            fileName = keyboard.nextLine();
            
            File myFile = new File(fileName);
            Scanner inputFile = new Scanner(myFile);
            
            while(inputFile.hasNext())
               {
                  int number = inputFile.nextInt();
                  totalHr = totalHr + number;
               }
            
            inputFile.close();
            
            Run message = new Message();     //3g Polymorphism
            message.hold();
            message.process();
      
            System.out.println("\nThe total number of hours worked for the week are " + totalHr + " hours");
            
            System.out.println("\nSystem is now retriving your employee ratings...\n");
            
            Rating  r1 = new Rating();    //3g Polymorphism
            r1.sum (10);       
            r1.sum (9.6); 
            
         }
   } 
