package com.sunlightsoftware.android.upgraded_ocean_county_library.models;

/**
 * Created by Garrett on 1/7/2017.
 */

public class Library {
    private String mName;
    private String mAssetPath;

    public Library(String name, String assetPath) {
        mName = name;
        mAssetPath = assetPath;
    }

    public String getName() {
        return mName;
    }

    public String getAssetPath() {
        return mAssetPath;
    }
}
