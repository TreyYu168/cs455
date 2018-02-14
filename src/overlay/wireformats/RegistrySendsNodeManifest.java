package overlay.wireformats;

import overlay.routing.RoutingEntry;
import overlay.routing.RoutingTable;

import java.io.*;

public class RegistrySendsNodeManifest implements Event{

    final static byte messageType = 6;
    private byte tableSize;
    private RoutingTable routingTable;
    private RoutingEntry routingEntry;
    private byte numOfNodes;
    private int[] nodes;


    public RegistrySendsNodeManifest(byte[] marshaledBytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        byte tableSize = dataInputStream.readByte();
        routingTable = new RoutingTable();

        for(int i = 0; i < tableSize; i++) {
            int nodeID = dataInputStream.readInt();
            byte length = dataInputStream.readByte();
            byte[] ip = new byte[length];
            dataInputStream.readFully(ip);
            int portNum = dataInputStream.readInt();

            routingEntry = new RoutingEntry(nodeID, length, ip, portNum);
            routingTable.add(routingEntry);

        }

        numOfNodes = dataInputStream.readByte();
        nodes = new int[numOfNodes];

        for(int j = 0; j < numOfNodes; j++) {
            nodes[j] = dataInputStream.readInt();
        }

        byteArrayInputStream.close();
        dataInputStream.close();
    }

    @Override
    public byte[] getBytes() throws IOException {
        byte[] marshaledByes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeByte(messageType);
        dataOutputStream.writeByte(tableSize);

        for(int i = 0; i < tableSize; i++) {

            RoutingEntry tempEntry = routingTable.getEntry(i);
            dataOutputStream.writeInt(tempEntry.getNodeID());
            dataOutputStream.writeByte(tempEntry.getLength());
            dataOutputStream.write(tempEntry.getIp());
            dataOutputStream.writeInt(tempEntry.getPortNum());

        }

        dataOutputStream.writeByte(numOfNodes);
        for(int j = 0; j < numOfNodes; j++) {
            dataOutputStream.writeInt(nodes[j]);
        }

        dataOutputStream.flush();

        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public byte getType() { return this.messageType; }

}
