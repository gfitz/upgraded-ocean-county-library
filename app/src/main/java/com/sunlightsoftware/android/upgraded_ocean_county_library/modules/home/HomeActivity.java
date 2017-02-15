package com.sunlightsoftware.android.upgraded_ocean_county_library.modules.home;

import android.support.v4.app.Fragment;

import com.sunlightsoftware.android.upgraded_ocean_county_library.modules.frameworks.SingleFragmentActivity;

public class HomeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return HomeFragment.newInstance();
    }

}
