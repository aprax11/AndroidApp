package com.example.androidapp.model;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.androidapp.network.Connection;
import com.example.androidapp.network.IConnection;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class AsyncTaskWrapperTest {

    @Test
    public void getSetTest(){
        IAsyncTaskWrapper asyncTaskWrapper = new AsyncTaskWrapper();

        AsyncTask asyncTaskMock = mock(AsyncTask.class);

        asyncTaskWrapper.setNetwork(asyncTaskMock);
        Assert.assertEquals(asyncTaskMock, asyncTaskWrapper.getNetwork());
    }
    @Test
    public void startAsyncTaskTest() throws ExecutionException, InterruptedException, IOException {
        IAsyncTaskWrapper asyncTaskWrapper = new AsyncTaskWrapper();

        AsyncTask asyncTask = new AsyncTask();

        IConnection connectionMock = mock(Connection.class);

        when(connectionMock.startRequest(anyString(),anyString())).thenReturn("test");

        asyncTask.setConnection(connectionMock);

        asyncTaskWrapper.setNetwork(asyncTask);


        String ret = asyncTaskWrapper.startAsyncTask("string1", "string2");
       Assert.assertEquals("test", ret);
    }
}
