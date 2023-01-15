package com.example.androidapp.network;

import java.io.IOException;
import java.io.Serializable;

public interface IConnection extends Serializable {
    String startRequest(String urlString, String urlEncoded) throws IOException;
}
