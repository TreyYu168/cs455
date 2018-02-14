package overlay.routing;

public class RoutingEntry {

    private int nodeID;
    private byte length;
    private byte[] ip;
    private int portNum;

    public RoutingEntry(int nodeID, byte length, byte[] ip, int portNum) {
        this.nodeID = nodeID;
        this.length = length;
        this.ip = ip;
        this.portNum = portNum;

    }

    public int getNodeID() {
        return this.nodeID;
    }

    public byte getLength() {
        return  this.length;
    }

    public byte[] getIp() {
        return this.ip;
    }

    public int getPortNum() {
        return this.portNum;
    }
}
