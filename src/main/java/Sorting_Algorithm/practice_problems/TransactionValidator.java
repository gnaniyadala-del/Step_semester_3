package main.java.Sorting_Algorithm.assignment_problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TransactionValidator {
    public static boolean hasDuplicate(List<String> transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String txn : transactionIds) {
            if (!seen.add(txn)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(List.of("TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"))); // true
        System.out.println(hasDuplicate(List.of("TXN2001", "TXN2002", "TXN2003"))); // false
    }
}
