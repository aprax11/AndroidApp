package com.example.androidapp.model;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

public class AsyncTaskWrapper implements IAsyncTaskWrapper, Serializable {
    private AsyncTask asyncTask;

    public AsyncTaskWrapper(){
        asyncTask = new AsyncTask();
    }
    @Override
    public String startAsyncTask(String string1, String string2) throws ExecutionException, InterruptedException {
        asyncTask = new AsyncTask();
        String ret = asyncTask.execute(string1, string2).get();

        return ret;
    }

    @Override
    public AsyncTask getNetwork() {
        return asyncTask;
    }

    @Override
    public void setNetwork(AsyncTask asyncTask) {
        this.asyncTask = asyncTask;
    }
}
