package com.sunlightsoftware.android.ocean_county_library.modules.library_website;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.sunlightsoftware.android.ocean_county_library.modules.frameworks.SingleFragmentActivity;

/**
 * Created by Garrett on 1/5/2017.
 */

public class LibraryWebsiteActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, LibraryWebsiteActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return LibraryWebsiteFragment.newInstance(null);
    }
}
