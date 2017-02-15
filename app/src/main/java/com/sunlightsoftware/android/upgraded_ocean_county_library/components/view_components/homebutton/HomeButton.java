package com.sunlightsoftware.android.upgraded_ocean_county_library.components.view_components.homebutton;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sunlightsoftware.android.upgraded_ocean_county_library.Constant;
import com.sunlightsoftware.android.upgraded_ocean_county_library.R;

/**
 * Created by Garrett on 1/4/2017.
 */

public class HomeButton extends RelativeLayout {

    private ImageView mHomeButtonIcon;
    private TextView mHomeButtonDescription;
    private Button mButton;

    public HomeButton(Context context) {
        super(context);
        init();
    }

    public HomeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HomeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.home_button, this);

        mHomeButtonIcon = (ImageView) findViewById(R.id.home_button_icon);
        mHomeButtonDescription = (TextView) findViewById(R.id.home_button_description);
        mHomeButtonDescription.setTypeface(Typeface
                .createFromAsset(getContext().getAssets(), Constant.MONTSERRAT_FONT_REGULAR));
        mButton = (Button) findViewById(R.id.home_button);
    }

    public void setText(int stringResourceId) {
        mHomeButtonDescription.setText(stringResourceId);
    }

    public void setImageResource(int imageResource) {
        mHomeButtonIcon.setImageResource(imageResource);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
       mButton.setOnClickListener(l);
    }
}
