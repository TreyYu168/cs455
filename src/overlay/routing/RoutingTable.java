package overlay.routing;

import java.util.ArrayList;

public class RoutingTable {

    private ArrayList<RoutingEntry> routingTable;

    public RoutingTable() {
        this.routingTable = new ArrayList<RoutingEntry>();
    }

    public RoutingTable(ArrayList<RoutingEntry> routingTable){
        this.routingTable = routingTable;
    }

    public synchronized void add (RoutingEntry routingEntry) {
        routingTable.add(routingEntry);
    }

    public synchronized RoutingEntry getEntry(int index) {
        return routingTable.get(index);
    }
}
