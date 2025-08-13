package proccessAndThread.sync;

import static logger.MyLogger.log;
import static proccessAndThread.control.ThreadUtils.sleep;

/**
 * 작성자  : lbs
 * 날짜    : 2025-08-14
 * 동시성 문제 발생시키기
 **/


public class BankAccountImpl implements BankAccount {

    private int balance;

    public BankAccountImpl(int balance) {
        this.balance = balance;
    }

    @Override
    public  synchronized boolean withdraw(int amount) {

        log("[출금 검증 시작 계좌 잔액 : " + getBalance() + " 출금 액 : " + amount  );

        if(balance < amount){
            log("[출금 검증 실패 계좌 잔액 : " + getBalance() + " 출금 액 : " + amount  );
            return false;
        }

        log("[검증 성공 계좌 잔액 : " + getBalance() + " 출금 액 : " + amount  );
        sleep(1000);
        balance -= amount;
        log("[출금 완료 출금 액 : " +  getBalance()  );

        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
