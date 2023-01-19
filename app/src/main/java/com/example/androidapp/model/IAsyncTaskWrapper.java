package com.example.androidapp.model;

import java.util.concurrent.ExecutionException;

public interface IAsyncTaskWrapper {
    /*
    this creates a AsyncTask object, executes it and passes the parameters
    @return String res
     */
    String startAsyncTask(String string1, String string2) throws ExecutionException, InterruptedException;
    /*
    gets AsyncTask object, that receives the calls from the Wrapper
    mainly for testing purposes
    @return IAsyncTask asyncTask
    */
    AsyncTask getAsyncTask();
    /*
    sets AsyncTask object, that receives the calls from the Wrapper
    mainly for testing purposes
    */
    void setAsyncTask(AsyncTask asyncTask);
}
