package com.sunlightsoftware.android.ocean_county_library.modules.library_info;

import android.graphics.Point;
import android.graphics.Typeface;
import android.icu.text.LocaleDisplayNames;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunlightsoftware.android.ocean_county_library.Constant;
import com.sunlightsoftware.android.ocean_county_library.R;
import com.sunlightsoftware.android.ocean_county_library.components.utils.AsyncDrawable;
import com.sunlightsoftware.android.ocean_county_library.components.utils.BitmapWorkerTask;
import com.sunlightsoftware.android.ocean_county_library.components.utils.ImageUtils;

import java.util.concurrent.ExecutionException;

/**
 * Created by Garrett on 1/10/2017.
 */

public class LibraryInfoFragment extends Fragment {
    private static final String TAG = "LibraryInfoFragment";

    private static final String ARG_PHOTO_ASSET_PATH = "photo_asset_path";
    private static final String ARG_LIBRARY_NAME = "library_name";

    private ImageView mLibraryImageView;
    private TextView mCallTextView;
    private TextView mDirectionsTextView;
    private TextView mSundayHoursTextView;
    private TextView mMondayHoursTextView;
    private TextView mTuesdayHoursTextView;
    private TextView mWednesdayHoursTextView;
    private TextView mThursdayHoursTextView;
    private TextView mFridayHoursTextView;
    private TextView mSaturdayTextView;

    public static LibraryInfoFragment newInstance(String photoAssetPath, String libraryName) {
        Bundle args = new Bundle();
        args.putString(ARG_PHOTO_ASSET_PATH, photoAssetPath);
        args.putString(ARG_LIBRARY_NAME, libraryName);

        LibraryInfoFragment fragment = new LibraryInfoFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setTitle(getArguments().getString(ARG_LIBRARY_NAME));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_library_info, container, false);

        mLibraryImageView = (ImageView) v.findViewById(R.id.library_info_image_view);

        //Publish bitmap to imageview. Should really look into how to just pass a reference of
        //previous bitmap
        // into this fragment
        Point size = new Point();
        getActivity().getWindowManager().getDefaultDisplay().getSize(size);

        Log.d(TAG, "Size x: " + size.x);

        // I know this is a bit hacky and could use some redesign. For some reason one of my
        // assets does not load with the regular size.x value. It;s only one image which is frustrating

        BitmapWorkerTask bitmapWorkerTask =
                new BitmapWorkerTask(mLibraryImageView, getContext().getAssets(), size.x / 2, 225);
        try {
            mLibraryImageView.setImageBitmap(bitmapWorkerTask
                    .execute(getArguments().getString(ARG_PHOTO_ASSET_PATH)).get());
        } catch (InterruptedException e) {
            Log.e(TAG, "InterruptedException", e);
        } catch (ExecutionException e) {
            Log.e(TAG, "ExecutionException", e);
        }

        mCallTextView = (TextView) v.findViewById(R.id.library_info_call_text_view);
        mCallTextView.setTypeface(Typeface.createFromAsset(getContext().getAssets(),
                Constant.MONTSERRAT_FONT));

        mDirectionsTextView = (TextView) v.findViewById(R.id.library_info_directions_text_view);
        mDirectionsTextView.setTypeface(Typeface.createFromAsset(getContext().getAssets(),
                Constant.MONTSERRAT_FONT));

        mSundayHoursTextView = (TextView) v.findViewById(R.id.sunday_hours_text_view);
        mSundayHoursTextView.setText(getString(R.string.sunday_hours, Integer.toString(9),
                Integer.toString(9)));

        mMondayHoursTextView = (TextView) v.findViewById(R.id.monday_hours_text_view);
        mMondayHoursTextView.setText(getString(R.string.monday_hours, Integer.toString(9),
                Integer.toString(9)));

        mTuesdayHoursTextView = (TextView) v.findViewById(R.id.tuesday_hours_text_view);
        mTuesdayHoursTextView.setText(getString(R.string.tuesday_hours, Integer.toString(9),
                Integer.toString(9)));

        mWednesdayHoursTextView = (TextView) v.findViewById(R.id.wednesday_hours_text_view);
        mWednesdayHoursTextView.setText(getString(R.string.wednesday_hours, Integer.toString(9),
                Integer.toString(9)));

        mThursdayHoursTextView = (TextView) v.findViewById(R.id.thursday_hours_text_view);
        mThursdayHoursTextView.setText(getString(R.string.thursday_hours, Integer.toString(9),
                Integer.toString(9)));

        mFridayHoursTextView = (TextView) v.findViewById(R.id.friday_hours_text_view);
        mFridayHoursTextView.setText(getString(R.string.friday_hours, Integer.toString(9),
                Integer.toString(9)));

        mSaturdayTextView = (TextView) v.findViewById(R.id.saturday_hours_text_view);
        mSaturdayTextView.setText(getString(R.string.saturday_hours, Integer.toString(9),
                Integer.toString(9)));

        return v;
    }
}
