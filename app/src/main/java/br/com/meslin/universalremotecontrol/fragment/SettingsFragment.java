package br.com.meslin.universalremotecontrol.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import br.com.meslin.universalremotecontrol.network.HTTPConnection;
import br.com.meslin.universalremotecontrol.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {
    private static final String prefFile = "IRControl";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        if(serverIpAddress != null) HTTPConnection.serverIpAddress = serverIpAddress;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        EditText fieldServerIpAddress = ((EditText)view.findViewById(R.id.server_ip_address));
        if(HTTPConnection.serverIpAddress != null) fieldServerIpAddress.setText(HTTPConnection.serverIpAddress);
        fieldServerIpAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                HTTPConnection.serverIpAddress = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // Salva o endereço IP do servidor
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(prefFile, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("serverIpAddress", HTTPConnection.serverIpAddress);
                editor.apply();
//                Toast.makeText(getActivity(), "Sav=" + HTTPConnection.serverIpAddress, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}