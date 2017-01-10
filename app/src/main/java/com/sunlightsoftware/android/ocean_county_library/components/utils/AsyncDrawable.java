package com.sunlightsoftware.android.ocean_county_library.components.utils;

import android.graphics.drawable.BitmapDrawable;

import java.lang.ref.WeakReference;

/**
 * Created by Garrett on 1/9/2017.
 */

public class AsyncDrawable extends BitmapDrawable{
    private final WeakReference<BitmapWorkerTask> mBitmapWorkerTaskWeakReference;

    public AsyncDrawable(BitmapWorkerTask bitmapWorkerTask) {
        mBitmapWorkerTaskWeakReference = new WeakReference<BitmapWorkerTask>(bitmapWorkerTask);
    }

    public BitmapWorkerTask getBitmapWorkerTask() {
        return mBitmapWorkerTaskWeakReference.get();
    }
}
