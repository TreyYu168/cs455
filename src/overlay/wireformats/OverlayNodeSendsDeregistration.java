package overlay.wireformats;

import java.io.*;

public class OverlayNodeSendsDeregistration implements Event{

    final static byte messageType = 4;
    private byte length;
    private byte[] ip;
    private int port;
    private int nodeID;

    public OverlayNodeSendsDeregistration(byte[] marshaledBytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        byte type = dataInputStream.readByte();
        this.length = dataInputStream.readByte();

        this.ip = new byte[length];
        dataInputStream.readFully(ip);

        this.port = dataInputStream.readInt();
        this.nodeID = dataInputStream.readInt();

        byteArrayInputStream.close();
        dataInputStream.close();
    }

    @Override
    public byte[] getBytes() throws IOException {
        byte[] marshaledBytes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeByte(messageType);
        dataOutputStream.writeByte(length);
        dataOutputStream.write(ip);
        dataOutputStream.writeInt(port);
        dataOutputStream.writeInt(nodeID);

        dataOutputStream.flush();
        marshaledBytes = byteArrayOutputStream.toByteArray();

        byteArrayOutputStream.close();
        dataOutputStream.close();

        return marshaledBytes;
    }

    @Override
    public byte getType() {
        return this.messageType;
    }
}
