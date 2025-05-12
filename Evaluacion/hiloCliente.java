package Evaluacion;

import java.net.*;

public class hiloCliente implements Runnable {
    private DatagramSocket socket;
    private DatagramPacket paqueteRecibido;
    private int idEstudiante;

    public hiloCliente(DatagramSocket socket, DatagramPacket paqueteRecibido, int idEstudiante) {
        this.socket = socket;
        this.paqueteRecibido = paqueteRecibido;
        this.idEstudiante = idEstudiante;
    }

    @Override
    public void run() {
        try {
            Estudiante estudianteEncontrado = buscarEstudiantePorId(idEstudiante);

            String respuesta;
            if (estudianteEncontrado != null) {
                respuesta = estudianteEncontrado.toString();
            } else {
                respuesta = "Estudiante no encontrado";
            }

            byte[] mensajeRespuesta = respuesta.getBytes();
            DatagramPacket paqueteRespuesta = new DatagramPacket(mensajeRespuesta, mensajeRespuesta.length,
                    paqueteRecibido.getAddress(), paqueteRecibido.getPort());
            socket.send(paqueteRespuesta);

            System.out.println("Respuesta enviada al cliente: " + respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Estudiante buscarEstudiantePorId(int id) {
        for (Estudiante estudiante : Servidor.estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null; 
    }
}

