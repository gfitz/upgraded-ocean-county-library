package com.sunlightsoftware.android.ocean_county_library.modules.library_website;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.sunlightsoftware.android.ocean_county_library.R;

/**
 * Created by Garrett on 1/5/2017.
 *
 * This fragment will be displayed when the Search the Catalog Button or My Account Button is
 * pressed.
 */

public class LibraryWebsiteFragment extends Fragment {
    private static final String WEBSITE_KEY = "website";

    private WebView mWebView;
    private ProgressBar mProgressBar;

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

        mProgressBar = (ProgressBar) view.findViewById(R.id.fragment_library_website_progress_bar);
        mProgressBar.setMax(100);

        mWebView = (WebView)  view.findViewById(R.id.fragment_library_website_web_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100)
                    mProgressBar.setVisibility(View.GONE);
                else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                AppCompatActivity activity = (AppCompatActivity) getActivity();
                activity.getSupportActionBar().setSubtitle(title);
            }
        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        && i == KeyEvent.KEYCODE_BACK
                        && mWebView.canGoBack()) {

                    mWebView.goBack();
                    return true;
                }

                return false;
            }
        });

        mWebView.loadUrl(getArguments().getParcelable(WEBSITE_KEY).toString());
        return view;
    }


}
