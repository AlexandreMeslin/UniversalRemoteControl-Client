package br.com.meslin.universalremotecontrol;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import br.com.meslin.universalremotecontrol.fragment.MideaFragment;
import br.com.meslin.universalremotecontrol.fragment.NetFragment;
import br.com.meslin.universalremotecontrol.fragment.ReceiverOnkioFragment;
import br.com.meslin.universalremotecontrol.fragment.SettingsFragment;
import br.com.meslin.universalremotecontrol.fragment.TVSamsungFragment;
import br.com.meslin.universalremotecontrol.fragment.TVSonyFragment;

/**
 * From: https://stackoverflow.com/questions/55372259/how-to-use-tablayout-with-viewpager2-in-android
 * Connecting an adapter to the viewpager
 * So the adapter is in charge of supplying the correct fragments to the activity.
 * You'll have to extend FragmentStateAdapter which I've done very simply as below (it's a private class because it's declared within my MainActivity.java here):
 */
public class MyPagerAdapter extends FragmentStateAdapter {
    /** Number of tabs. Don't forget to update MyPagerAdapter.createFragment method */
    private final int N_TABS = 6;
    private int numOfTabs;
    public MyPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.numOfTabs = N_TABS;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return new SettingsFragment();
            case 1:
                return new NetFragment();
            case 2:
                return new TVSonyFragment();
            case 3:
                return new MideaFragment();
            case 4:
                return new TVSamsungFragment();
            case 5:
                return new ReceiverOnkioFragment();
            default:
                return null;
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return numOfTabs;
    }
}
