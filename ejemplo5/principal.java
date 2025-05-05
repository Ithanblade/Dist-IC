package ejemplo5;
public class principal {

    public static void main(String[] args) {

      for (int i = 1; i < 4; i++) {
            hilo h = new hilo(i);
            h.start(); 
        }

}
}