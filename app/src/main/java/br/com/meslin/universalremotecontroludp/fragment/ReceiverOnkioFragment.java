package br.com.meslin.universalremotecontroludp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.meslin.universalremotecontroludp.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ReceiverOnkioFragment extends Fragment {
    public ReceiverOnkioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @ return A new instance of fragment ReceiverOnkioFragment.
     */
    /*
    // TODO: Rename and change types and number of parameters
    public static ReceiverOnkioFragment newInstance() {
        ReceiverOnkioFragment fragment = new ReceiverOnkioFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receiver_onkio, container, false);
    }
}