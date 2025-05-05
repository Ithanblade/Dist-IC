package ejemplo1;
public class principal {

    public static void main(String[] args) {

        //Crear los hilos
        hiloA hiloA = new hiloA();
        hiloB hiloB = new hiloB();

        //Iniciar los hilos
        hiloA.start();
        hiloB.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Hilo Principal: P" + i);
        }

        //Esperar a que los hilos terminen antes de terminar el hilo principal
        try {
            hiloA.join();
            hiloB.join();
        } catch (InterruptedException e) {
            System.out.println("Error al esperar a los hilos: " + e.getMessage());
        }

        System.out.println("Hilo Principal Termino");
    }
}