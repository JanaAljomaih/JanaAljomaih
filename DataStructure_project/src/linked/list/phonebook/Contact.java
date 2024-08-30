
package linked.list.phonebook;




import java.util.Scanner;

public class Contact implements Comparable<String> {
    private String Contact_name;
    private String Phone_num;
    private String Email_address;
    private String Address;
    private String Birthday; //or data type
    private String Notes;
    
    Scanner input = new Scanner(System.in);
    
    public Contact(String Contact_name, String Phone_num, String Email_address, String Address, String Birthday, String Notes) {
        this.Contact_name = Contact_name;
        this.Phone_num = Phone_num;
        this.Email_address = Email_address;
        this.Address = Address;
        this.Birthday = Birthday;
        this.Notes = Notes;
    }
    
    public int CompareTo(String name){
       return Contact_name.compareTo(name);
    }
    
    public void new_contact(){
        System.out.println("Enter the contact's name:");
        Contact_name=input.nextLine();
        System.out.println("Enter the contact's phone number:");
        Phone_num=input.nextLine();
        System.out.println("Enter the contact's email address: ");
        Email_address=input.nextLine();
        System.out.println("Enter the contact's address: ");
        Address=input.nextLine();
        System.out.println("Enter the contact's birthday:");
        Birthday=input.nextLine();
        System.out.println("Enter any notes for the contact:");
        Notes=input.nextLine();
    }
    
    
    public String getContact_name() {
        return Contact_name;
    }

    public void setContact_name(String Contact_name) {
        this.Contact_name = Contact_name;
    }

    public String getPhone_num() {
        return Phone_num;
    }

    public void setPhone_num(String Phone_num) {
        this.Phone_num = Phone_num;
    }

    public String getEmail_address() {
        return Email_address;
    }

    public void setEmail_address(String Email_address) {
        this.Email_address = Email_address;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    
    public String toString() {
        return "Contact_name = " + Contact_name + " Phone_num = " + Phone_num + " Email_address = " + Email_address + " Address = " + Address + " Birthday = " + Birthday + " Notes = " + Notes ;
    }

    @Override
    public int compareTo(String o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}