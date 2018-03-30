public class Main {
    public static void main(String[] args) {
        Draw game = new Draw();
        Thread t1 = new Thread(game);
        t1.start();
    }
}
