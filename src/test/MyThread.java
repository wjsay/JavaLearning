package test;

public class MyThread extends Thread {
    public static void main(String[] args) throws InterruptedException {
//        Thread t = new MyThread();
//        t.start();
//        System.out.println("优先级：" + t.getPriority());
        int[] a = new int[0];
        for (int i : a) {
            System.out.println(i);
        }
    }

    public void run() {
        try {
            this.interrupt();
        } catch (Exception e) {

        }
    }
}
