
package linked.list.phonebook;


public class Event {
    
    private String title;
    private String date;
    private String time;
    private String location;
    private Contact contact;
   

    public Event(String title, String date, String time, String location, Contact nwme) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.contact = contact;
    }
    
  
   
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public Contact getCintact() {
        return contact;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCintact(Contact c0ntact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Event{" + "title=" + title + ", date=" + date + ", time=" + time + ", location=" + location + ", contact=" + contact + '}';
    }
    
            
    
    
    
    
    
    
    
    
    
}
