package ejemplo1;

public class hiloA extends Thread {
    
    @Override
    public void run() {
        for (int i=0; i<5; i++) {
            System.out.println("Hilo A: A" + i);

        }
    }
}
