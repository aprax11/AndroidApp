package com.example.androidapp.model;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

public interface IAsyncTaskWrapper extends Serializable {
    String startAsyncTask(String string1, String string2) throws ExecutionException, InterruptedException;

    AsyncTask getNetwork();

    void setNetwork(AsyncTask asyncTask);
}
