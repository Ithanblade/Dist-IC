package ejemplo4;

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
        synchronized (lock){
        System.out.println("Hilo "+idHilo+" está imprimiendo su conjunto de números: ");

        for (int i = 0; i < 5; i++) {
                System.out.println("Hilo "+idHilo+" número:  "+i);
            }

        System.out.println("Hilo "+idHilo+" ha terminado");
        System.out.println();
        }
    }
}