package com.sunlightsoftware.android.ocean_county_library.modules.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunlightsoftware.android.ocean_county_library.R;
import com.sunlightsoftware.android.ocean_county_library.components.view_components.homebutton.HomeButton;

/**
 * Created by Garrett on 1/4/2017.
 */

public class HomeFragment extends Fragment {
    private HomeButton mMyAccountButton;
    private HomeButton mLibraryLocatorButton;
    private HomeButton mSearchTheCatalogButton;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        mSearchTheCatalogButton = (HomeButton) v.findViewById(R.id.search_the_catalog_button);
        mSearchTheCatalogButton.setImageResource(R.drawable.searchthecatalog);
        mSearchTheCatalogButton.setText(R.string.search_the_catalog);

        mMyAccountButton = (HomeButton) v.findViewById(R.id.my_account_button);
        mMyAccountButton.setImageResource(R.drawable.my_account);
        mMyAccountButton.setText(R.string.my_account);

        mLibraryLocatorButton = (HomeButton) v.findViewById(R.id.library_locator_button);
        mLibraryLocatorButton.setImageResource(R.drawable.library_locator);
        mLibraryLocatorButton.setText(R.string.library_locator);

        return v;
    }
}
