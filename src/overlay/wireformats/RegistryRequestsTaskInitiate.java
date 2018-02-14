package overlay.wireformats;

import java.io.*;

public class RegistryRequestsTaskInitiate implements Event{

    final static byte messageType = 8;
    private int numOfPackets;

    public RegistryRequestsTaskInitiate(byte[] marshaledBytes) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        byte type = dataInputStream.readByte();
        this.numOfPackets = dataInputStream.readInt();

        byteArrayInputStream.close();
        dataInputStream.close();

    }

    @Override
    public byte[] getBytes() throws IOException {
        byte[] marshaledBytes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeByte(messageType);
        dataOutputStream.writeInt(numOfPackets);

        dataOutputStream.flush();
        marshaledBytes = byteArrayOutputStream.toByteArray();

        dataOutputStream.close();
        byteArrayOutputStream.close();
        return marshaledBytes;
    }

    @Override
    public byte getType() { return this.messageType; }

}
