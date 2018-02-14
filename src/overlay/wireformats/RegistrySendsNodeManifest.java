package overlay.wireformats;

public class RegistrySendsNodeManifest implements Event{

    final static byte messageType = 6;

    @Override
    public byte[] getBytes() { return new byte[0]; }

    @Override
    public byte getType() { return this.messageType; }

}
