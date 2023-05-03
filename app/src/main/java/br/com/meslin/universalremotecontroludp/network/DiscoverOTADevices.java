package br.com.meslin.universalremotecontroludp.network;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.meslin.universalremotecontroludp.R;

public class DiscoverOTADevices {
    private List<String> serviceList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private NsdManager mNsdManager;
    private NsdManager.DiscoveryListener mDiscoveryListener;
    /** Shows OTA device list */
    ListView listView;

    public DiscoverOTADevices(ListView listView) {
        this.listView = listView;
        adapter = new ArrayAdapter<>(listView.getContext(), android.R.layout.simple_list_item_1, serviceList);
        listView.setAdapter(adapter);
    }

    public void startDiscovery(Context context) {
        //Log.e(context.getString(R.string.TAG), "startDiscovery");
        mNsdManager = (NsdManager) context.getSystemService(Context.NSD_SERVICE);

        // Create a discovery listener to handle discovered services
        mDiscoveryListener = new NsdManager.DiscoveryListener() {
            @Override
            public void onDiscoveryStarted(String serviceType) {
                //Log.e(context.getString(R.string.TAG), "onDiscoveryStarted");
                // Discovery started, do any necessary UI updates
                listView.post(() -> {
                    serviceList.clear();
                    adapter.notifyDataSetChanged();
                });
            }

            @Override
            public void onServiceFound(NsdServiceInfo serviceInfo) {
                // Check if the discovered service is an Arduino OTA device
                if (serviceInfo.getServiceName().contains("IRServer")) {
                    listView.post(() -> {
                        serviceList.add(serviceInfo.getServiceName());
                        adapter.notifyDataSetChanged();
                    });
                }
            }

            @Override
            public void onDiscoveryStopped(String serviceType) {
                // Discovery stopped, do any necessary UI updates
                //Log.e(context.getString(R.string.TAG), "onDiscoveryStopped");
            }

            @Override
            public void onServiceLost(NsdServiceInfo serviceInfo) {
                //Log.e(context.getString(R.string.TAG), "onServiceLost");
                listView.post(() -> {
                    serviceList.remove(serviceInfo.getServiceName());
                    adapter.notifyDataSetChanged();
                });
            }

            /**
             * @param serviceType
             * @param errorCode
             */
            @Override
            public void onStartDiscoveryFailed(String serviceType, int errorCode) {
                Toast.makeText(context, "Start discovery failed:" + errorCode, Toast.LENGTH_LONG).show();
                /*
                Log.e(context.getString(R.string.TAG), "onStartDiscoveryFailed: " + errorCode);
                switch (errorCode) {
                    case NsdManager.FAILURE_INTERNAL_ERROR: // 0
                        Log.e(context.getString(R.string.TAG), "onStartDiscoveryFailed: internal error");
                        break;
                    case NsdManager.NSD_STATE_DISABLED: // 1
                        Log.e(context.getString(R.string.TAG), "onStartDiscoveryFailed: state disabled");
                        break;
                    case NsdManager.NSD_STATE_ENABLED:  // 2
                        Log.e(context.getString(R.string.TAG), "onStartDiscoveryFailed: state enabled");
                        break;
                    case NsdManager.FAILURE_ALREADY_ACTIVE: // 3
                        Log.e(context.getString(R.string.TAG), "onStartDiscoveryFailed: already active");
                        break;
                    case NsdManager.FAILURE_MAX_LIMIT:  // 4
                        Log.e(context.getString(R.string.TAG), "onStartDiscoveryFailed: max limit");
                        break;
                    default:
                        Log.e(context.getString(R.string.TAG), "onStartDiscoveryFailed: unknown");
                        break;
                }
                */
            }

            /**
             * @param s
             * @param i
             */
            @Override
            public void onStopDiscoveryFailed(String s, int i) {
                //Log.e(context.getString(R.string.TAG), "onStopDiscoveryFailed");
            }
        };

        // Start the discovery process for the Arduino OTA service type
//        mNsdManager.discoverServices("_arduino._tcp", NsdManager.PROTOCOL_DNS_SD, mDiscoveryListener);
        mNsdManager.discoverServices("_arduino._tcp", NsdManager.PROTOCOL_DNS_SD, mDiscoveryListener);
    }

    public void stopDiscovery() {
        //Log.e("UniversalRemoteControl", "stopDiscovery");
        if (mNsdManager != null && mDiscoveryListener != null) {
            mNsdManager.stopServiceDiscovery(mDiscoveryListener);
        }
        mDiscoveryListener = null;
    }
}
