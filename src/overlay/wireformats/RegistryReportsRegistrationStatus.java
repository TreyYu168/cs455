package overlay.wireformats;

import java.io.*;

public class RegistryReportsRegistrationStatus implements Event{

    final static byte messageType = 3;
    private int status;
    private byte length;
    private byte[] info;

    public RegistryReportsRegistrationStatus(byte[] marshaledBytes) throws IOException{
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(marshaledBytes);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

        byte type = dataInputStream.readByte();
        this.status = dataInputStream.readInt();
        this.length = dataInputStream.readByte();

        this.info = new byte[length];
        dataInputStream.readFully(info);

        byteArrayInputStream.close();
        dataInputStream.close();
    }

    @Override
    public byte[] getBytes() throws IOException {
        byte[] marshaledBytes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

        dataOutputStream.writeByte(messageType);
        dataOutputStream.write(status);
        dataOutputStream.writeByte(length);
        dataOutputStream.write(info);

        dataOutputStream.flush();
        marshaledBytes = byteArrayOutputStream.toByteArray();

        byteArrayOutputStream.close();
        dataOutputStream.close();
        return marshaledBytes;
    }

    @Override
    public byte getType() { return this.messageType; }
}
