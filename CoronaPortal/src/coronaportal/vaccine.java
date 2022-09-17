
package coronaportal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class vaccine {
               
                DATA data=null;
          
                Scanner s=new Scanner(System.in);
         public vaccine(DATA d) throws ClassNotFoundException {// constructor for the vaccinne class
                    data=d;
                  
                }
                public void displayInfo() throws ClassNotFoundException// displays information for all the members in the database
                {
                   ArrayList<citizen> arr= data.sort_age();
                   for(int i=0;i<arr.size();i++)
                   {
                       System.out.println(arr.get(i).toString());
                   }
                    System.out.println("========================================");   
                } 
                public void displayDone() throws ClassNotFoundException{// displays the list of persons done with both the dose
                   ArrayList<citizen> arr= data.sort_age();
                   for(int i=0;i<arr.size();i++)
                   {
                       if(arr.get(i).isDone==1)
                       {
                       System.out.println(arr.get(i).toString());
                      }
                   }
                    System.out.println("========================================");   
                }
              
                public void DisplayNotDone() throws ClassNotFoundException{// persos not done with a single dose
                   ArrayList<citizen> arr= data.sort_age();
                   for(int i=0;i<arr.size();i++)
                   {
                       if(arr.get(i).fd.equals("0000/00/00")){
                       System.out.println(arr.get(i).toString());
                      }
                   }
                    System.out.println("========================================");   
                }
                public void isQualify(int limit) throws ClassNotFoundException{//done with first and are ready for second
                   ArrayList<citizen> arr= data.sort_age();
                   int count=0;
                   for(int i=0;i<arr.size();i++)
                   {
                     if(count==limit){break;}
                     if(arr.get(i).isDone == 0 ){
                     count++;
                     System.out.println(arr.get(i).toString());
                     }
                      }
                    System.out.println("========================================");   
                }
                public void critical()throws ClassNotFoundException//priority to 60+ people if facing some other desease
                {
                    ArrayList<citizen> arr=data.sort_age();
                    ArrayList<Integer> a1=new ArrayList<Integer>();
                    for(int i=0;i<arr.size();i++)
                    {
                        if(arr.get(i).age >=60){
                            System.out.println("Is the candidate having any other disease..?? Id= "+arr.get(i).id);
                            String ans=s.nextLine();
                            if(ans.equals("yes")){
                            a1.add(arr.get(i).id);
                            }
                        }
                     System.out.println("========================================");   
                    }
                    System.out.println("Ids of Persons under citical list are=");
                    for(int i=0;i<a1.size();i++)
                    {
                        System.out.println(a1.get(i));
                    }
                     System.out.println("========================================");   
                }
               
                
}
