package proccessAndThread.executor.future;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-25
 * 풀이방법
 **/


public class OldOrderServiceTestMain {
    public static void main(String[] args) throws InterruptedException {
        String orderNo = "Order#1234"; // 예시 주문 번호
        OldOrderService orderService = new OldOrderService();
        orderService.order(orderNo);
    }
}
