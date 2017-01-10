package com.sunlightsoftware.android.ocean_county_library.components.utils;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

import static com.sunlightsoftware.android.ocean_county_library.components.utils.ImageUtils.decodeSampledBitmapFromAssets;

/**
 * Created by Garrett on 1/9/2017.
 */

public class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
    private final WeakReference<ImageView> mImageViewWeakReference;
    private final AssetManager mAssetManager;
    private final int mReqWidth;
    private final int mReqHeight;
    public String assetPath;

    public BitmapWorkerTask(ImageView imageView, AssetManager manager,
                            int reqWidth, int reqHeight) {
        mImageViewWeakReference = new WeakReference<ImageView>(imageView);
        mAssetManager = manager;
        mReqWidth = reqWidth;
        mReqHeight = reqHeight;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        assetPath = strings[0];
        return decodeSampledBitmapFromAssets(mAssetManager, assetPath, mReqWidth,
                mReqHeight);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (isCancelled())
            bitmap = null;

        if (mImageViewWeakReference != null && bitmap != null) {
            final ImageView imageView = mImageViewWeakReference.get();
            final BitmapWorkerTask bitmapWorkerTask = ImageUtils.getBitmapWorkerTask(imageView);

            if (this == bitmapWorkerTask && imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
