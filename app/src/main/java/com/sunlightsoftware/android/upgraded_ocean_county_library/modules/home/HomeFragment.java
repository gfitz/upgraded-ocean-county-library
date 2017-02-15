package com.sunlightsoftware.android.upgraded_ocean_county_library.modules.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.sunlightsoftware.android.upgraded_ocean_county_library.Constant;
import com.sunlightsoftware.android.upgraded_ocean_county_library.R;
import com.sunlightsoftware.android.upgraded_ocean_county_library.components.utils.ImageUtils;
import com.sunlightsoftware.android.upgraded_ocean_county_library.components.view_components.homebutton.HomeButton;
import com.sunlightsoftware.android.upgraded_ocean_county_library.modules.library_locator.LibraryLocatorActivity;
import com.sunlightsoftware.android.upgraded_ocean_county_library.modules.library_website.LibraryWebsiteActivity;

import java.lang.ref.WeakReference;

/**
 * Created by Garrett on 1/4/2017.
 */

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private ImageView mBannerImageView;
    private TextView mBannerTextView;
    private HomeButton mMyAccountButton;
    private HomeButton mLibraryLocatorButton;
    private HomeButton mSearchTheCatalogButton;
    private InterstitialAd mInterstitialAd;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().hide();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        mBannerImageView = (ImageView) v.findViewById(R.id.home_banner_image_view);

        mBannerTextView = (TextView) v.findViewById(R.id.home_banner_text_view);
        mBannerTextView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), Constant.MONTSERRAT_FONT_REGULAR));

        mSearchTheCatalogButton = (HomeButton) v.findViewById(R.id.search_the_catalog_button);
        mSearchTheCatalogButton.setImageResource(R.drawable.searchthecatalog);
        mSearchTheCatalogButton.setText(R.string.search_the_catalog);
        mSearchTheCatalogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = LibraryWebsiteActivity.newIntent(getActivity(),
                        Constant.searchTheCatalogURL);
                startActivity(i);
            }
        });

        mMyAccountButton = (HomeButton) v.findViewById(R.id.my_account_button);
        mMyAccountButton.setImageResource(R.drawable.my_account);
        mMyAccountButton.setText(R.string.my_account);
        mMyAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = LibraryWebsiteActivity.newIntent(getActivity(),
                        Constant.myAccountURL);
                startActivity(i);
            }
        });

        mLibraryLocatorButton = (HomeButton) v.findViewById(R.id.library_locator_button);
        mLibraryLocatorButton.setImageResource(R.drawable.library_locator);
        mLibraryLocatorButton.setText(R.string.library_locator);
        mLibraryLocatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean loaded = mInterstitialAd.isLoaded();
                if (loaded) {
                    mInterstitialAd.show();
                } else {
                    Intent i = LibraryLocatorActivity.newIntent(getActivity());
                    startActivity(i);
                }
            }
        });

        initializeInterstitialAd();

        return v;
    }

    // Initializes the Intersitial Ad
    private void initializeInterstitialAd() {
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-7195172863816354/7807319023");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitialAd();
                Intent i = LibraryLocatorActivity.newIntent(getActivity());
                startActivity(i);
            }
        });

        requestNewInterstitialAd();
    }

    //Loads a brand new ad into mIntersitialAd
    private void requestNewInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice(Settings.Secure.getString(getContext().getContentResolver(),
                        Settings.Secure.ANDROID_ID))
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

    class LoadBannerImageTask extends AsyncTask<Integer, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewWeakReference;
        private int data = 0;
        private int reqWidth;
        private int reqHeight;

        public LoadBannerImageTask(ImageView imageView, int reqWidth, int reqHeight) {
            imageViewWeakReference = new WeakReference<ImageView>(imageView);
            this.reqWidth = reqWidth;
            this.reqHeight = reqHeight;
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {
            data = integers[0];
            return ImageUtils.decodeSampledBitmapFromResource(getResources(), data,
                    reqWidth, reqHeight);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageViewWeakReference != null && bitmap != null) {
                final ImageView imageView = imageViewWeakReference.get();
                if (imageView != null)
                    imageView.setImageBitmap(bitmap);
            }

        }
    }


}
