package les4;

public class Main {
    static volatile char currentAlpha = 'A';
    static Object lock = new Object();
    static int num = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 0; i < num; i++) {
                        while(currentAlpha != 'A') {
                            lock.wait();
                        }
                        System.out.print(currentAlpha);
                        currentAlpha = 'B';
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 0; i < num; i++) {
                        while(currentAlpha != 'B') {
                            lock.wait();
                        }
                        System.out.print(currentAlpha);
                        currentAlpha = 'C';
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                synchronized (lock) {
                    for (int i = 0; i < num; i++) {
                        while(currentAlpha != 'C') {
                            lock.wait();
                        }
                        System.out.print(currentAlpha);
                        currentAlpha = 'A';
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
