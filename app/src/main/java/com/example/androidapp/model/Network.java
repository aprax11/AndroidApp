package com.example.androidapp.model;

import android.os.AsyncTask;

import com.example.androidapp.network.Connection;

import java.io.IOException;

public class Network extends AsyncTask<String, Void, String> {



    @Override
    protected String doInBackground(String... strings) {
        try {
            String res = Connection.startRequest(strings[1], strings[0]);

            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
