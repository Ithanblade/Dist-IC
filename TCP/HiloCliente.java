import java.io.*;
import java.net.Socket;

public class HiloCliente extends Thread {
    private Socket socket;
    private int puntaje = 0;

    public HiloCliente(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);) {
            // Enviar preguntas una por una
            for (int i = 0; i < Preguntas.preguntas.length; i++) {
                // Enviar pregunta al cliente
                salida.println("Pregunta " + (i + 1) + ": " + Preguntas.preguntas[i]);

                // Recibir respuesta del cliente
                String respuestaCliente = entrada.readLine();
                System.out.println("Cliente responde: " + respuestaCliente);

                // Evaluar respuesta y contar si es correcta
                if (respuestaCliente != null && respuestaCliente.trim().equalsIgnoreCase(Preguntas.respuestas[i])) {
                    puntaje++;
                }
            }

            // Enviar el puntaje final al cliente
            salida.println("Fin del quiz. Puntaje obtenido: " + puntaje + "/" + Preguntas.preguntas.length);
            socket.close();
            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}