package com.example.androidapp.model;

import java.util.concurrent.ExecutionException;

public class AsyncTaskWrapper {
    public Network network;

    public AsyncTaskWrapper(){
        network = new Network();
    }
    public String startAsyncTask(String string1, String string2) throws ExecutionException, InterruptedException {
        String ret = network.execute(string1, string2).get();

        return ret;
    }
}
