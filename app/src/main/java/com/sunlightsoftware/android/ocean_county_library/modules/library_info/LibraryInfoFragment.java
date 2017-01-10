package com.sunlightsoftware.android.ocean_county_library.modules.library_info;

import android.graphics.Bitmap;
import android.graphics.Typeface;
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
import com.sunlightsoftware.android.ocean_county_library.components.utils.ImageUtils;
import com.sunlightsoftware.android.ocean_county_library.modules.library_locator.LibraryLocatorFragment;

/**
 * Created by Garrett on 1/10/2017.
 */

public class LibraryInfoFragment extends Fragment {
    private static final String TAG = "LibraryInfoFragment";

    private static final String ARG_PHOTO_ASSET_PATH = "photo_asset_path";
    private static final String ARG_LIBRARY_NAME = "library_name";

    private ImageView mLibraryImageView;
    private TextView mLibraryNameTextView;

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
        mLibraryImageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mLibraryImageView.setImageBitmap(ImageUtils
                        .decodeSampledBitmapFromAssets(getContext().getAssets(),
                        getArguments().getString(ARG_PHOTO_ASSET_PATH),
                                mLibraryImageView.getWidth(), mLibraryImageView.getHeight()));
            }
        });

        return v;
    }
}
