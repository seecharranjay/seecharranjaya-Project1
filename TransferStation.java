import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.*;


public class TransferStation extends Station {

    ArrayList<Station> otherStations;  

    public TransferStation(String line, String name) {
        super(line, name);
        this.otherStations = new ArrayList<>();
    }

   
    public void addTransferStationNext(Station station) {
        this.otherStations.add(station);
        if (station.prev == null) {
            station.prev = this;
        }
    }

    public void addTransferStationPrev(Station station) {
        this.otherStations.add(station);
        if (station.next == null) {
            station.next = this;
        }
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TRANSFERSTATION ").append(name).append(": ").append(line).append(" line, in service: ").append(available)
        .append(", previous station: ").append(prev != null ? prev.name : "none")
        .append(", next station: ").append(next != null ? next.name : "none")
        .append("\n\tTransfers: \n");

        /*
        StringBuilder sb = new StringBuilder("TRANSFER STATION " + name + ": " + line + " line, in service: " 
        + available + ", previous station: " + (prev != null ? prev.name : "none") + ", next station: "
        + (next != null ? next.name : "none") + "\n\tTransfers: \n");
        */


        for (Station s : otherStations) {
            sb.append("\t").append(s.toString()).append("\n");
        }

        return sb.toString();
    }
}