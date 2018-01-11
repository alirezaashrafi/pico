package com.alirezaashrafi.library;

import android.graphics.Color;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class TestClass extends PicoCacheConfig {
    TestClass(PicoProtected picoProtected) {
        super(picoProtected);
    }


    public TestClass setBlur(int blurRadius) {
        core().picoLoaded.blurRadius = blurRadius;
        return this;
    }

    public TestClass setRotate(float rotate) {
        core().picoLoaded.rotate = rotate;
        return this;
    }

    public TestClass setColorFilter(int color) {
        core().picoLoaded.color = color;
        return this;
    }

    public TestClass setColorFilter(String color) {
        core().picoLoaded.color = Color.parseColor(color);
        return this;
    }


}
