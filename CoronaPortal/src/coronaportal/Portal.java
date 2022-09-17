
package coronaportal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;


public class Portal {

   
   
    public static void main(String[] args) throws ClassNotFoundException, ParseException {
        // TODO code application logic here
        DATA data=new DATA();
        
         data.basic_add();
            Scanner obj = new Scanner(System.in);
            Scanner sc=new Scanner(System.in);
      
        int ch=0;
        vaccine vac=new vaccine(data);
        while(ch != 7){
            System.out.println("***Corona Vaccination Portal****");
            System.out.println("=====Main Menu======");
            System.out.println("1.Insert New Entry");
            System.out.println("2.Display Information");
            System.out.println("3 Display Not done list");
            System.out.println("4.Display Done List");
            System.out.println("5.Execute the next Dose");
            System.out.println("6.Check citical list");
            System.out.println("7.To Exit");
            System.out.println("==Enter your choice==");
            ch=obj.nextInt();
            
            switch(ch)
            {
            case 1://Inserting new items in the dataset
                System.out.println("Enter id  ---  ");
                int i=obj.nextInt();
                System.out.println("Enter name  ---  ");
                String n=sc.nextLine();
                System.out.println("Enter city  ---  ");
                String cit=sc.nextLine();
                System.out.println("Enter age   ---  ");
                int a=obj.nextInt();
                System.out.println("Enter phone number   ---  ");
                String p=sc.nextLine();
                System.out.println("Enter gender in character (m - male ; f - female ; o - other)  ---  ");
                char g=sc.nextLine().charAt(0);
                System.out.println("Enter first dose date in format (yyyy/dd/mm) please   ---  ");
                 
               String f=sc.nextLine();
                System.out.println("Enter second dose date in format (yyyy/dd/mm) please   ---  ");
                String s=sc.nextLine();

                citizen c=new citizen(i,n,cit,a,p,g,f,s);
                data.DATA_entry(c);
                
                break;
            case 2:  //display total info
                vac.displayInfo();
                break;
            case 3:   //display notdone info
                vac.DisplayNotDone();
                break;
           
            case 4:   //display who done full dose
                vac.displayDone();
                break;
            case 5: 
                 //display next list of persons for vaccination
                    System.out.println("Enter number of doses ready to vaccinate -- ");
                    i=obj.nextInt();
                    System.out.println("list of persons for next "+i+" doses are -- ");
                    vac.isQualify(i);
        
                break;
            case 6:
                    System.out.println("You selected to check critical list");
                    vac.critical();
                    break;
                
            case 7: 
                    System.out.println("You selected to Exit");
                    break;
            default: 
                    System.out.println("Invalid choice Please enter a valid choice");
                    break;
                        
            }
     }
   }
 }
