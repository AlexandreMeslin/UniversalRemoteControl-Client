package br.com.meslin.universalremotecontrol.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import br.com.meslin.universalremotecontrol.network.HTTPConnection;
import br.com.meslin.universalremotecontrol.network.NetworkTask;
import br.com.meslin.universalremotecontrol.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /** Mapa de teclas e comandos */
    private Map<Integer, String> comando;

    public NetFragment() {
        // Required empty public constructor
        createMap();
    }

    private void createMap() {
        comando = new HashMap<Integer, String>();

        comando.put(R.id.net_portal, "/netPortal");
        comando.put(R.id.net_on_off, "/netOnOff");

        comando.put(R.id.net_mosaico, "/netMosaico");
        comando.put(R.id.net_info, "/netInfo");

        comando.put(R.id.net_volume_up, "/netVolumeUp");
        comando.put(R.id.net_volume_down, "/netVolumeDown");

        comando.put(R.id.net_mute, "/netMute");
        comando.put(R.id.net_voltar, "/netVoltar");

        comando.put(R.id.net_channel_up, "/netChannelUp");
        comando.put(R.id.net_channel_down, "/netChannelDown");

        comando.put(R.id.net_sair, "/netSair");
        comando.put(R.id.net_net_tv, "/netNetTV");

        comando.put(R.id.net_up, "/netUp");
        comando.put(R.id.net_down, "/netDown");
        comando.put(R.id.net_left, "/netLeft");
        comando.put(R.id.net_right, "/netRight");
        comando.put(R.id.net_ok, "/netOk");

        comando.put(R.id.net_itv, "/netITV");
        comando.put(R.id.net_audio, "/netAudio");
        comando.put(R.id.net_agora, "/netAgora");
        comando.put(R.id.net_legenda, "/netLegenda");
        comando.put(R.id.net_message, "/netMessage");

        comando.put(R.id.net_1, "/net1");
        comando.put(R.id.net_2, "/net2");
        comando.put(R.id.net_3, "/net3");
        comando.put(R.id.net_4, "/net4");
        comando.put(R.id.net_5, "/net5");
        comando.put(R.id.net_6, "/net6");
        comando.put(R.id.net_7, "/net7");
        comando.put(R.id.net_8, "/net8");
        comando.put(R.id.net_9, "/net9");
        comando.put(R.id.net_0, "/net0");

        comando.put(R.id.net_fav, "/netFav");
        comando.put(R.id.net_menu, "/netMenu");

        comando.put(R.id.net_rew, "/netRew");
        comando.put(R.id.net_play, "/netPlay");
        comando.put(R.id.net_fwd, "/netFwd");
        comando.put(R.id.net_replay, "/netReplay");
        comando.put(R.id.net_stop, "/netStop");
        comando.put(R.id.net_rec, "/netRec");

        comando.put(R.id.net_ppv, "/netPPV");
        comando.put(R.id.net_now, "/netNow");
        comando.put(R.id.net_musica, "/netMusica");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NetFragment newInstance(String param1, String param2) {
        NetFragment fragment = new NetFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_net, container, false);
        view.findViewById(R.id.net_portal).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_on_off).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_mosaico).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_info).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_volume_up).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_volume_down).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_mute).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_voltar).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_channel_up).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_channel_down).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_sair).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_net_tv).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_up).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_down).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_left).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_right).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_ok).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_itv).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_audio).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_agora).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_legenda).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_message).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_1).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_2).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_3).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_4).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_5).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_6).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_7).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_8).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_9).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_0).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_fav).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_menu).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_rew).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_play).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_fwd).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_replay).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_stop).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_rec).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_ppv).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_now).setOnClickListener(this::netHandler);
        view.findViewById(R.id.net_musica).setOnClickListener(this::netHandler);
        return view;
    }

    /**
     * From: https://stackoverflow.com/questions/10770055/use-toast-inside-fragment
     * @param view a View representing a view
     */
    public void netHandler(View view) {
        URL url = null;
        String serverURL = "http://";
        serverURL += HTTPConnection.serverIpAddress;
        serverURL += comando.get(view.getId());
//        Toast.makeText(getActivity(), serverURL, Toast.LENGTH_SHORT).show();
        new NetworkTask(getActivity()).execute(serverURL);
    }
}