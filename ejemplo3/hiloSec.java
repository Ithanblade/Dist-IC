package ejemplo3;

public class hiloSec extends Thread {

    @Override
    public void run() {
        metodoImprimir(5,"Secundario");
    }

    //Metodo con una variable
    public synchronized static void metodoImprimir(int valor,String hilo) {
        for (int i = 0; i < valor; i++) {
            System.out.println("Hilo "+hilo+", valor: " + i);
        }
    }
}