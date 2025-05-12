package Evaluacion;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class ClienteGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Consulta Estudiante");
        JTextField idField = new JTextField(10);
        JButton buscarButton = new JButton("Buscar");
        JTextArea resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idField.getText();
                try {
                    DatagramSocket socket = new DatagramSocket();
                    InetAddress servidor = InetAddress.getByName("172.31.115.151");
                    DatagramPacket paqueteEnvio = new DatagramPacket(idText.getBytes(), idText.length(), servidor,5000);
                    socket.send(paqueteEnvio);

                    byte[] buffer = new byte[1024];
                    DatagramPacket paqueteRespuesta = new DatagramPacket(buffer, buffer.length);
                    socket.receive(paqueteRespuesta);

                    String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());
                    resultadoArea.setText(respuesta);
                    socket.close();
                } catch (Exception ex) {
                    resultadoArea.setText("Error al conectar con el servidor.");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("ID Estudiante:"));
        panel.add(idField);
        panel.add(buscarButton);
        panel.add(new JScrollPane(resultadoArea));

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}