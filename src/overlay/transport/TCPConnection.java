package overlay.transport;

import java.io.IOException;
import java.net.Socket;

public class TCPConnection extends Thread{

    TCPReceiver tcpReceiver;
    TCPSender tcpSender;

    public TCPConnection(Socket socket) throws IOException {
        this.tcpReceiver = new TCPReceiver(socket);
        this.tcpSender = new TCPSender(socket);
    }

    @Override
    public void run() {

    }
}
