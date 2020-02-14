import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("127.0.0.1",55054);
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("toma socket!!" + e.getMessage() );
        }

    }

}
