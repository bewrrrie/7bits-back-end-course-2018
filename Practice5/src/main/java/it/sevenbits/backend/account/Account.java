package it.sevenbits.backend.account;

import java.util.UUID;

public class Account implements Comparable<Account> {
    private String id;
    private long balance;

    public Account() {
        id = UUID.randomUUID().toString();
        balance = 0;
    }

    public Account(final long balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    public void addToBalance(final long value) throws InterruptedException {
        long balance = this.balance;
        Thread.sleep(1);
        this.balance = balance + value;
    }

    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s", id, balance);
    }

    @Override
    public int compareTo(final Account account) {
        if (this.balance > account.balance) {
            return 1;
        } else if (this.balance < account.balance) {
            return -1;
        }

        return 0;
    }
}