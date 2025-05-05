package ejemplo6;

public class hilo extends Thread {

    private static final Object lock = new Object(); // Objeto de bloqueo
    
    private final int idHilo;

    private int turno=0;

    //Constructor para el identificador
    public hilo(int id) {
        this.idHilo = id;
    }
    

    @Override
    public void run() {
        imprimirNumeros();
        turno++;
        }

    public void imprimirNumeros() {     
        synchronized (lock){


        System.out.println("Turno "+ turno + " asignado");
        }

        System.out.println("Cliente "+idHilo+": Recibi el turno "+turno);
    }
}