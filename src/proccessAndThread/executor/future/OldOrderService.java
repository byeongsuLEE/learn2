package proccessAndThread.executor.future;

import java.util.List;
import java.util.concurrent.*;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * 풀이방법
 **/


public class OldOrderService {

    public void order(String orderNo) throws InterruptedException {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);
        // 작업 요청
//        Boolean inventoryResult = inventoryWork.call();
//        Boolean shippingResult = shippingWork.call();
//        Boolean accountingResult = accountingWork.call();

        List<Callable<Boolean>> tasks = List.of(inventoryWork, shippingWork, shippingWork);

        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Future<Boolean>> futures = es.invokeAll(tasks);
        for (Future<Boolean> future : futures) {
            try {
                future.get();
                log("모든 주문 처리가 성공적으로 완료되었습니다.");

            } catch (ExecutionException e) {
                log("일부 작업이 실패했습니다.");

                throw new RuntimeException(e);
            }
        }


        // 결과 확인
//        if (inventoryResult && shippingResult && accountingResult) {
//        } else {
//        }
    }

    static class InventoryWork implements Callable<Boolean> {

        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class ShippingWork implements  Callable<Boolean> {
        private final String orderNo;

        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class AccountingWork implements Callable<Boolean> {
        private final String orderNo;

        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
