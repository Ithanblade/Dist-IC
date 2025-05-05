import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        try (Socket socket = new Socket("172.31.115.151", 5000)) {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            String mensajeServidor;

            while ((mensajeServidor = entrada.readLine()) != null) {
                System.out.println("Servidor: " + mensajeServidor);
                if (mensajeServidor.startsWith("Fin del quiz")) {
                    break;
                }

                System.out.print("Tu respuesta: ");
                String respuesta = scanner.nextLine();
                salida.println(respuesta);
            }

            socket.close();
            System.out.println("Conexión cerrada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}