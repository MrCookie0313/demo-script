package com.example.demoscript.designmode;

/**
 * @Author: sunBing
 * @CreateTime: 2023-03-16  10:06
 * @Description: TODO
 * @Version: 1.0
 */
public class Iphone implements IConnectionManager,IDataTransfer{
    @Override
    public void dial(String phoneNumber) {

    }

    @Override
    public void hangup() {

    }

    @Override
    public void dataTransfer(IConnectionManager connectionManager) {
        connectionManager.hangup();
    }
}
