package overlay.transport;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerThread implements Runnable{

    ServerSocket serverSocket;

    TCPServerThread(int portNum) throws IOException {
        this.serverSocket = new ServerSocket(portNum);

    }

    @Override
    public void run() {
        while(true) {
            try {
                Socket socket = serverSocket.accept();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }
}
