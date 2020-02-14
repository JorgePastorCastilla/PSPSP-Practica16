import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Nose {

    public static void main(String[] args) throws IOException {

        Servidor servidor = new Servidor();
        servidor.run();

        Socket socket = new Socket("127.0.0.1",55054);

    }

}
