package proccessAndThread.executor.future;

import java.util.concurrent.*;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * 올바른 future 사용 클래스
 * - future은 요청들을 던져서 나중에 get()호출 시 병렬로 스레드를 실행할 수 있다.
 **/


public class SumTaskMainV2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumTask a = new SumTask(1, 50);
        SumTask b = new SumTask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(5);

        Future<Integer> future1 = es.submit(a);
        Future<Integer> future2 = es.submit(b);


        Integer result1 = future1.get();
        Integer result2 = future2.get();
        log("task A result = "  + result1);
        log("task A result = "  + result2);

        log("최종값 = " + (result1+result2));
    }

    static class SumTask implements Callable<Integer> {

        int startValue;
        int endValue;

        public  SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() throws Exception {

            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            log("작업 완료");
            return sum;
        }
    }


}
