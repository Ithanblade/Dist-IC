package ejemplo3;
public class principal {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {

        hiloSec hiloSec = new hiloSec();
        hiloSec.start();


        //Llamamos al metodo de la clase hiloSec
        hiloSec.metodoImprimir(5,"Principal");

        try {
            hiloSec.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar a los hilos: " + e.getMessage());
        }

        System.out.println("Todos los hilos han terminado");
    }
}