package proccessAndThread.cas;

import java.util.ArrayList;
import java.util.List;

import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-20
 *  결과값은 1000이 아니다.
 *  원자적이지 않은 value++를 사용했기에 다른 스레드에서 변경된 값이 적용될 수 있다.
 *  발러틸 volatile은 원자적이지 않은 value++를 원자적으로 묶어주는 게 아니다.
 *  물론, 여기서 캐시 메모리 문제가 발생할 수 있지만 원자적인 연산 부분 때문에 결과값이 달라진다.
 *
 **/


public class IncrementMain {
    public static void main(String[] args) throws InterruptedException {

       test(new BasicInteger());
       test(new VolatileInteger());
       test(new SyncInteger());
       test(new CasInteger());
    }

    private static void test  (IncrementInteger incrementInteger) throws InterruptedException {

        Runnable runnable = ()->{
            sleep(10);
            incrementInteger.increment();};

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);

            thread.start();
        }

        for (int i = 0; i < 1000; i++) {
            threads.get(i).join();
        }
        System.out.println("결과 값은 basic value result =  " + incrementInteger.get());

    }
}
