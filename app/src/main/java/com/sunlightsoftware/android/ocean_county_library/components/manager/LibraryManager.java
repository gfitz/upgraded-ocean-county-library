package com.sunlightsoftware.android.ocean_county_library.components.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.sunlightsoftware.android.ocean_county_library.models.Library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Garrett on 1/7/2017.
 */

public class LibraryManager {
    private static final String TAG = "LibraryManager";
    private static final String LIBRARY_FOLDER = "library_photos";

    private AssetManager mAssetManager;
    private List<Library> mLibraries = new ArrayList<>();

    public LibraryManager(Context context) {
        mAssetManager = context.getAssets();
        loadLibraries();
    }

    private void loadLibraries() {
        String[] libraryPhotoNames;

        try {
            libraryPhotoNames = mAssetManager.list(LIBRARY_FOLDER);
            Log.i(TAG, "Found " + libraryPhotoNames.length + " library photo names");
            Log.i(TAG, "Found photo names: " + Arrays.toString(libraryPhotoNames));
        } catch (IOException e) {
            Log.e(TAG, "Could not load library photo names.", e);
            return;
        }

        for (String filename : libraryPhotoNames) {
            String libraryName = "";
            String nameComponents[] = filename.split("_");

            for (String nameComponent: nameComponents) {

                libraryName +=  Character.toUpperCase(nameComponent.charAt(0)) + nameComponent.substring(1) + " ";
            }
            libraryName = libraryName.replace(".png", "");
            String assetPath = LIBRARY_FOLDER + "/" + filename;
            Library library = new Library(libraryName, assetPath);
            mLibraries.add(library);
        }
    }

    public List<Library> getLibraries() {
        return mLibraries;
    }
}
