package overlay.wireformats;

import java.io.IOException;

public interface Event {

    byte[] getBytes() throws IOException;
    byte getType();


}
