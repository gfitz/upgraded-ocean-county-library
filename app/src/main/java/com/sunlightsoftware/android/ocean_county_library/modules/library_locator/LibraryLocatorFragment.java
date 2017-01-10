package com.sunlightsoftware.android.ocean_county_library.modules.library_locator;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunlightsoftware.android.ocean_county_library.R;
import com.sunlightsoftware.android.ocean_county_library.components.manager.*;
import com.sunlightsoftware.android.ocean_county_library.components.utils.AsyncDrawable;
import com.sunlightsoftware.android.ocean_county_library.components.utils.BitmapWorkerTask;
import com.sunlightsoftware.android.ocean_county_library.components.utils.ImageUtils;
import com.sunlightsoftware.android.ocean_county_library.models.Library;

import java.util.List;

/**
 * Created by Garrett on 1/7/2017.
 */

public class LibraryLocatorFragment extends Fragment {

    private RecyclerView mLibraryRecyclerView;
    private LibraryManager mLibraryManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLibraryManager = new LibraryManager(getActivity());

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_library_list, container, false);

        mLibraryRecyclerView = (RecyclerView) v.findViewById(R.id.library_recycler_view);
        mLibraryRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLibraryRecyclerView.setAdapter(new LibraryAdapter(mLibraryManager.getLibraries()));
        return v;
    }

    private class LibraryHolder extends RecyclerView.ViewHolder {

        private ImageView mLibraryImageView;
        private TextView mNameTextView;

        public LibraryHolder(LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.library_list_item, container, false));

            mLibraryImageView = (ImageView) itemView.findViewById(R.id.library_list_item_image_view);
            mNameTextView = (TextView) itemView.findViewById(R.id.library_list_item_text_view);
        }

        public void bindLibrary(final Library library) {
            mNameTextView.setText(library.getName());
            loadBitmap(library.getAssetPath(), mLibraryImageView);
        }

        private void loadBitmap(String assetPath, ImageView imageView) {
            if (cancelPotentialWork(assetPath, imageView)) {
                Point size = new Point();
                getActivity().getWindowManager().getDefaultDisplay().getSize(size);

                BitmapWorkerTask bitmapWorkerTask = new BitmapWorkerTask(imageView,
                        getContext().getAssets(),
                        size.x,
                        size.y);
                final AsyncDrawable asyncDrawable = new AsyncDrawable(bitmapWorkerTask);
                imageView.setImageDrawable(asyncDrawable);

                bitmapWorkerTask.execute(assetPath);
            }

        }

        private  boolean cancelPotentialWork(String assetPath, ImageView imageView) {
            final BitmapWorkerTask bitmapWorkerTask = ImageUtils.getBitmapWorkerTask(imageView);

            if (bitmapWorkerTask != null) {
                final String bitmapAssetPath = bitmapWorkerTask.assetPath;

                if (bitmapAssetPath == null || !bitmapAssetPath.equals(assetPath)) {
                    bitmapWorkerTask.cancel(true);
                } else {
                    return false;
                }
            }

            return true;
        }


    }

    private class LibraryAdapter extends RecyclerView.Adapter<LibraryHolder> {
        private List<Library> mLibraries;

        public LibraryAdapter(List<Library> libraries) {
            mLibraries = libraries;
        }

        @Override
        public LibraryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new LibraryHolder(inflater, parent);
        }

        @Override
        public void onBindViewHolder(LibraryHolder holder, int position) {
            Library library = mLibraries.get(position);
            holder.bindLibrary(library);

        }

        @Override
        public int getItemCount() {
            return mLibraries.size();
        }
    }
}
