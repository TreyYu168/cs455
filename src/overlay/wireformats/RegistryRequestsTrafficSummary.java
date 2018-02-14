package overlay.wireformats;

import java.io.*;

public class RegistryRequestsTrafficSummary implements Event{

    final static byte messageType = 11;

    /*public RegistryRequestsTrafficSummary(byte[] marshaledBytes) throws IOException{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        byte type = dataInputStream.readByte();

        dataInputStream.close();
        byteArrayInputStream.close();
    }*/

    @Override
    public byte[] getBytes() throws IOException {
        byte[] marshaledBytes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeByte(messageType);

        dataOutputStream.flush();
        marshaledBytes = byteArrayOutputStream.toByteArray();

        return marshaledBytes;
    }

    @Override
    public byte getType(){ return this.messageType; }
}
