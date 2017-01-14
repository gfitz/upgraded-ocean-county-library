package com.sunlightsoftware.android.ocean_county_library.modules.library_info;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunlightsoftware.android.ocean_county_library.Constant;
import com.sunlightsoftware.android.ocean_county_library.R;
import com.sunlightsoftware.android.ocean_county_library.components.utils.BitmapWorkerTask;
import com.sunlightsoftware.android.ocean_county_library.provider.Day;
import com.sunlightsoftware.android.ocean_county_library.provider.LibraryProvider;

import java.util.Calendar;
import java.util.HashMap;
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
    private TextView mHoursOfOperationTextView;
    private TextView mOpenNowTextView;
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
        // assets does not load with the regular size.x value. It;s only one image which is
        // frustrating

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

        mDirectionsTextView = (TextView) v.findViewById(R.id.library_info_directions_text_view);

        mOpenNowTextView = (TextView) v.findViewById(R.id.is_open_text_view);
        mOpenNowTextView.setTypeface(Typeface.createFromAsset(getContext().getAssets(),
                Constant.MONTSERRAT_FONT_BOLD));

        mSundayHoursTextView = (TextView) v.findViewById(R.id.sunday_hours_text_view);

        mMondayHoursTextView = (TextView) v.findViewById(R.id.monday_hours_text_view);

        mTuesdayHoursTextView = (TextView) v.findViewById(R.id.tuesday_hours_text_view);

        mWednesdayHoursTextView = (TextView) v.findViewById(R.id.wednesday_hours_text_view);

        mThursdayHoursTextView = (TextView) v.findViewById(R.id.thursday_hours_text_view);

        mFridayHoursTextView = (TextView) v.findViewById(R.id.friday_hours_text_view);

        mSaturdayTextView = (TextView) v.findViewById(R.id.saturday_hours_text_view);

        mHoursOfOperationTextView = (TextView)
                v.findViewById(R.id.library_info_hours_of_operation_text_view);
        mHoursOfOperationTextView.setTypeface(Typeface.createFromAsset(getContext().getAssets(),
                Constant.MONTSERRAT_FONT_BOLD));

        TextView[] textViews = {
                mCallTextView,
                mDirectionsTextView,
                mSundayHoursTextView,
                mMondayHoursTextView,
                mTuesdayHoursTextView,
                mWednesdayHoursTextView,
                mThursdayHoursTextView,
                mFridayHoursTextView,
                mSaturdayTextView
        };

        for (TextView view : textViews) {
            view.setTypeface(Typeface.createFromAsset(getContext().getAssets(),
                    Constant.MONTSERRAT_FONT_REGULAR));
        }

        String branchName = getArguments().getString(ARG_LIBRARY_NAME).toUpperCase();
        branchName = branchName.replace(" ", "_");
        branchName = branchName.substring(0, branchName.length() - 1);

        final LibraryProvider provider = LibraryProvider.valueOf(branchName);
        setHoursTextViews(provider);

        mDirectionsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=" + provider.getLatitude()
                        + ", " + provider.getLongitude());
                Intent navigationIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                navigationIntent.setPackage("com.google.android.apps.maps");

                if (navigationIntent.resolveActivity(getContext().getPackageManager()) != null) {
                    startActivity(navigationIntent);
                }
            }
        });

        mCallTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:" + provider.getPhoneNumber());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                if (callIntent.resolveActivity(getContext().getPackageManager()) != null)
                    startActivity(callIntent);
            }
        });

        return v;
    }

    private void setHoursTextViews(LibraryProvider library) {

        //Check if closed on Sunday
        String sundayOpeningHour = library.getOpeningHourString(Day.SUNDAY);

        if (sundayOpeningHour.equals("Closed")) {
            mSundayHoursTextView.setText(getString(R.string.closed_on_this_day,
                    getString(R.string.sunday)));
        } else {
            mSundayHoursTextView.setText(getString(R.string.sunday_hours,
                    library.getOpeningHourString(Day.SUNDAY),
                    library.getClosingHourString(Day.SUNDAY)));
        }


        //Set the textviews
        mMondayHoursTextView.setText(getString(R.string.monday_hours,
                library.getOpeningHourString(Day.MONDAY),
                library.getClosingHourString(Day.MONDAY)));
        mTuesdayHoursTextView.setText(getString(R.string.tuesday_hours,
                library.getOpeningHourString(Day.TUESDAY),
                library.getClosingHourString(Day.TUESDAY)));
        mWednesdayHoursTextView.setText(getString(R.string.wednesday_hours,
                library.getOpeningHourString(Day.WEDNESDAY),
                library.getClosingHourString(Day.WEDNESDAY)));
        mThursdayHoursTextView
                .setText(getString(R.string.thursday_hours,
                library.getOpeningHourString(Day.THURSDAY),
                library.getClosingHourString(Day.THURSDAY)));
        mFridayHoursTextView.setText(getString(R.string.friday_hours,
                library.getOpeningHourString(Day.FRIDAY),
                library.getClosingHourString(Day.FRIDAY)));
        mSaturdayTextView.setText(getString(R.string.saturday_hours,
                library.getOpeningHourString(Day.SATURDAY),
                library.getClosingHourString(Day.SATURDAY)));

        //Set open now
        Calendar calendar = Calendar.getInstance();
        int calendarDay = calendar.get(Calendar.DAY_OF_WEEK);

        int openingHourOnCurrentDay, closingHourOnCurrentDay;
        HashMap<Integer, Day> calendarToDayMap = new HashMap<>();
        calendarToDayMap.put(Calendar.SUNDAY, Day.SUNDAY);
        calendarToDayMap.put(Calendar.MONDAY, Day.MONDAY);
        calendarToDayMap.put(Calendar.TUESDAY, Day.TUESDAY);
        calendarToDayMap.put(Calendar.WEDNESDAY, Day.WEDNESDAY);
        calendarToDayMap.put(Calendar.THURSDAY, Day.THURSDAY);
        calendarToDayMap.put(Calendar.FRIDAY, Day.FRIDAY);
        calendarToDayMap.put(Calendar.SATURDAY, Day.SATURDAY);

        openingHourOnCurrentDay = library.getOpeningHour(calendarToDayMap.get(calendarDay));
        closingHourOnCurrentDay = library.getClosingHour(calendarToDayMap.get(calendarDay));

        int currentTime = calendar.get(Calendar.HOUR_OF_DAY);
        Log.d(TAG, "Current time =" + currentTime);

        //Convert opening and closing times to 24 hour format
        openingHourOnCurrentDay = openingHourOnCurrentDay == 1 ? 13 : openingHourOnCurrentDay;
        closingHourOnCurrentDay += 12;

        boolean open = currentTime >= openingHourOnCurrentDay
                && currentTime <= closingHourOnCurrentDay;

        if (open) {
            mOpenNowTextView.setText(getString(R.string.open_now));
            mOpenNowTextView.setTextColor(getContext().getResources().getColor(R.color.open_green));
        } else {
            mOpenNowTextView.setText(getString(R.string.closed_now));
            mOpenNowTextView.setTextColor(getContext().getResources().getColor(R.color.closed_red));
        }
    }

}
