/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resuelto;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author jaumecampsfornari
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(); // Inicializamos socket cliente
            InetSocketAddress direccion = new InetSocketAddress(5555); // inicializacion de dirreción donde el socket será abierto
            socket.connect(direccion); // Se abre el socket a la dirrección especificada en la anterior linea
            System.out.println("Connexió iniciada");

            DataInputStream entrada = new DataInputStream(socket.getInputStream()); // Se inicializa la entrada de informacion del cliente
            DataOutputStream sortida = new DataOutputStream(socket.getOutputStream()); // se inicializa la salida de informacion del cliente
            
            System.out.println("Introdueixi el missatge que voleu enviar:");
            Scanner sc = new Scanner(System.in); // Escaner el cual permite personalizar el texto enviado al servidor
            
            sortida.writeUTF(sc.nextLine()); // se envia lo que se escribe al servidor
            
            
            System.out.println("Resposta del servidor: " + entrada.readUTF());
            // Cierre de objetos socket, InputStream y OutputStream.
            entrada.close();
            sortida.close();
            socket.close();
            System.out.println("Connexió finalitzada");


        } catch (IOException e) {
                e.printStackTrace();
        }
    }
    
}
