package ejemplo5;

public class hilo extends Thread {

    private static final Object lock = new Object(); // Objeto de bloqueo
    
    private final int idHilo;

    //Constructor para el identificador
    public hilo(int id) {
        this.idHilo = id;
    }

    @Override
    public void run() {
        imprimirNumeros();
        }

    public void imprimirNumeros() {
            int mb = 0;
            String tipo = "";
            synchronized (lock){

        if (idHilo == 1) {
            tipo="1.zip";
            mb=5;
        
        } else if (idHilo == 2) {
            tipo="2.mp4";
            mb=7;
        } else if (idHilo == 3) {
            tipo="3.pdf";
            mb=3;
        }
        System.out.println("Descargando el archivo" + tipo + " (" + mb + " MB)");
        }

        System.out.println("Descarga completa: archivo " + tipo + " (" + mb + " MB)");
    }
}