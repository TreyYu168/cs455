package overlay.wireformats;

public class OverlayNodeSendsDeregistration implements Event{

    final static byte messageType = 4;

    @Override
    public byte[] getBytes() { return new byte[0];}

    @Override
    public byte getType() {
        return this.messageType;
    }
}
