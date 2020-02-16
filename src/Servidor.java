import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor extends Thread {

    int MAX_CLIENTS ;


    public Servidor(int MAX_CLIENTS){
        this.MAX_CLIENTS = MAX_CLIENTS;
    }

    public void run() {

        try {
            // Se inicializa el socket del servidor
            ServerSocket socketServidor = new ServerSocket();
            // inicializacion de dirreción donde el socketServidor escuchará
            InetSocketAddress direccion = new InetSocketAddress(5555);
            // El socketServidor empieza a escuchar por la direccion de la linea anterior
            socketServidor.bind(direccion);
            System.out.println("Servidor inicialitzat");

            for(int i = 0; i < MAX_CLIENTS; i++) {
                //byte[] mensaje = new byte[25]; // Array que guardará la información enviada desde el cliente

                // Inicialización de un socket cliente que haya hecho una petición al servidor
                Socket socketNou = socketServidor.accept();
                // Se inicializa la entrada de informacion del cliente
                DataInputStream entrada = new DataInputStream(socketNou.getInputStream());
                // se inicializa la salida de informacion del cliente
                DataOutputStream sortida = new DataOutputStream(socketNou.getOutputStream());

                //entrada.read(entrada.readUTF()); // Introduce T0DO lo escrito por el cliente
                System.out.println("El client "+ i +" diu: " + entrada.readUTF());
                // mensaje predefinido que se va a enviar a cada cliente
                String serverMSN = "Ets el client " + i;

                // Envia el mensaje de la linea anterior al cliente
                sortida.writeUTF(serverMSN);

                // Cierre de objetos socket, InputStream y OutputStream dirigidos a los nuevos clientes
                entrada.close();
                sortida.close();
                socketNou.close();
            }
            System.out.println("Servidor aturat.");
            // Cierre del socket servidor
            socketServidor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
