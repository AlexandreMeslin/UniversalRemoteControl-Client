package br.com.meslin.universalremotecontroludp.fragment;

import android.content.Context;
import android.content.SharedPreferences;
//import android.net.wifi.WifiManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import br.com.meslin.universalremotecontroludp.Constants;
import br.com.meslin.universalremotecontroludp.network.DiscoverOTADevices;
import br.com.meslin.universalremotecontroludp.R;
import br.com.meslin.universalremotecontroludp.network.PingTask;
import br.com.meslin.universalremotecontroludp.network.UDPSenderTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * Adding an event to a button:
 * 1) create the button
 * 2) on on onCreateView(), add a event listener
 * view.findViewById(R.id.btn_ping).setOnClickListener(this::pingHander);
 * 3) create the listener
 */
public class SettingsFragment extends Fragment {
    /** Server IP address - IP only - no protocol */
    public static String serverIpAddress;
    public static int serverUDPPort = 80;
    private static final String prefFile = "IRControl";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    /** Ip server address, probabily from TextView */
    private EditText fieldServerIpAddress;
    /** Number of pings sent */
    private TextView textPingSent;
    /** Number of pings received */
    private TextView textPingReceived;
    /** Number of pings loss */
    private TextView textPingLoss;
    /** Shows OTA device list */
    ListView otaListView;
    private DiscoverOTADevices discoverOTADevices;
//    private WifiManager.MulticastLock multicastLock;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // recupera e configura o endereço IP do servidor
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(prefFile, Context.MODE_PRIVATE);
        String serverIpAddress = sharedPreferences.getString("serverIpAddress", null);
        if(serverIpAddress != null) SettingsFragment.serverIpAddress = serverIpAddress;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Log.e("UniversalRemoteControl", "onCreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Listeners
        view.findViewById(R.id.btn_ping).setOnClickListener(this::pingHander);
        view.findViewById(R.id.btn_ota_discovery).setOnClickListener(this::otaDiscoveryHandler);
        view.findViewById(R.id.btn_blink).setOnClickListener(this::blinkHandler);

        // Properties
        fieldServerIpAddress = (EditText) view.findViewById(R.id.server_ip_address);
        textPingSent = (TextView) view.findViewById(R.id.ping_sent);
        textPingReceived = (TextView) view.findViewById(R.id.ping_received);
        textPingLoss = (TextView) view.findViewById(R.id.ping_loss);
        otaListView = (ListView) view.findViewById(R.id.ota_list_view);

        // Shows server IP address if already set
        if(SettingsFragment.serverIpAddress != null) fieldServerIpAddress.setText(SettingsFragment.serverIpAddress);

        // Save server IP address, if any
        // By the way, the server IP address is retrieved at SettingsFragment.onCreate method
        fieldServerIpAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                SettingsFragment.serverIpAddress = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Persist server IP address
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(prefFile, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("serverIpAddress", SettingsFragment.serverIpAddress);
                editor.apply();
            }
        });

        otaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Set server IP address from ota server list
             * @param adapterView The AdapterView where the click happened.
             * @param view The view within the AdapterView that was clicked (this will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             * @param id The row id of the item that was clicked.
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String text = (String) adapterView.getItemAtPosition(position);
                //Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
                if(text.contains("-")) {
                    String ip = text.substring(text.indexOf("-")+1);
                    fieldServerIpAddress.setText(ip);
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Log.e("UniversalRemoteControl", "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Log.e("UniversalRemoteControl", "onDestroyView");
    }

    /**
     * Called when the fragment is no longer visible to the user
     */
    @Override
    public void onStop() {
        super.onStop();
        //Log.e("UniversalRemoteControl", "onStop");
    }

    /**
     * Called when the fragment is no longer in the foreground
     */
    @Override
    public void onPause() {
        super.onPause();
        //Log.e("UniversalRemoteControl", "onPause");
        if(discoverOTADevices != null) discoverOTADevices.stopDiscovery();
        //multicastLock.release(); // release after browsing
    }

    /**
     * Pings the server configured in the EditText field
     * @param view a view
     */
    private void pingHander(View view) {
        // Inicialize ping counters
        textPingSent.setText("0");
        textPingReceived.setText("0");
        textPingLoss.setText("0");
        // Ping
        String host = fieldServerIpAddress.getText().toString();
        for(int i=0; i<4; i++) {
            textPingSent.setText(String.valueOf(Integer.parseInt(textPingSent.getText().toString())+1));
            new PingTask(textPingReceived, textPingLoss).execute(host);
        }
    }

    /**
     * Discovers and lists OTA devices
     * @param view a view
     */
    private void otaDiscoveryHandler(View view) {
        //Log.e(getString(R.string.TAG), "otaDiscoveryHandler");
        /*
        WifiManager wifi = (WifiManager) getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        multicastLock = wifi.createMulticastLock("multicastLock");
        multicastLock.setReferenceCounted(true);
        multicastLock.acquire();
         */
        discoverOTADevices = new DiscoverOTADevices(otaListView);
        discoverOTADevices.startDiscovery(getActivity());
        //Toast.makeText(getActivity(), "otaDiscoveryHandler", Toast.LENGTH_LONG).show();
    }

    /**
     * Blinks IR remote control server
     * @param view the view object
     */
    private void blinkHandler(View view) {
        // 00 = Blink
        String message = Constants.SETTINGS + ",00";
        new UDPSenderTask(message, getActivity()).execute();
    }
}