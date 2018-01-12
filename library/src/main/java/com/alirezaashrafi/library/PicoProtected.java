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
        this.picoLoaded = new PicoLoaded(this);
        this.picoDownloader = new PicoDownloader(this);
        this.picoBitmap = new PicoBitmap(this);
        this.picoCallback = new PicoCallback(this);
        this.picoScale = new Scale(this);
    }

    ImageView.ScaleType scaleType = null;
    Scale picoScale;

    PicoCallback picoCallback;
    PicoDownloader picoDownloader;
    PicoLoaded picoLoaded;
    PicoBitmap picoBitmap;


    Context context;
    boolean forceUpdate;

    List<ImageView> imageViews = new ArrayList<>();
    List<View> views = new ArrayList<>();


}
