package proccessAndThread.sync;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-14
 * synchronized 의 한 스레드만 실행하는 단점을 최소하고자 synchronized 블럭을 사용한다.
 **/


public class BankAccountImplV3 implements BankAccount {

    private int balance;

    public BankAccountImplV3(int balance) {
        this.balance = balance;
    }

    @Override
    public  boolean withdraw(int amount) {



        synchronized (this) {
            //임계 영역 시작
            log("[출금 검증 시작 계좌 잔액 : " + getBalance() + " 출금 액 : " + amount);

            if (balance < amount) {
                log("[출금 검증 실패 계좌 잔액 : " + getBalance() + " 출금 액 : " + amount);
                return false;
            }

            log("[검증 성공 계좌 잔액 : " + getBalance() + " 출금 액 : " + amount);
            sleep(1000);
            balance -= amount;
            log("[출금 완료 출금 액 : " + getBalance());
            //임계 영역 종료
        }
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
