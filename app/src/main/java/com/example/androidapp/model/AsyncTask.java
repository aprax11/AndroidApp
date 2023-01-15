package com.example.androidapp.model;

import com.example.androidapp.network.Connection;
import com.example.androidapp.network.IConnection;

import java.io.IOException;
import java.io.Serializable;

public class AsyncTask extends android.os.AsyncTask<String, Void, String> implements Serializable {
    private IConnection connection;

    public AsyncTask(){
        connection = new Connection();
    }
    @Override
    protected String doInBackground(String... strings) {
        try {
            String res = connection.startRequest(strings[0], strings[1]);

            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public IConnection getConnection() {
        return connection;
    }


    public void setConnection(IConnection connection) {
        this.connection = connection;
    }
}
