package com.example.androidapp.network;

import java.io.IOException;

public interface IConnection {
    /*
    takes a address for the HttpURLConnection and a url encoded message String
    opens a connection with the urlString and writes the message via POST request method
    @return String response
     */
    String startRequest(String urlString, String urlEncoded) throws IOException;
}
