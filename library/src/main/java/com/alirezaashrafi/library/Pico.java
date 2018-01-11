package com.alirezaashrafi.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * pico Created by AlirezaAshrafi on 1/7/2018.
 */

public class Pico {

    private PicoProtected picoProtected;

    private PicoScale getScale() {
        return this.picoProtected.picoScale;
    }

    public static Pico with(Context context) {
        Pico pico = new Pico();
        pico.picoProtected = new PicoProtected(context);

        return pico;
    }

    public final PicoScale from(String url) {
        try {
            this.from(new URL(url));
        } catch (MalformedURLException var3) {
            this.from((URL) null);
        }

        return this.getScale();
    }


    public final PicoScale from(URL url) {
        if (url == null) {
            throw (new IllegalArgumentException("The url is not valid"));
        } else {
            this.picobitmap().bitmap(url);
            return this.getScale();
        }
    }


    public final PicoScale from(Drawable drawable) {
        if (drawable == null) {
            throw (new IllegalArgumentException("Drawable should not be null"));
        } else {
            this.picobitmap().bitmap(drawable);
            return this.getScale();
        }
    }


    public final PicoScale from(Bitmap bitmap) {
        if (bitmap == null) {
            throw (new IllegalArgumentException("picobitmap should not be null"));
        } else {
            this.picobitmap().bitmap(bitmap);
            return this.getScale();
        }
    }


    public final PicoScale from(Uri uri) {
        if (uri == null) {
            throw (new IllegalArgumentException("uri should not be null"));
        } else {
            this.picobitmap().bitmap(uri);
            return this.getScale();
        }
    }


    public final PicoScale from(File file) {
        if (file == null) {
            throw (new IllegalArgumentException("file should not be null"));
        } else {
            this.picobitmap().bitmap(file);
            return this.getScale();
        }
    }


    private final PicoBitmap picobitmap() {
        return picoProtected.picoBitmap;
    }


}
