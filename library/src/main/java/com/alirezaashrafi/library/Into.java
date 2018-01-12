package com.alirezaashrafi.library;

import android.view.View;
import android.widget.ImageView;

import com.alirezaashrafi.library.interfaces.OnBitmapLoad;
import com.alirezaashrafi.library.interfaces.OnDrawableLoad;

/**
 * Created by AlirezaAshrafi on 1/5/2018.
 */

public class Into extends LastConfigs {
    Into(PicoProtected picoProtected) {
        super(picoProtected);
    }


    public Into into(ImageView imageView) {

        if (imageView == null) {
            throw new NullPointerException("imageView should not be null");
        } else {
            core().imageViews.add(imageView);
        }
        return this;
    }

    public Into into(View view) {
        if (view == null) {
            throw new NullPointerException("view should not be null");
        } else {
            core().views.add(view);
        }
        return this;
    }


    public Into into(OnDrawableLoad onDrawableLoaded) {
        if (onDrawableLoaded == null) {
            throw new NullPointerException("OnDrawableLoad should not be null");
        } else {
            core().picoLoaded.onDrawableLoads.add(onDrawableLoaded);
        }
        return this;
    }

    public Into into(OnBitmapLoad onBitmapLoaded) {
        if (onBitmapLoaded == null) {
            throw new NullPointerException("OnBitmapLoad should not be null");
        } else {
            core().picoLoaded.onBitmapLoadList.add(onBitmapLoaded);
        }

        return this;
    }

}
