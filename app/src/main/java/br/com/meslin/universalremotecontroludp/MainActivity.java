/*
From https://www.youtube.com/watch?v=h4HwU_ENXYM
From https://www.youtube.com/watch?v=HHd-Fa3DCng
From https://iamnaran.medium.com/viewpager2-with-tablayout-android-310bc7360cb5
UDP Version
*/

package br.com.meslin.universalremotecontroludp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabBar);
        /*
        These code were removed because they are never used:
        TabItem tabSettings = findViewById(R.id.tabSettings);
         */

        // I can then connect my own Adapter to the ViewPager as below:
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(fragmentManager, getLifecycle());
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);

        // Connecting TabLayout to Adapter
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        // Change Tab when swiping
        // Finally we couple back when the user swipes the fragment to set the correct tab item as selected
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            /**
             * This method will be invoked when a new page becomes selected. Animation is not
             * necessarily complete.
             *
             * @param position Position index of the new selected page.
             */
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // This will update selected tab during tab slicing
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        // To specify the starting tab in TabLayout, you can use the TabLayout.selectTab() method after you have initialized the tabs in your code.
        TabLayout.Tab startingTab = tabLayout.getTabAt(1);
        if (startingTab != null) {
            startingTab.select();
        }
    }
}