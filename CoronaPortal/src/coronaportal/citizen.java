
package coronaportal;



import java.util.*;
public class citizen
{
    int id,age;
    String name=new String();
    String city =new String();
    String phone_no=new String();
    String fd=new String();
    String sd=new String();
    int isDone;
    char gender;
    
    public citizen(int i,String n,String c,int ag,String phone,char g,String f,String s){
        id=i;
        city=c;
        gender=g;
        this.age=ag;
        name=n;
        fd=f;
        sd=s;
        phone_no=phone;
        if(sd.equals("0000/00/00")){
            isDone=0;
        }
        else
        {
            isDone=1;
        }
        
    }
    @Override
    public String toString(){
       String s=id+" "+name+" "+age+" "+city+" "+phone_no+" ";
          if(isDone==0){
           s=s+"False";
          }
          else{
           s=s+"True";
           }
        return s;
    }
 }
