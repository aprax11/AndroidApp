package com.example.androidapp.network;

import java.io.IOException;

public interface IConnection {
    String startRequest(String urlString, String urlEncoded) throws IOException;
}
