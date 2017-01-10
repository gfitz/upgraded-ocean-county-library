package com.sunlightsoftware.android.ocean_county_library.components.utils;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.sunlightsoftware.android.ocean_county_library.R;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/**
 * Created by Garrett on 1/7/2017.
 */

public class ImageUtils {
//    public static Bitmap getBitmapFromAssetPath(AssetManager assetManager, String assetPath, Activity activity) {
//        InputStream inputStream = null;
//        Bitmap bitmap = null;
//
//        try {
//            inputStream = assetManager.open(assetPath);
//            //  bitmap = BitmapFactory.decodeStream(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return getScaledBitmap(inputStream, 225, 100);
//    }

    public static Bitmap decodeSampledBitmapFromAssets(AssetManager assetManager, String assetPath,
                                                       int reqWidth, int reqHeight) {
        InputStream inputStream = null;

        try {
            inputStream = assetManager.open(assetPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);

        //Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        //Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options,
                                             int reqWidth, int reqHeight) {
        //Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and
            // keeps height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight &&
                    (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if (imageView != null) {
            final Drawable drawable = imageView.getDrawable();
            if (drawable instanceof AsyncDrawable) {
                final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
                return asyncDrawable.getBitmapWorkerTask();
            }
        }

        return null;
    }
//    public static Bitmap getScaledBitmap(InputStream inputStream, Activity activity) {
//        Point size = new Point();
//        activity.getWindowManager().getDefaultDisplay().getSize(size);
//
//        return getScaledBitmap(inputStream, size.x, size.y);
//    }
//    public static Bitmap getScaledBitmap(InputStream inputStream, int destWidth, int destHeight) {
//        // Read in dimensions of the image on the disk
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeStream(inputStream, null,  options);
//
//        float srcWidth = options.outWidth;
//        float srcHeight = options.outHeight;
//
//        //Figure out how much to scale down by
//        int inSampleSize = 1;
//        if (srcHeight > destHeight || srcWidth > destWidth) {
//            if (srcWidth > srcHeight) {
//                inSampleSize = Math.round(srcHeight / destHeight);
//            } else {
//                inSampleSize = Math.round(srcWidth / destWidth);
//            }
//        }
//
//        options = new BitmapFactory.Options();
//        options.inSampleSize = inSampleSize;
//
//        //Read in and create final Bitmap
//        return BitmapFactory.decodeStream(inputStream, null, options);
//    }
//
////    public Bitmap getScaledBitmape(Resources resources) {
////        BitmapFactory.Options options = new BitmapFactory.Options();
////        BitmapFactory.decodeResource(resources, R.raw.sailboat)
////    }
////
////    public static Bitmap getSampledBitmapFromAssets(AssetManager assetManager, int reqWidth, int rewHeight) {
////        final BitmapFactory.Options options = new BitmapFactory.Options();
////        options.inJustDecodeBounds = true;
////        BitmapFactory.de
////    }
}
