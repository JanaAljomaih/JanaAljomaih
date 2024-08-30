
package linked.list.phonebook;



public class LinkedList <T >{
 private Node<T> head;
private Node<T> current;
int size ;

public LinkedList (){
head = current = null;
size =0 ;
}
public boolean empty () {
return head == null;
}
public boolean last () {
return current.next == null;
}

public void insert (T val) {
Node<T> tmp;
if (empty()) {
current = head = new Node<T> (val);
}
else {
tmp = current.next;
current.next = new Node<T> (val);
current = current.next;
current.next = tmp;
}
size++;
}

public T remove (T val) {
if (find (val) == false) 
 return null;
 T data = current.getData();
 if (current == head ){
head = head.next;
 }
 else{
Node tmp = head;
  while(tmp.next!= current)
   tmp = tmp.next;
  tmp.next=current.next;
 }
 if(current.next == null)
  current = head;
 else
  current = current.next;
size--;
 return data;

}

public boolean full () {
return false; }
public void findfirst () {
current = head;
}
public void findnext () {
current = current.next; }
public T retrieve () {
return current.data; }
public void update (T val) {
current.data = val; }


public boolean find(T key) {
Node<T> tmp = current;
current = head;
while(current != null) {
if(current.data.equals(key))
return true;
current = current.next;
}
current = tmp;
return false;
}

 public void printList(){
Node p = head;
  while(p != null){
System.out.print(p.data + "   " );
   p = p.next;
  }
  System.out.println("");
 }

public LinkedList lookUp(LinkedList list,String value, String type) { 
	//This 'lookUp' method is the searching method.
	//This method assumes that all input is valid and correct(check the inputs before invoking it).
	//"list" is the LinkedList object to search for the value, basically list of all contacts.
	//"value" is the value you are looking for("Wejdan" or "055555555" or "15/05/1993"...etc).
	//"type" is what type of value you are looking for ("contact_num" or "phone_num" or "email_address" ..etc), it HAS to be string type like the ones below (t1, t2, t3, t4 and t5).

	LinkedList hits = new LinkedList(); //The 'hits' list is the list of contacts that have been found.
	String t1="contact_name";
	String t2="phone_num";
	String t3="email_address";
	String t4="address";
	String t5="birthday";
	if (type.equalsIgnoreCase(t1)) { //if user is searching for a name.
		while(true) { // Explanation:Keeps looping, if it finds a hit it will add the contact to the hits list, otherwise it continues until it reaches the end of the contact list.
			if(list.current.contact_name.equalsIgnoreCase(value)) { //if the name you are looking for matches, then add to the hits list.
				hits.insert(list.current); //Contact added to hits list.
			}
			if(list.last()) //Checks if the end is reached, if yes then stop the 'while' loop, otherwise continue.
				break;
		}
		
		return hits;
	}
	else if (type.equalsIgnoreCase(t2)) { //if user is searching for a phone number.
		while(true) { 
			if(list.current.Phone_num.equalsIgnoreCase(value)) { 
				hits.insert(list.current); 
			}
			if(list.last()) 
				break;
		}
		
		return hits;
	}
	else if (type.equalsIgnoreCase(t3)) { //if user is searching for an email address.
		while(true) { 
			if(list.current.email_address.equalsIgnoreCase(value)) { 
				hits.insert(list.current); 
			}
			if(list.last()) 
				break;
		}
		
		return hits;
	}
	else if (type.equalsIgnoreCase(t4)) { //if user is searching for an address.
		while(true) { 
			if(list.current.address.equalsIgnoreCase(value)) { 
				hits.insert(list.current); 
			}
			if(list.last()) 
				break;
		}
		
		return hits;
	}
	else if (type.equalsIgnoreCase(t5)) { //if user is searching for a birthday.
		while(true) { 
			if(list.current.birthday.equalsIgnoreCase(value)) { 
				hits.insert(list.current); 
			}
			if(list.last()) 
				break;
		}
		
		return hits;
	}
	
	return null; // No contacts with given information was found.
}
}
    

