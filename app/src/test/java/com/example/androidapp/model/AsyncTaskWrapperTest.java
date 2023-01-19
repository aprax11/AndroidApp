package com.example.androidapp.model;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.example.androidapp.network.Connection;
import com.example.androidapp.network.IConnection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.ExecutionException;
@RunWith(JUnit4.class)
public class AsyncTaskWrapperTest {

    @Test
    public void getSetTest(){
        IAsyncTaskWrapper asyncTaskWrapper = new AsyncTaskWrapper();

        AsyncTask asyncTaskMock = new AsyncTask();

        asyncTaskWrapper.setAsyncTask(asyncTaskMock);
        Assert.assertEquals(asyncTaskMock, asyncTaskWrapper.getAsyncTask());
    }
    @Test
    public void startAsyncTaskTest() throws ExecutionException, InterruptedException {
        IAsyncTaskWrapper asyncTaskWrapper = new AsyncTaskWrapper();

        AsyncTask asyncTask = new AsyncTask();
        IConnection testConnection = new Connection("testScenario");

        asyncTask.setConnection(testConnection);
        asyncTaskWrapper.setAsyncTask(asyncTask);

        String ret = asyncTaskWrapper.startAsyncTask("String1", "String2");

        Assert.assertEquals("test", ret);
    }
}
