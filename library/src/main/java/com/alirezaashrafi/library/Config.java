package com.alirezaashrafi.library;

import android.graphics.Color;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class Config extends Into {
    Config(PicoProtected picoProtected) {
        super(picoProtected);
    }

    public Config setBlur(int blurRadius) {
        core().picoLoaded.blurRadius = blurRadius;

        return this;
    }

    public Config setRotate(float rotate) {
        core().picoLoaded.rotate = rotate;
        return this;
    }

    public Config setColorFilter(int color) {
        core().picoLoaded.color = color;
        return this;
    }

    public Config setColorFilter(String color) {
        core().picoLoaded.color = Color.parseColor(color);
        return this;
    }




}
