package Evaluacion;
import java.net.*;
import java.util.ArrayList;


public class Servidor {
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();

    private static void inicializarEstudiantes() {
        estudiantes.add(new Estudiante(1, "Juan Pérez", "0960114520", "Ingeniería", 3, true));
        estudiantes.add(new Estudiante(2, "Ana Gómez", "0965833215", "Medicina", 5, false));
        estudiantes.add(new Estudiante(3, "Carlos López", "0975486321", "Derecho", 2, true));
        estudiantes.add(new Estudiante(4, "Laura Martínez", "0960210045", "Arquitectura", 6, true));
        estudiantes.add(new Estudiante(5, "Pedro Sánchez", "0963258741", "Computación", 1, false));
        estudiantes.add(new Estudiante(6, "Marta Rodríguez", "0963254871", "Psicología", 4, false));
        estudiantes.add(new Estudiante(7, "Luis García", "0214532145", "Matemáticas", 3, true));
        estudiantes.add(new Estudiante(8, "Lucía Pérez", "0987564563", "Filosofía", 2, true));
        estudiantes.add(new Estudiante(9, "José Martínez", "0963253698", "Derecho", 5, true));
        estudiantes.add(new Estudiante(10, "Raquel Fernández", "0968521401", "Medicina", 4, false));
    }

    public static void main(String[] args) {
        DatagramSocket socket = null;

        try {

            inicializarEstudiantes();
            socket = new DatagramSocket(5000); 

            System.out.println("Servidor UDP en espera de solicitudes...");

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);

                socket.receive(paqueteRecibido);
                String mensajeRecibido = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
                int idSolicitado = Integer.parseInt(mensajeRecibido.trim());

                new Thread(new hiloCliente(socket, paqueteRecibido, idSolicitado)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
