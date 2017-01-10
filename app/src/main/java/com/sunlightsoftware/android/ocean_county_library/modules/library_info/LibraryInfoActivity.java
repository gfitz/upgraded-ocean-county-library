package com.sunlightsoftware.android.ocean_county_library.modules.library_info;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;

import com.sunlightsoftware.android.ocean_county_library.modules.frameworks.SingleFragmentActivity;

/**
 * Created by Garrett on 1/10/2017.
 */

public class LibraryInfoActivity extends SingleFragmentActivity {
    private static final String EXTRA_LIBRARY_PHOTO = "com.sunlightsoftware" +
            ".android.ocean_county_library.modules.library_info.library_photo";

    public static Intent newIntent(Context packageContext, Bitmap libraryPhoto) {
        Intent i = new Intent(packageContext, LibraryInfoActivity.class);
        i.putExtra(EXTRA_LIBRARY_PHOTO, libraryPhoto);
        return i;
    }
    @Override
    protected Fragment createFragment() {
        return LibraryInfoFragment.newInstance((Bitmap)getIntent()
                .getParcelableExtra(EXTRA_LIBRARY_PHOTO));
    }
}
