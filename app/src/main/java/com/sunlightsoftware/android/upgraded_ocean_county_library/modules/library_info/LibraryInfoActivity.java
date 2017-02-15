package com.sunlightsoftware.android.upgraded_ocean_county_library.modules.library_info;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.sunlightsoftware.android.upgraded_ocean_county_library.modules.frameworks.SingleFragmentActivity;

/**
 * Created by Garrett on 1/10/2017.
 */

public class LibraryInfoActivity extends SingleFragmentActivity {
    private static final String EXTRA_LIBRARY_PHOTO_ASSET_PATH = "com.sunlightsoftware" +
            ".android.ocean_county_library.modules.library_info.library_photo";

    private static final String EXTRA_LIBRARY_NAME = "com.sunlightsoftware.android" +
            ".ocean_county_library.modules.library_name";

    public static Intent newIntent(Context packageContext, String libraryPhotoAssetPath,
                                   String libraryName) {
        Intent i = new Intent(packageContext, LibraryInfoActivity.class);
        i.putExtra(EXTRA_LIBRARY_PHOTO_ASSET_PATH, libraryPhotoAssetPath);
        i.putExtra(EXTRA_LIBRARY_NAME, libraryName);
        return i;
    }
    @Override
    protected Fragment createFragment() {
        return LibraryInfoFragment.newInstance(getIntent()
                .getStringExtra(EXTRA_LIBRARY_PHOTO_ASSET_PATH),
                getIntent().getStringExtra(EXTRA_LIBRARY_NAME));
    }
}
