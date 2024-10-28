import java.util.Set;
import java.util.HashSet;
import java.util.*;

public  class Station {

    protected String name;
    protected String line;
    protected boolean available;
    protected Station prev;
    protected Station next;

    public Station(String line, String name) {
        this.line = line;
        this.name = name;
        this.available = true;  
        this.prev = null;
        this.next = null;
    }

    public void addNext(Station next) {
        this.next = next;
        if (next.prev == null) {
            next.prev = this;
        }
    }

    public void addPrev(Station prev) {
        this.prev = prev;
        if (prev.next == null) {
            prev.next = this;
        }
    }

    public void connect(Station other) {
        this.addNext(other);
        other.addPrev(this);
    }

    public void switchAvailable() {
        this.available = !this.available; 
    }

     public boolean isAvailable() {
        return this.available;
    }


    public int tripLength(Station dest) {
        //Set<Station> visited = new HashSet<>();
        //return tripLengthHelper(dest, visited);

        int count = 0;
        return tripLength(dest, new HashSet<>(), count);
    }

    protected int tripLength(Station dest, Set<Station> visited, int count) {
        if (this.equals(dest)) {
            return count;
        }

        visited.add(this); 

        //int result = next.tripLengthHelper(dest, visited); 

        if (next != null && !visited.contains(this.next)) {
            int nextResult = next.tripLength(dest, visited, count + 1);
            if (nextResult != -1) {
                return nextResult;
            }
        }

        if (this instanceof TransferStation) {
            //TransferStation transferStation = (TransferStation) this;
            for (Station transferStation: ((TransferStation) this).otherStations) {
                if (!visited.contains(transferStation)) {
                    int transferResult = transferStation.tripLength(dest, visited, count + 1);
                    if (transferResult != -1) {
                        return transferResult;
                    }
                }
            }
        }
        return -1;


    
    }


        
        
    

    
    //public void setOutOfService() {
      //  this.inService = false;
    //}

    
   
    public boolean equals(Object obj) {
        Station temp = (Station) obj;
        return line.equals(temp.line) && name.equals(temp.name);
    }

    //public int compareTo(Station other) {  
        //return this.name.compareTo(other.name);
    //}

    
    public String toString() {

        return "STATION " + name + ": " + line + " line, in service: " + available +
                ", previous station: " + (prev != null ? prev.name : "none") + ", next station: " + (next != null ? next.name : "none");
    }



}