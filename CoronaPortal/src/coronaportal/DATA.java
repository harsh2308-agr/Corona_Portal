
package coronaportal;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DATA {
  
  
       
        Connection con = null;
		Statement state = null;
		ResultSet rs = null;
                String url = "jdbc:mysql://localhost:3306/corona";
		String username = "root";
		String password = "";
		
              public void DATA_entry(citizen c) throws ClassNotFoundException{  
	try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
		   
		    state = con.createStatement();
                    
                
                    
                   
        String  status="INSERT INTO public(ID,NAME,AGE,CITY,GENDER,PHONE_NO,FIRST_DOSE_DATE,SECOND_DOSE_DATE,COMPLETED) "
        + "VALUES( "+c.id+" , '"+c.name+"' , "+c.age+" , '"+c.city+"' , '"+c.gender+"' , '"+c.phone_no+"' , '"+c.fd+"' , '"+c.sd+"' , "+c.isDone+" );" ;
                    
                  
		  int l = state.executeUpdate(status);
                   
                  con.close();  
                  System.out.println("done insertion sucessfully");
		
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} 
        
    }
     public ArrayList<citizen> sort_age() throws ClassNotFoundException{
         
         ArrayList<citizen> arr=new ArrayList<citizen>();
         try {
             
                     Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
		   
		    state = con.createStatement();
                    
                 
                   String status="select* \nfrom public\norder by age desc; ";
                    rs = state.executeQuery(status);
                    while(rs.next()){
                        int i=rs.getInt(1);
                        String n=rs.getString(2);
                        String c=rs.getString(4);
                        int ag=rs.getInt(3);
                        String phone=rs.getString(6);
                        char g;
                         g = rs.getString(5).charAt(0);
                        String f=rs.getString(7);
                        String s=rs.getString(8);
                        citizen c2=new citizen(i,n,c,ag,phone,g,f,s);
                        arr.add(c2);
                    }
                    con.close();  
                    //System.out.println("done insertion sucessfully");
		
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
         
         return arr;
     } 
     public void basic_add() throws ClassNotFoundException{
        String f="2021/03/26";
        String s="2021/04/23";
        
        citizen c=new citizen(101,"Ram","Nagpur",45,"9898788766",'m',f,s);
        DATA_entry(c);
        f="2021/01/26";
        s="2021/02/25";
        c=new citizen(102,"Shyam","Raipur",49,"9893238766",'m',f,s);
        DATA_entry(c);
        f="0000/00/00";
        s="0000/00/00";
        c=new citizen(103,"Rani","Raipur",51,"9893238899",'f',f,s);
        DATA_entry(c);
        f="2021/03/06";
        s="2021/04/02";
        c=new citizen(104,"Rakesh","Mumbai",49,"9232238766",'m',f,s);
        DATA_entry(c);
       f="2021/01/07";
        s="0000/00/00";
        c=new citizen(105,"Rekha","Nagpur",46,"9090909090",'f',f,s);
        DATA_entry(c);
        f="2021/03/12";
        s="2021/04/10";
        c=new citizen(106,"Prathmesh","Akola",55,"8667755443",'m',f,s);
        DATA_entry(c);
       f="0000/00/00";
        s="0000/00/00";
        c=new citizen(107,"Rashmi","Nagpur",60,"8989898989",'f',f,s);
        DATA_entry(c);
        f="2021/02/01";
        s="2021/02/28";
        c=new citizen(108,"Ajay","Wardha",48,"9834348766",'m',f,s);
        DATA_entry(c);
        f="2021/01/08";
        s="0000/00/00";
        c=new citizen(109,"Avaneet","Thane",61,"8787878787",'f',f,s);
        DATA_entry(c);
       f="2021/02/17";
        s="2021/03/15";
        c=new citizen(110,"Saloni","Delhi",65,"8686868686",'f',f,s);
        DATA_entry(c);
    }
   
    
}

