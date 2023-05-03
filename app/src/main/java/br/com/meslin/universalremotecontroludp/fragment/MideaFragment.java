package br.com.meslin.universalremotecontroludp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

import br.com.meslin.universalremotecontroludp.Constants;
import br.com.meslin.universalremotecontroludp.R;
import br.com.meslin.universalremotecontroludp.network.UDPSenderTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MideaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MideaFragment extends Fragment {
    /** Mapa de teclas e comandos */
    private HashMap<Integer, String> command;

    public MideaFragment() {
        // Required empty public constructor
        createMap();
    }

    /**
     * Creates a map betwwen vitual key and URL
     */
    private void createMap() {
        command = new HashMap<Integer, String>();

        command.put(R.id.ac_on, "1");
        command.put(R.id.ac_off, "2");

        command.put(R.id.ac_mode_auto, "3");
        command.put(R.id.ac_mode_cool, "4");
        command.put(R.id.ac_mode_dry, "5");
        command.put(R.id.ac_mode_fan, "6");

        command.put(R.id.ac_17, "7");
        command.put(R.id.ac_18, "8");
        command.put(R.id.ac_19, "9");
        command.put(R.id.ac_20, "10");
        command.put(R.id.ac_21, "11");
        command.put(R.id.ac_22, "12");
        command.put(R.id.ac_23, "13");
        command.put(R.id.ac_24, "14");
        command.put(R.id.ac_25, "15");
        command.put(R.id.ac_26, "16");

        command.put(R.id.ac_fan_auto, "17");
        command.put(R.id.ac_fan_low, "18");
        command.put(R.id.ac_fan_medium, "19");
        command.put(R.id.ac_fan_high, "20");

        command.put(R.id.ac_swing, "21");
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MideaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MideaFragment newInstance(String param1, String param2) {
        MideaFragment fragment = new MideaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     *
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return a view object infated
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_midea, container, false);

        // Listeners
        view.findViewById(R.id.ac_on).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_off).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_mode_auto).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_mode_cool).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_mode_dry).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_mode_fan).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_17).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_18).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_19).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_20).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_21).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_22).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_23).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_24).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_25).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_26).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_fan_auto).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_fan_low).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_fan_medium).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_fan_high).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_air_direction).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_swing).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_economic_running).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_clock).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_ok).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_cancel).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_timer_on).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_timer_off).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_time_adjust_down).setOnClickListener(this::mideaHandler);
        view.findViewById(R.id.ac_time_adjust_up).setOnClickListener(this::mideaHandler);

        return view;
    }

    /**
     *
     * @param view a view representing the button that was clicked
     */
    @SuppressWarnings("SpellCheckingInspection")
    private void mideaHandler(View view) {
        String message = Constants.MIDEA + "," + command.get(view.getId());
        new UDPSenderTask(message, getActivity()).execute();
    }
}