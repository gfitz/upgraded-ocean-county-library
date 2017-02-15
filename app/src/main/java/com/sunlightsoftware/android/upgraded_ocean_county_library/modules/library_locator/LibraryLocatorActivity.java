package com.sunlightsoftware.android.upgraded_ocean_county_library.modules.library_locator;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.sunlightsoftware.android.upgraded_ocean_county_library.modules.frameworks.SingleFragmentActivity;

/**
 * Created by Garrett on 1/7/2017.
 */

public class LibraryLocatorActivity extends SingleFragmentActivity {
    public static Intent newIntent(Context packageContext) {
        return new Intent(packageContext, LibraryLocatorActivity.class);
    }
    @Override
    protected Fragment createFragment() {
        return new LibraryLocatorFragment();
    }
}
