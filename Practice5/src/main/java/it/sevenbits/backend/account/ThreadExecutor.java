package it.sevenbits.backend.account;

public class ThreadExecutor {
    public void showAccountFilling(final long millis) throws InterruptedException {
        Account account = new Account();

        Thread[] threads = new Thread[]{
            new Thread(() -> {
                System.out.println("Thread 1 - started!");

                try {
                    while (!Thread.interrupted()) {
                        account.addToBalance(-3);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 was interrupted!");
                }
            }),

            new Thread(() -> {
                System.out.println("Thread 2 - started!");

                try {
                    while (!Thread.interrupted()) {
                        account.addToBalance(2);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread 2 was interrupted!");
                }
            }),

            new Thread(() -> {
                System.out.println("Thread 3 - started!");

                try {
                    while (!Thread.interrupted()) {
                        account.addToBalance(-7);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Thread 3 was interrupted!");
                }
            })
        };

        for (Thread t : threads) {
            t.start();
        }

        Thread.sleep(millis);

        for (Thread t : threads) {
            t.interrupt();
        }

        System.out.println(account);
    }
}
