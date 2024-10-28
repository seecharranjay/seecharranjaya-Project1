public class EndStation extends Station {

    public EndStation(String line, String name) {
        super(line, name);
    }

   
    
    public void makeEnd() {
        if(this.prev == null) {
            this.prev = this.next;
        } else if(this.next == null) {
            this.next = this.prev;
        }
    }

    
    public String toString() {
        return "ENDSTATION " + name + ": " + line + " line, in service: " + available + ", previous station: " 
            + (prev != null ? prev.name : "none") + ", next station: " + (next != null ? next.name : "none");
    }
    


}