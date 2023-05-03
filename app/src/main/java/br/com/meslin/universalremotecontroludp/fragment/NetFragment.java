package br.com.meslin.universalremotecontroludp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

import br.com.meslin.universalremotecontroludp.Constants;
import br.com.meslin.universalremotecontroludp.R;
import br.com.meslin.universalremotecontroludp.network.UDPSenderTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NetFragment extends Fragment {
    /** Mapa de teclas e comandos */
    private Map<Integer, String> command;

    public NetFragment() {
        // Required empty public constructor
        createMap();
    }

    /**
     * Creates a map between virtual key and command
     */
    private void createMap() {
        command = new HashMap<>();

        command.put(R.id.net_portal, "0xE17A24DB");
        command.put(R.id.net_on_off, "0xE17A48B7");

        command.put(R.id.net_mosaico, "0xE17A847B");
        command.put(R.id.net_info, "0xE17AC837");

        command.put(R.id.net_volume_up, "0xE17AB04F");
        command.put(R.id.net_volume_down, "0xE17A708F");

        // TODO: insert the correct code here
        command.put(R.id.net_mute, "00000000");
        command.put(R.id.net_voltar, "00000000");

        command.put(R.id.net_channel_up, "0xE17A08F7");
        command.put(R.id.net_channel_down, "0xE17A58A7");

        command.put(R.id.net_sair, "0xE17A50AF");
        command.put(R.id.net_net_tv, "0xE17A28D7");

        command.put(R.id.net_up, "0xE17AD02F");
        command.put(R.id.net_down, "0xE17A30CF");
        command.put(R.id.net_left, "0xE17AD827");
        command.put(R.id.net_right, "0xE17A38C7");
        command.put(R.id.net_ok, "0xE17AA857");

        command.put(R.id.net_itv, "0xE17A6897");
        command.put(R.id.net_audio, "0xE17AE817");
        command.put(R.id.net_agora, "0xE17A7887");
        command.put(R.id.net_legenda, "0xE17A18E7");
        command.put(R.id.net_message, "0xE17A9867");

        command.put(R.id.net_1, "0xE17A807F");
        command.put(R.id.net_2, "0xE17A40BF");
        command.put(R.id.net_3, "0xE17AC03F");
        command.put(R.id.net_4, "0xE17A20DF");
        command.put(R.id.net_5, "0xE17AA05F");
        command.put(R.id.net_6, "0xE17A609F");
        command.put(R.id.net_7, "0xE17AE01F");
        command.put(R.id.net_8, "0xE17A10EF");
        command.put(R.id.net_9, "0xE17A906F");
        command.put(R.id.net_0, "0xE17A00FF");

        command.put(R.id.net_fav, "0xE17AB847");
        command.put(R.id.net_menu, "0xE17AC43B");

        command.put(R.id.net_rew, "0xE17A2CD3");
        command.put(R.id.net_play, "0xE17A6C93");
        command.put(R.id.net_fwd, "0xE17AAC53");
        command.put(R.id.net_replay, "0xE17AEC13");
        command.put(R.id.net_stop, "0xE17A4CB3");
        command.put(R.id.net_rec, "0xE17ACC33");

        command.put(R.id.net_ppv, "0xE17A14EB");
        command.put(R.id.net_now, "0xE17A9C63");
        command.put(R.id.net_musica, "0xE17A04FB");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NetFragment.
     */
    @SuppressWarnings("unused")
    public static NetFragment newInstance(String param1, String param2) {
        NetFragment fragment = new NetFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
     * From: <a href="https://stackoverflow.com/questions/10770055/use-toast-inside-fragment">Toast</a>
     * @param view a View representing a view
     */
    private void netHandler(View view) {
        // remote control code for the selected action
        // 32-bit command code
        String message = Constants.NEC + "," + command.get(view.getId()) + ",32";
        new UDPSenderTask(message, getActivity()).execute();
    }
}