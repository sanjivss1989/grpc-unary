package com.devacademy.client;

import com.devacademy.models.Balance;
import com.devacademy.models.BalanceCheckRequest;
import com.devacademy.models.BankServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankClientTest {
    BankServiceGrpc.BankServiceBlockingStub blockingStub;

    @BeforeAll
    public void setup(){
        ManagedChannel managedChannel=ManagedChannelBuilder.forAddress("localhost",9000).usePlaintext().build();
         this.blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);

    }

    @Test
    public void balanceTest(){
        BalanceCheckRequest request = BalanceCheckRequest.newBuilder().setAccountNumber(12).build();
        Balance balance = this.blockingStub.getBalance(request);
        System.out.println("Received Balance ===> "+balance);
    }
}
