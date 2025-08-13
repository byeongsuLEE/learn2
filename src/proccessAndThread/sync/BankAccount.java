package proccessAndThread.sync;

public interface BankAccount {
    boolean withdraw(int amount); // 계좌 출급
    int getBalance();
}
