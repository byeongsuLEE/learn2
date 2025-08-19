package proccessAndThread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-20
 * AtomicInteger 가 제공하는 incrementAndGet() 코드도 앞서 우리가 직접 작성한 incrementAndGet()
 * 코드와 똑같이 CAS를 활용하도록 작성되어 있다. CAS를 사용하면 락을 사용하지 않지만, 대신에 다른 스레드가 값을
 * 먼저 증가해서 문제가 발생하는 경우 루프를 돌며 재시도를 하는 방식을 사용한다.
 * 이 방식은 다음과 같이 동작한다
 * 1. 현재 변수의 값을 읽어온다.
 * 2. 변수의 값을 1 증가시킬 때, 원래 값이 같은지 확인한다. (CAS 연산 사용)
 * 3. 동일하다면 증가된 값을 변수에 저장하고 종료한다.
 * 4. 동일하지 않다면 다른 스레드가 값을 중간에 변경한 것이므로, 다시 처음으로 돌아가 위 과정을 반복한다
 **/


public class CasMain {
    private static final int THREAD_COUNT = 2;
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println("start value = " + atomicInteger.get());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                incrementAndGet(atomicInteger);
            }
        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        int result = atomicInteger.get();
        System.out.println(atomicInteger.getClass().getSimpleName() + " resultValue: " + result);
    }
    private static int incrementAndGet(AtomicInteger atomicInteger) {
        int getValue;
        boolean result;
        do {
            getValue = atomicInteger.get();
            sleep(100); // 스레드 동시 실행을 위한 대기
            log("getValue: " + getValue);
            result = atomicInteger.compareAndSet(getValue, getValue + 1);
            log("result: " + result);
        } while (!result);
        return getValue + 1;
    }
}

