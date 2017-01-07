package com.sunlightsoftware.android.ocean_county_library.components.utils;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Garrett on 1/7/2017.
 */

public class ImageUtils {
    public static Bitmap getBitmapFromAssetPath(AssetManager assetManager, String assetPath) {
        InputStream inputStream;
        Bitmap bitmap = null;

        try {
            inputStream = assetManager.open(assetPath);
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
