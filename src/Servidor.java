import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    public void run(){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(55054,3);
            while(true){
                Socket socket = serverSocket.accept();
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String line = reader.readLine();
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println("This is a message sent to the server");
                socket.close();
                serverSocket.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
