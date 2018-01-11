package com.alirezaashrafi.library;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlirezaAshrafi on 1/5/2018.
 */

final class PicoProtected {

    PicoProtected(Context context) {
        this.context = context;
        this.into = new PicoInto(this);
        this.picoLoaded = new PicoLoaded(this);
        this.picoDownloader = new PicoDownloader(this);
        this.picoBitmap = new PicoBitmap(this);
        this.picoCallback = new PicoCallback(this);
        this.picoCacheConfig = new PicoCacheConfig(this);
        this.picoCache = new PicoCache(this);
        this.testClass = new TestClass(this);
        this.picoScale = new PicoScale(this);
        this.picoScaleType = new PicoScaleType(this);
    }
    ImageView.ScaleType scaleType = null;
    PicoCache picoCache;
    PicoScale picoScale;
    TestClass testClass;
    PicoCacheConfig picoCacheConfig;
    PicoScaleType picoScaleType;

    PicoCallback picoCallback;
    PicoDownloader picoDownloader;
    PicoLoaded picoLoaded;
    PicoInto into;
    PicoBitmap picoBitmap;

    Context context;

    List<ImageView> imageViews = new ArrayList<>();
    List<View> views = new ArrayList<>();


}
