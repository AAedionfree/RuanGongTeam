package org.spring.springboot;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpClient {
    private static URL url;
    private static HttpURLConnection con;

    public static void record(String content) throws Exception{
        url = new URL("http://aaedion.club/exception.php?content=" + content.replace(" ","-"));
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.getResponseCode();
    }
}
