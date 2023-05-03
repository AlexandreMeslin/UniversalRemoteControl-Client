package br.com.meslin.universalremotecontroludp.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import br.com.meslin.universalremotecontroludp.fragment.SettingsFragment;

public class UDPSenderTask extends AsyncTask<Void, Void, Void> {
    @SuppressLint("StaticFieldLeak")
    final private Context context;
    /** Message to be sent via UDP to server */
    String message;
    Exception exception;
    public UDPSenderTask(String message, Context context) {
        this.exception = null;
        this.context = context;
        this.message = message;
    }
    /**
     * @deprecated
     */
    @Override
    protected Void doInBackground(Void... voids) {
        // test if there is an IP address already configured
        if(SettingsFragment.serverIpAddress == null || SettingsFragment.serverIpAddress.length() == 0) return null;
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] messageBytes = message.getBytes();
            DatagramPacket packet = new DatagramPacket(
                    messageBytes,
                    messageBytes.length, InetAddress.getByName(SettingsFragment.serverIpAddress),
                    SettingsFragment.serverUDPPort);
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return null;
    }
}
