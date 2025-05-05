import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
    public static void main(String[] args) {
        try {
            ServerSocket socket_servidor = new ServerSocket(3000);
            System.out.println("Servidor esperando conexiones...");

            Socket socket_cliente = socket_servidor.accept();
            System.out.println("Cliente conectado: " + socket_cliente.getInetAddress());

            HiloCliente hilo = new HiloCliente(socket_cliente);
            hilo.start();

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
