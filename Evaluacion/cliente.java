package Evaluacion;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new DatagramSocket();

            InetAddress servidor = InetAddress.getByName("localhost");
            int puertoServidor = 5000;

            System.out.print("Ingrese el ID del estudiante: ");
            int idEstudiante = scanner.nextInt();

            byte[] mensaje = Integer.toString(idEstudiante).getBytes();

            DatagramPacket paqueteEnvio = new DatagramPacket(mensaje, mensaje.length, servidor, puertoServidor);
            socket.send(paqueteEnvio);
            System.out.println("Solicitud enviada al servidor...");

            byte[] bufferRespuesta = new byte[1024];
            DatagramPacket paqueteRespuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socket.receive(paqueteRespuesta);

            String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());
            System.out.println("Respuesta del servidor: " + respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            scanner.close();
        }
    }
}
