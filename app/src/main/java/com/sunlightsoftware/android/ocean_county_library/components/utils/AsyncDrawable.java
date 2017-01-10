package com.sunlightsoftware.android.ocean_county_library.components.utils;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import java.lang.ref.WeakReference;

/**
 * Created by Garrett on 1/9/2017.
 */

public class AsyncDrawable extends BitmapDrawable{
    private final WeakReference<BitmapWorkerTask> mBitmapWorkerTaskWeakReference;

    //MAY NEED TO CHANGE FROMR ESOURCES TO ASSRT MANAGER
    public AsyncDrawable(BitmapWorkerTask bitmapWorkerTask) {
        mBitmapWorkerTaskWeakReference = new WeakReference<BitmapWorkerTask>(bitmapWorkerTask);
    }

    public BitmapWorkerTask getBitmapWorkerTask() {
        return mBitmapWorkerTaskWeakReference.get();
    }
}
