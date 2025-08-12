package proccessAndThread.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-12
 *
 **/


public class MyPrinterV2 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "printer");
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while (true){
            log(" 프린터할 문서를  입력하시오 종료(q)");
            String input = scanner.nextLine();
            if(input.equals("q")){
                thread.interrupt();
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

            while(!Thread.interrupted()){
                if(jobQueue.isEmpty()){
                    continue;
                }

                String job = jobQueue.poll();
                log("출력 시작 : " + job + ", 대기 문서: " + jobQueue);
                try {
                    Thread.sleep(3000);
                    log("출력 완료");
                } catch (InterruptedException e) {
                    break;
                }

            }
            log("프린터 종료");


        }

        public void addJob(String input){
            jobQueue.add(input);
        }
    }
}
