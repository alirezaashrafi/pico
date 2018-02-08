package com.alirezaashrafi.library;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.alirezaashrafi.library.public_class.PicoLog;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by AlirezaAshrafi on 1/5/2018.
 */
@SuppressLint("StaticFieldLeak")
class PicoBitmap extends PicoCore {

    PicoBitmap(PicoProtected picoProtected) {
        super(picoProtected);
    }

    void bitmap(final Uri uri) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                load(BitmapFactory.decodeFile(uri.getPath()));

                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    void bitmap(final Drawable drawable) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

                Bitmap bitmap = null;

                if (drawable instanceof BitmapDrawable) {
                    BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                    if (bitmapDrawable.getBitmap() != null) {
                        load(bitmapDrawable.getBitmap());
                        cancel(true);
                    }
                }

                if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
                    bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
                } else {
                    bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                }

                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                load(bitmap);

                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);




    }


    void bitmap(final File file) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {

                if (file.exists()) {
                    BitmapFactory.Options options = new BitmapFactory.Options();

                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    load(BitmapFactory.decodeFile(file.getPath(), options));
                } else {

                    core().picoCallback.log(new PicoLog("file not exists"));
                    // TODO: 1/10/2018
                }

                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);


    }

    @SuppressLint("StaticFieldLeak")
    void bitmap(final Bitmap bitmap) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                load(bitmap);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private final String TAG = this.getClass().getName();


    void bitmap(final URL url) {


        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Log.i(TAG, "doInBackground: "+url.toString());

                new Hash(core().url.toString(), new Hash.OnHash() {
                    @Override
                    public void hash(String code) {
                        try {


                            Bitmap bitmap  = SmartCache.load(core().context,code);
                            if (bitmap!=null){
                                bitmap(SmartCache.load(core().context,code));
                            }else {
                                core().picoDownloader.download(url);

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });

                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);


    }

    private void load(Bitmap bitmap) {
        core().picoLoaded.setBitmap(bitmap);
    }
}
