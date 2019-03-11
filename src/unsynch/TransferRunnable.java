package unsynch;

public class TransferRunnable implements Runnable {
    private Bank bank;
    private int fromAccount;
    private double maxAmount;
    private int DELAY = 10;

    public TransferRunnable (Bank bank, int from, double max) {
        this.bank = bank;
        fromAccount = from;
        maxAmount = max;
    }

    public void run () {
        try {
            while(true) {
                int toAccount = (int)(bank.size() * Math.random());
                double account = maxAmount * Math.random() * 2;
                bank.transfer(fromAccount, toAccount, account);
                Thread.sleep((int) (DELAY * Math.random()));
            }
        } catch (InterruptedException e) {

        }
    }
}
