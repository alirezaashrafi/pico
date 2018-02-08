package com.alirezaashrafi.library;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import java.net.URL;
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
        this.onlineLoad1 = new OnlineLoad1(this);
    }

    ImageView.ScaleType scaleType = null;
    OnlineLoad1 onlineLoad1;

    PicoCallback picoCallback;
    PicoDownloader picoDownloader;
    PicoLoaded picoLoaded;
    PicoBitmap picoBitmap;


    Context context;
    boolean forceUpdate;

    List<ImageView> imageViews = new ArrayList<>();
    List<View> views = new ArrayList<>();

    URL url;

}
