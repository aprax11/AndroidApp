package com.example.androidapp.model;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import android.annotation.SuppressLint;

import com.example.androidapp.network.Connection;
import com.example.androidapp.network.IConnection;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AsyncTaskTest {

    @Test
    public void getSetTest(){
        AsyncTask asyncTask = new AsyncTask();
        IConnection connectionMock = mock(Connection.class);

        asyncTask.setConnection(connectionMock);

        Assert.assertEquals(connectionMock, asyncTask.getConnection());
    }
    @SuppressLint("CheckResult")
    @Test
    public void executeTest() throws IOException {
        AsyncTask asyncTask = new AsyncTask();
        IConnection connectionMock = mock(Connection.class);
        when(connectionMock.startRequest(anyString(), anyString())).thenReturn("test");
        asyncTask.setConnection(connectionMock);

        asyncTask.doInBackground("string1", "string2");
        verify(connectionMock, timeout(1000)).startRequest("string1", "string2");
    }
}
