package overlay.transport;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

public class TCPReceiver implements Runnable{

    private Socket socket;
    private DataInputStream din;

    public TCPReceiver(Socket socket) throws IOException {
        this.socket = socket;
        din = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        int dataLength;

        while(socket != null) {
            try {
                dataLength = din.readInt();

                byte[] data = new byte[dataLength];
                din.readFully(data, 0, dataLength);

            } catch (SocketException se) {
                System.out.println(se.getMessage());
                break;
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
                break;
            }
        }
    }
}
