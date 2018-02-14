package overlay.wireformats;

import java.io.*;

public class OverlayNodeReportsTaskFinished implements Event{

    final static byte messageType = 10;
    private byte length;
    private byte[] ip;
    private int portNum;
    private int nodeID;

    public OverlayNodeReportsTaskFinished (byte[] marshaledBytes) throws IOException{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        byte type = dataInputStream.readByte();
        length = dataInputStream.readByte();
        ip = new byte[length];
        dataInputStream.readFully(ip);
        portNum = dataInputStream.readInt();
        nodeID = dataInputStream.readInt();

        byteArrayInputStream.close();
        dataInputStream.close();
    }
    @Override
    public byte[] getBytes() throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeByte(messageType);
        dataOutputStream.writeByte(length);
        dataOutputStream.write(ip);
        dataOutputStream.writeInt(portNum);
        dataOutputStream.writeInt(nodeID);

        dataOutputStream.flush();
        
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public byte getType() { return this.messageType; }
}
