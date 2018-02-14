package overlay.wireformats;

import java.io.IOException;

public class OverlayNodeReportsTaskFinished implements Event{

    final static byte messageType = 10;

    @Override
    public byte[] getBytes() throws IOException{
        return null;
    }

    @Override
    public byte getType() { return this.messageType; }
}
