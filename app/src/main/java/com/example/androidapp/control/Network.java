package com.example.androidapp.control;

import android.os.AsyncTask;

import com.example.androidapp.model.IChallenge;
import com.example.androidapp.network.Connection;

import java.io.IOException;
import java.util.List;

public class Network extends AsyncTask<String, Void, String> {

    public static Network getNewInstance(){
        return new Network();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            Connection connection = new Connection(strings[0]);
            String res = connection.startRequest(strings[1]);


            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
