package it.sevenbits.backend;

import it.sevenbits.backend.account.Account;
import it.sevenbits.backend.account.ThreadExecutor;
import it.sevenbits.backend.list.ListOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(final String[] args) {
        ListOperator operator = new ListOperator();
        int i = 3;
        int j = 1;


        ArrayList<Integer> integers = new ArrayList<>(
            Arrays.asList(49, 30, 30, 29, 13, 17, 56, 0)
        );
        LinkedList<Account> accounts = new LinkedList<>(Arrays.asList(
            new Account(65), new Account(36), new Account(52),
            new Account(80), new Account(45)
        ));


        System.out.printf(
            "Maximal integer: %s\n",
            operator.max(integers, 0, integers.size())
        );
        System.out.printf(
            "Maximal account: {%s}\n",
            operator.max(accounts, 0, accounts.size())
        );


        System.out.printf(
            "Integers before changing %dth and %dth elements: %s\n",
            i, j, integers
        );
        operator.changeElementsPosition(integers, i, j);
        System.out.printf(
            "Integers after changing %dth and %dth elements: %s\n",
            i, j, integers
        );


        System.out.printf(
            "Accounts before changing %dth and %dth elements: %s\n",
            i, j, accounts
        );
        operator.changeElementsPosition(accounts, i, j);
        System.out.printf(
            "Account after changing %dth and %dth elements: %s\n",
            i, j, accounts
        );


        System.out.println("\nThreadExecutor test:");
        try {
            ThreadExecutor executor = new ThreadExecutor();
            executor.showAccountFilling(100);
        } catch (InterruptedException e) {
            System.err.println("One of the threads was interrupted!");
        }
    }
}
