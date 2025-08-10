package proccessAndThread;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-10
 * 풀이방법
 **/


public class BadThreadMain {
    public static void main(String[] args) {
        HellowThread hellowThread = new HellowThread();
        System.out.println(Thread. currentThread().getName() + "main() start");
        System.out.println(Thread.currentThread().getName() + "start () 호출 전 ");

        hellowThread.run(); // start가 아닌 run을 실행하면 thread가 만들어지는 게 아닌 main 스레드에서 함수가 실행되는 것과 같아진다.
        //따라서 run -> start로 실행해야 별도의 스레드가 만들어지면서 실행됨


        System.out.println(Thread.currentThread().getName() + "start () 호출 후 ");
        System.out.println(Thread.currentThread().getName() + "main() end");
    }
}
