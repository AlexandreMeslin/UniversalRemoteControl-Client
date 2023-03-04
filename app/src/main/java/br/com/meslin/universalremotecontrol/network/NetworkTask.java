package br.com.meslin.universalremotecontrol.network;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.meslin.universalremotecontrol.network.HTTPConnection;

public class NetworkTask extends AsyncTask<String, Void, String> {
    private Context thisContext;
    Exception exception;
    public NetworkTask(Context context) {
        exception = null;
        thisContext = context;
    }
    /**
     * @param serverURLs
     * @deprecated
     */
    @Override
    protected String doInBackground(String... serverURLs) {
        URL url;
        try {
            url = new URL(serverURLs[0]);
        } catch (MalformedURLException e) {
            exception = e;
            return null;
        }
        try {
            return HTTPConnection.makeHttpGetRequest(url);
        } catch (IOException e) {
            exception = e;
            return null;
        }
//        return null;
    }

    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(exception != null) Toast.makeText(thisContext, "Ex:" + exception.getMessage(), Toast.LENGTH_SHORT).show();
//        if(result != null) Toast.makeText(thisContext, result, Toast.LENGTH_SHORT).show();
    }
}
