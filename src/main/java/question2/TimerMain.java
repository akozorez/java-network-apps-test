package question2;

public class TimerMain {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer(15);
        timer.start();
        for (int i = 0; i < 10; i++){
            System.out.println(timer.getSeconds());
            Thread.sleep(1000);
        }
    }
}
