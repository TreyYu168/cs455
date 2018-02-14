package overlay.wireformats;

import java.io.*;

public class RegistryRequestsTrafficSummary implements Event{

    final static byte messageType = 11;

    public RegistryRequestsTrafficSummary(){}

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
