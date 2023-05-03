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

public class TVSonyFragment extends Fragment {
    /** Maps keys and commands */
    private Map<Integer, String> command;

    public TVSonyFragment() {
        // Required empty public constructor
        createMap();
    }

    /**
     * Creates a map between virtual key and command
     */
    private void createMap() {
        command = new HashMap<>();

        command.put(R.id.tv_sony_input, "0xA50,12");
        command.put(R.id.tv_sony_i_o, "0xA90,12");

        command.put(R.id.tv_sony_theater, "0x3EE,15");
        command.put(R.id.tv_sony_fast_rewind, "0x6CE9,15");
        command.put(R.id.tv_sony_play, "0x2CE9,15");
        command.put(R.id.tv_sony_fast_forward, "0x1CE9,15");

        command.put(R.id.tv_sony_sync_menu, "0xD58,15");
        command.put(R.id.tv_sony_previous, "0x1EE9,15");
        command.put(R.id.tv_sony_stop, "0xCE9,15");
        command.put(R.id.tv_sony_fast_forward, "0x5EE9,15");

        command.put(R.id.tv_sony_i_manual, "0x6F58,15");
        command.put(R.id.tv_sony_scene, "0xF58,15");
        command.put(R.id.tv_sony_wide, "0x5E25,15");

        command.put(R.id.tv_sony_digital_analog, "0x58EE,15");
        command.put(R.id.tv_sony_exit, "0xC70,12");
        command.put(R.id.tv_sony_internet_video, "0x4F58,15");

        command.put(R.id.tv_sony_guide, "0x710,12");
        command.put(R.id.tv_sony_favorites, "0x37EE,15");
        command.put(R.id.tv_sony_display, "0x5D0,12");

        command.put(R.id.tv_sony_return, "0x62E9,15");
        command.put(R.id.tv_sony_home, "0x70,12");
        command.put(R.id.tv_sony_options, "0x36E9,15");

        command.put(R.id.tv_sony_up, "0x2F0,12");
        command.put(R.id.tv_sony_down, "0xAF0,12");
        command.put(R.id.tv_sony_left, "0x2D0,12");
        command.put(R.id.tv_sony_right, "0xCD0,12");
        command.put(R.id.tv_sony_ok, "0xA70,12");

        command.put(R.id.tv_sony_red, "0x52E9,15");
        command.put(R.id.tv_sony_green, "0x32E9,15");
        command.put(R.id.tv_sony_yellow, "0x72E9,15");
        command.put(R.id.tv_sony_blue, "0x12E9,15");

        command.put(R.id.tv_sony_1, "0x10,12");
        command.put(R.id.tv_sony_2, "0x810,12");
        command.put(R.id.tv_sony_3, "0x410,12");
        command.put(R.id.tv_sony_4, "0xC10,12");
        command.put(R.id.tv_sony_5, "0x210,12");
        command.put(R.id.tv_sony_6, "0xA10,12");
        command.put(R.id.tv_sony_7, "0x610,12");
        command.put(R.id.tv_sony_8, "0xE10,12");
        command.put(R.id.tv_sony_9, "0x110,12");
        command.put(R.id.tv_sony_0, "0x910,12");
        command.put(R.id.tv_sony_ponto, "0x5CE9,15");
        command.put(R.id.tv_sony_ent, "0xD10,12");

        command.put(R.id.tv_sony_muting, "0x290,12");
        command.put(R.id.tv_sony_cc_subtitle, "0xAE9,15");
        command.put(R.id.tv_sony_volume_up, "0x490,12");
        command.put(R.id.tv_sony_volume_down, "0xC90,12");
        command.put(R.id.tv_sony_channel_up, "0x90,12");
        command.put(R.id.tv_sony_channel_down, "0x890,12");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_sony, container, false);
        view.findViewById(R.id.tv_sony_input).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_i_o).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_theater).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_fast_rewind).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_play).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_fast_forward).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_sync_menu).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_previous).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_stop).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_fast_forward).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_i_manual).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_scene).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_wide).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_digital_analog).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_exit).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_internet_video).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_guide).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_favorites).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_display).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_return).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_home).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_options).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_up).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_down).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_left).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_right).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_ok).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_red).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_green).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_yellow).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_blue).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_1).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_2).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_3).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_4).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_5).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_6).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_7).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_8).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_9).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_0).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_ponto).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_ent).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_muting).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_cc_subtitle).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_channel_up).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_channel_down).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_volume_up).setOnClickListener(this::tvSonyHandler);
        view.findViewById(R.id.tv_sony_volume_down).setOnClickListener(this::tvSonyHandler);
        return view;
    }

    private void tvSonyHandler(View view) {
        String message = Constants.SONY + "," + command.get(view.getId());
        new UDPSenderTask(message, getActivity()).execute();
    }
}