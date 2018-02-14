package overlay.wireformats;

import java.io.*;

public class OverlayNodeReportsTrafficSummary implements Event{

    final static byte messageType = 12;
    private int nodeID;
    private int sentPackets;
    private int relayedPackets;
    private long sumPacketSent;
    private int totalPacketReceived;
    private long sumPacketReceived;

    public OverlayNodeReportsTrafficSummary(byte[] marshaledBytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        byte type = dataInputStream.readByte();
        this.nodeID = dataInputStream.readInt();
        this.sentPackets = dataInputStream.readInt();
        this.relayedPackets = dataInputStream.readInt();
        this.sumPacketSent = dataInputStream.readLong();
        this.totalPacketReceived = dataInputStream.readInt();
        this.sumPacketReceived = dataInputStream.readLong();

        byteArrayInputStream.close();
        dataInputStream.close();

    }

    @Override
    public byte[] getBytes() throws IOException {
        byte[] marshaledBytes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeByte(messageType);
        dataOutputStream.writeInt(nodeID);
        dataOutputStream.writeInt(sentPackets);
        dataOutputStream.writeInt(relayedPackets);
        dataOutputStream.writeLong(sumPacketSent);
        dataOutputStream.writeInt(totalPacketReceived);
        dataOutputStream.writeLong(sumPacketReceived);

        dataOutputStream.flush();
        marshaledBytes = byteArrayOutputStream.toByteArray();

        return marshaledBytes;
    }

    @Override
    public byte getType() { return this.messageType; }
}
