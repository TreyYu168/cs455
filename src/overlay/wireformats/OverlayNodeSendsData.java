package overlay.wireformats;

import java.io.*;

public class OverlayNodeSendsData implements Event{

    final static byte messageType = 9;
    private int destinationID;
    private int sourceID;
    private int payload;
    private int numOfHops;
    private int[] traveledNodes;

    public OverlayNodeSendsData(byte[] marshaledBytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        byte type = dataInputStream.readByte();
        this.destinationID = dataInputStream.readInt();
        this.sourceID = dataInputStream.readInt();
        this.payload = dataInputStream.readInt();
        this.numOfHops = dataInputStream.readInt();

        this.traveledNodes = new int[numOfHops];
        for (int i = 0; i < numOfHops; i++) {
            traveledNodes[i] = dataInputStream.readInt();
        }

        byteArrayInputStream.close();
        dataInputStream.close();

    }

    @Override
    public byte[] getBytes() throws IOException {
        byte[] marshaledBytes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeByte(messageType);
        dataOutputStream.writeInt(destinationID);
        dataOutputStream.writeInt(sourceID);
        dataOutputStream.writeInt(payload);
        dataOutputStream.writeInt(numOfHops);
        for(int i = 0; i < numOfHops; i++) {
            dataOutputStream.writeInt(traveledNodes[i]);
        }

        dataOutputStream.flush();
        marshaledBytes = byteArrayOutputStream.toByteArray();

        return marshaledBytes;
    }

    @Override
    public byte getType() { return this.messageType; }
}
