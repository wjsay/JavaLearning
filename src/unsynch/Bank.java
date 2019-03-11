package unsynch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private Lock myLock;
    private Condition sufficientFunds;

    public Bank(int n, double initialBalance) {
        myLock = new ReentrantLock();
        sufficientFunds = myLock.newCondition();
        accounts = new double[n];
        for (int i = 0; i <accounts.length; ++i) {
            accounts[i] = initialBalance;
        }
    }

    public synchronized void transfer(int from, int to, double account) throws InterruptedException {
        //myLock.lock();
        //try {
            while (accounts[from] < account) {
            //    sufficientFunds.await();
                wait();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= account;
            System.out.printf(" %10.2f from %d to %d", account, from, to);
            accounts[to] += account;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            //sufficientFunds.signalAll();
            notifyAll();
        //} finally {
            //myLock.unlock();
        //}
    }

    public synchronized double getTotalBalance() {
        double sum = 0;
        for (int i = 0; i < accounts.length; ++i) {
            sum += accounts[i];
        }
        return sum;
    }

    public double size() {
        return accounts.length;
    }
}
