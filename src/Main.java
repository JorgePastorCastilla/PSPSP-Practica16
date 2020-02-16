import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        System.out.println("Quants clients vols acceptar com a màxim?");
        Scanner sc = new Scanner(System.in);
        final int MAX_CLIENTS = sc.nextInt();
        Semaphore semaforo = new Semaphore(1);

        Servidor servidor = new Servidor(MAX_CLIENTS);
        servidor.start();
        Cliente cliente = new Cliente( semaforo );
        for(int i = 0; i< MAX_CLIENTS;i++){
            cliente.run();
        }
    }

}
