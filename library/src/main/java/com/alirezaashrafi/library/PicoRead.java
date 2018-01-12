package com.alirezaashrafi.library;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.File;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

 class PicoRead {



     interface OnImageReadListener {
        void onImageRead(Bitmap bitmap);

        void onReadFailed();
    }
    @SuppressLint("StaticFieldLeak")
    void readFromDiskAsync(File imageFile, final OnImageReadListener listener) {
        new AsyncTask<String, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(String... params) {
                return BitmapFactory.decodeFile(params[0]);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null)
                    listener.onImageRead(bitmap);
                else
                    listener.onReadFailed();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, imageFile.getAbsolutePath());
    }
}
