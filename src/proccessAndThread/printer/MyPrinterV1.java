package proccessAndThread.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-12
 * 프린터 스레드에 main 입력값에 따라 thread 관리하기
 * 해당 코드의 문제점
 * -> work 값이 false일 때 대기상태로 인해 바로 종료 되지 않는다.
 **/


public class MyPrinterV1 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "printer");
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while (true){
            log(" 프린터할 문서를  입력하시오 종료(q)");
            String input = scanner.nextLine();
            if(input.equals("q")){
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }

    }

    static class Printer implements Runnable {

        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<String>(); // 여러 쓰레드가 같이 있을 댸는 같이 접근하는 Queue

        @Override
        public void run() {

            while(work){
                if(jobQueue.isEmpty()){
                    continue;
                }

                String job = jobQueue.poll();
                log("출력 시작 : " + job + ", 대기 문서: " + jobQueue);
                sleep(3000);
                log("출력 완료");
            }
            log("프린터 종료");
        }

        public void addJob(String input){
            jobQueue.add(input);
        }
    }
}
