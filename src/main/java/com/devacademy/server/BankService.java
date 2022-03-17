package com.devacademy.server;


import com.devacademy.models.Balance;
import com.devacademy.models.BalanceCheckRequest;
import com.devacademy.models.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {

    private AccountDatabase database;

    @Override
    public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> observer){
        int account = request.getAccountNumber();
        Balance balance = Balance.newBuilder()
                        .setAmount(AccountDatabase.getBalance(account))
                                .build();
        observer.onNext(balance);
        observer.onCompleted();
    }
}
