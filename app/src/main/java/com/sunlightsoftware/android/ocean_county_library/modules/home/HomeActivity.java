package com.sunlightsoftware.android.ocean_county_library.modules.home;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sunlightsoftware.android.ocean_county_library.R;
import com.sunlightsoftware.android.ocean_county_library.modules.frameworks.SingleFragmentActivity;

public class HomeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return HomeFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }
}
