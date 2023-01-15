package com.example.androidapp.model;

import java.util.concurrent.ExecutionException;

public class AsyncTaskWrapper implements IAsyncTaskWrapper {
    private Network network;

    public AsyncTaskWrapper(){
        network = new Network();
    }
    @Override
    public String startAsyncTask(String string1, String string2) throws ExecutionException, InterruptedException {
        String ret = network.execute(string1, string2).get();

        return ret;
    }

    @Override
    public Network getNetwork() {
        return network;
    }

    @Override
    public void setNetwork(Network network) {
        this.network = network;
    }
}
