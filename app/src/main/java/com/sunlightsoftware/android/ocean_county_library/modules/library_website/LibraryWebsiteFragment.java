package com.sunlightsoftware.android.ocean_county_library.modules.library_website;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunlightsoftware.android.ocean_county_library.R;

/**
 * Created by Garrett on 1/5/2017.
 *
 * This fragment will be displayed when
 */

public class LibraryWebsiteFragment extends Fragment {
    private static final String WEBSITE_KEY = "website";

    public static LibraryWebsiteFragment newInstance(Uri website) {
        Bundle args = new Bundle();
        args.putParcelable(WEBSITE_KEY, website);

        LibraryWebsiteFragment fragment = new LibraryWebsiteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_library_website, container, false);
        return view;
    }
}
