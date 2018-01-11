package com.alirezaashrafi.library;

import android.widget.ImageView;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class PicoScaleType extends PicoCore {

    PicoScaleType(PicoProtected picoProtected) {
        super(picoProtected);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        core().scaleType = scaleType;
    }

}

