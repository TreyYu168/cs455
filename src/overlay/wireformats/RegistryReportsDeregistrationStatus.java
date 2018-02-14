package overlay.wireformats;

public class RegistryReportsDeregistrationStatus implements Event{

    final static byte messageType = 5;

    @Override
    public byte[] getBytes() { return new byte[0]; }

    @Override
    public byte getType() { return this.messageType; }
}
