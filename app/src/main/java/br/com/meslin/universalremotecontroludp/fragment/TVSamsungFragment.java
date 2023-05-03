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

public class TVSamsungFragment extends Fragment {
    /** Maps keys and commands */
    private Map<Integer, String> command;

    public TVSamsungFragment() {
        // Required empty public constructor
        createMap();
    }

    /**
     * Creates a map between virtual key and command
     */
    private void createMap() {
        command = new HashMap<>();

        command.put(R.id.tv_smsng_power, "0xE0E040BF,32");
        command.put(R.id.tv_smsng_source, "0xE0E0807F,32");
        command.put(R.id.tv_smsng_hdmi, "0xE0E0D12E,32");

        command.put(R.id.tv_smsng_1, "0xE0E020DF,32");
        command.put(R.id.tv_smsng_2, "0xE0E0A05F,32");
        command.put(R.id.tv_smsng_3, "0xE0E0609F,32");
        command.put(R.id.tv_smsng_4, "0xE0E010EF,32");
        command.put(R.id.tv_smsng_5, "0xE0E0906F,32");
        command.put(R.id.tv_smsng_6, "0xE0E050AF,32");
        command.put(R.id.tv_smsng_7, "0xE0E030CF,32");
        command.put(R.id.tv_smsng_8, "0xE0E0B04F,32");
        command.put(R.id.tv_smsng_9, "0xE0E0708F,32");
        command.put(R.id.tv_smsng_0, "0xE0E08877,32");
        command.put(R.id.tv_smsng_dash, "0xE0E0C43B,32");
        command.put(R.id.tv_smsng_pre_ch, "0xE0E08FFA,32");

        command.put(R.id.tv_smsng_volume_up, "0xE0E0E01F,32");
        command.put(R.id.tv_smsng_volume_down, "0xE0E0D02F,32");
        command.put(R.id.tv_smsng_mute, "0xE0E0F00F,32");
        command.put(R.id.tv_smsng_ch_list, "0xE0E0D629,32");
        command.put(R.id.tv_smsng_channel_up, "0xE0E048B7,32");
        command.put(R.id.tv_smsng_channel_down, "0xE0E008F7,32");

        command.put(R.id.tv_smsng_smart, "0xE0E09E61,32");
        command.put(R.id.tv_smsng_menu, "0xE0E058A7,32");
        command.put(R.id.tv_smsng_guide, "0xE0E0F20D,32");

        command.put(R.id.tv_smsng_tools, "0xE0E0D22D,32");
        command.put(R.id.tv_smsng_info, "0xE0E0F807,32");

        command.put(R.id.tv_smsng_up, "0xE0E006F9,32");
        command.put(R.id.tv_smsng_down, "0xE0E08679,32");
        command.put(R.id.tv_smsng_left, "0xE0E0A659,32");
        command.put(R.id.tv_smsng_right, "0xE0E046B9,32");
        command.put(R.id.tv_smsng_ok, "0xE0E016E9,32");

        command.put(R.id.tv_smsng_return, "0xE0E01AE5,32");
        command.put(R.id.tv_smsng_exit, "0xE0E0B44B,32");

        command.put(R.id.tv_smsng_a, "0xE0E036C9,32");
        command.put(R.id.tv_smsng_b, "0xE0E028D7,32");
        command.put(R.id.tv_smsng_c, "0xE0E0A857,32");
        command.put(R.id.tv_smsng_d, "0xE0E06897,32");

        command.put(R.id.tv_smsng_e_manual, "0xE0E0FC03,32");
        command.put(R.id.tv_smsng_srs, "0xE0E07689,32");
        command.put(R.id.tv_smsng_p_mode, "0xE0E014EB,32");

        command.put(R.id.tv_smsng_p_size, "0xE0E07C83,32");
        command.put(R.id.tv_smsng_cc, "0xE0E0A45B,32");
        command.put(R.id.tv_smsng_mts, "0xE0E000FF,32");

        command.put(R.id.tv_smsng_rew, "0xE0E0A25D,32");
        command.put(R.id.tv_smsng_pause, "0xE0E052AD,32");
        command.put(R.id.tv_smsng_fwd, "0xE0E012ED,32");

        command.put(R.id.tv_smsng_rec, "0xE0E0926D,32");
        command.put(R.id.tv_smsng_play, "0xE0E0E21D,32");
        command.put(R.id.tv_smsng_stop, "0xE0E0629D,32");
    }

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_samsung, container, false);
        view.findViewById(R.id.tv_smsng_power).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_source).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_hdmi).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_1).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_2).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_3).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_4).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_5).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_6).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_7).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_8).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_9).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_0).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_dash).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_pre_ch).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_mute).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_ch_list).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_volume_up).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_volume_down).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_channel_up).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_channel_down).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_smart).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_menu).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_guide).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_tools).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_up).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_down).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_left).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_right).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_ok).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_return).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_exit).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_a).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_b).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_c).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_d).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_e_manual).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_srs).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_p_mode).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_p_size).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_cc).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_mts).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_rew).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_pause).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_fwd).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_rec).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_play).setOnClickListener(this::tvSmsngHandler);
        view.findViewById(R.id.tv_smsng_stop).setOnClickListener(this::tvSmsngHandler);
        return view;
    }

    private void tvSmsngHandler(View view) {
        String message = Constants.SAMSUNG + "," + command.get(view.getId());
        new UDPSenderTask(message, getActivity()).execute();
    }
}