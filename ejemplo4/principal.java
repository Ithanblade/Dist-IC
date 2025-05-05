package ejemplo4;
public class principal {

    public static void main(String[] args) {

      for (int i = 0; i < 11; i++) {
            hilo h = new hilo(i);
            h.start(); 
        }

}
}