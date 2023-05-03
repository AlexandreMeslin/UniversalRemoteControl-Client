package br.com.meslin.universalremotecontroludp.network;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class PingTask extends AsyncTask<String, Void, Boolean> {
    private final TextView textPingReceived;
    private final TextView textPingLoss;

    public PingTask(TextView textPingReceived, TextView textPingLoss) {
        this.textPingReceived = textPingReceived;
        this.textPingLoss = textPingLoss;
    }

    @Override
    protected Boolean doInBackground(String... params) {
        String host = params[0];
        int timeout = 5000;
        try {
            InetAddress address = InetAddress.getByName(host);
            return address.isReachable(timeout);
        } catch (UnknownHostException e) {
            Log.e("UniversalRemoteControl", "Unknown Host Exception");
        } catch (IOException e) {
            Log.e("UniversalRemoteControl", "IO Exception");
        }
        return false;
    }

    /**
     * Updates UI with result
     * @param result a boolean value indicating last-operation result
     */
    @Override
    protected void onPostExecute(Boolean result) {
        if(result) {
            textPingReceived.setText(String.valueOf(Integer.parseInt(textPingReceived.getText().toString())+1));
        } else {
            textPingLoss.setText(String.valueOf(Integer.parseInt(textPingLoss.getText().toString())+1));
        }
    }
}
