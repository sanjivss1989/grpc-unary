package com.devacademy.server;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AccountDatabase {

    private static final Map<Integer, Integer> DATABASE = IntStream.rangeClosed(1,10)
            .boxed()
            .collect(Collectors.toMap(Function.identity(),
                    v -> v*10));

    public static Integer getBalance(int account){
        return DATABASE.get(account);
    }

    public static Integer deposit(int account, int amount){
        return DATABASE.computeIfPresent(account, (k,v) -> v+amount );
    }

    public static Integer withdraw(int account, int amount){
        return DATABASE.computeIfPresent(account, (k,v) -> v-amount);
    }
}
