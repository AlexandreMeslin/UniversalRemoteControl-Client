package br.com.meslin.universalremotecontrol.network;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPConnection {
    public static String serverIpAddress;

    /**
     *
     * @param url a URL object containing protocol, server address and directories
     * @return the string returned by web server
     * @throws IOException
     */
    public static String makeHttpGetRequest(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } finally {
            urlConnection.disconnect();
        }
    }
}
