package proccessAndThread;

public class HellowRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run() ");

    }
}
