package com.example.androidapp.model;

import java.util.concurrent.ExecutionException;

public interface IAsyncTaskWrapper {
    String startAsyncTask(String string1, String string2) throws ExecutionException, InterruptedException;

    Network getNetwork();

    void setNetwork(Network network);
}
