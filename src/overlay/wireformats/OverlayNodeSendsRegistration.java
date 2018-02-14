package overlay.wireformats;

import java.io.*;

public class OverlayNodeSendsRegistration implements Event {

    final static byte messageType = 2;
    private byte length;
    private byte[] ip;
    private int port;

    public OverlayNodeSendsRegistration(byte[] marshaledBytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(byteArrayInputStream));

        byte type = dataInputStream.readByte();
        this.length = dataInputStream.readByte();

        this.ip = new byte[length];
        dataInputStream.readFully(ip);

        this.port = dataInputStream.readInt();

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

        dataOutputStream.flush();
        marshaledBytes = byteArrayOutputStream.toByteArray();

        byteArrayOutputStream.close();
        dataOutputStream.close();
        return marshaledBytes;
    }

    @Override
    public byte getType() { return this.messageType; }
}
