package com.sunlightsoftware.android.ocean_county_library.modules.library_website;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.sunlightsoftware.android.ocean_county_library.R;
import com.sunlightsoftware.android.ocean_county_library.modules.frameworks.SingleFragmentActivity;

/**
 * Created by Garrett on 1/5/2017.
 */

public class LibraryWebsiteActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context packageContext, Uri website) {
        Intent intent = new Intent(packageContext, LibraryWebsiteActivity.class);
        intent.setData(website);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.ocean_county_library);
    }

    @Override
    protected Fragment createFragment() {
        return LibraryWebsiteFragment.newInstance(getIntent().getData());
    }
}
