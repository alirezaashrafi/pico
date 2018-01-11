package com.alirezaashrafi.library;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import com.alirezaashrafi.library.interfaces.OnBitmapLoad;
import com.alirezaashrafi.library.interfaces.OnDrawableLoad;
import com.squareup.picasso.Picasso;

/**
 * Created by AlirezaAshrafi on 1/5/2018.
 */

public class PicoInto extends PicoScaleType {
    PicoInto(PicoProtected picoProtected) {
        super(picoProtected);
    }


    public PicoInto into(ImageView imageView) {

        if (imageView == null) {
            throw new NullPointerException("imageView should not be null");
        } else {
            core().imageViews.add(imageView);
        }
        return this;
    }

    public PicoInto into(View view) {
        if (view == null) {
            throw new NullPointerException("view should not be null");
        } else {
            core().views.add(view);
        }
        return this;
    }


    public PicoInto into(OnDrawableLoad onDrawableLoaded) {
        if (onDrawableLoaded == null) {
            throw new NullPointerException("OnDrawableLoad should not be null");
        } else {
            core().picoLoaded.onDrawableLoads.add(onDrawableLoaded);
        }
        return this;
    }

    public PicoInto into(OnBitmapLoad onBitmapLoaded) {
        if (onBitmapLoaded == null) {
            throw new NullPointerException("OnBitmapLoad should not be null");
        } else {
            core().picoLoaded.onBitmapLoadList.add(onBitmapLoaded);
        }

        return this;
    }

}
