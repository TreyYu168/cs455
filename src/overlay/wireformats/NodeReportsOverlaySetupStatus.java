package overlay.wireformats;

public class NodeReportsOverlaySetupStatus implements Event{

    final static byte messageType = 7;

    @Override
    public byte[] getBytes() { return new byte[0]; }

    @Override
    public byte getType() { return this.messageType; }
}
