package proccessAndThread.executor.future;

import java.util.concurrent.*;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * 올바르지 않는 future 사용 클래스
 * 2초가 아닌 4초가 걸린다.
 * 
 **/


public class SumTaskMainV2_Bad {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumTask a = new SumTask(1, 50);
        SumTask b = new SumTask(51, 100);

        ExecutorService es = Executors.newFixedThreadPool(5);

        Future<Integer> future1 = es.submit(a);
        Integer result1 = future1.get();
        Future<Integer> future2 = es.submit(b);
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
