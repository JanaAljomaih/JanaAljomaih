
package linked.list.phonebook;

import java.util.Scanner;


public class Phonebook{
    public static Scanner input= new Scanner(System.in);


    public static LinkedList <Contact> contacts = new LinkedList<Contact>();
    public static LinkedList <Event> Events = new LinkedList<Event>();
    
    public  static LinkedList<Event>  arrangeAlpha(){
        if(Events.empty())
            return null;
      
      LinkedList <Event> output = new LinkedList<Event>();  
      String name;
      
      Events.findfirst();
       name = Events.retrieve().getTitle();
      while(!Events.last())
          Events.findnext();
      if(name.charAt(0) < Events.retrieve().getTitle().charAt(0))
         output.insert(val);
      
      
      
      for(int i =0 ; i < Event.length();i++){
          
          
          
      }
              
       
       
       
       
       return output;
    }

}
