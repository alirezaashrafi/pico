package com.alirezaashrafi.library;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.alirezaashrafi.library.public_class.PicoError;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by AlirezaAshrafi on 1/5/2018.
 */

final class PicoDownloader extends PicoCore {


    PicoDownloader(PicoProtected picoProtected) {
        super(picoProtected);
    }

    private final String TAG = this.getClass().getSimpleName();

    @SuppressLint("StaticFieldLeak")
    void download(final URL url) {



        new AsyncTask<Void, Integer, Bitmap>() {

            private PicoError error;

            @Override
            protected void onPreExecute() {
                Log.d(TAG, "starting download");
            }

            @Override
            protected void onCancelled() {
                core().picoCallback.error(error);
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                core().picoCallback.progess(values[0]);
            }

            @Override
            protected Bitmap doInBackground(Void... params) {
                Bitmap bitmap = null;
                HttpURLConnection connection = null;
                InputStream is = null;
                ByteArrayOutputStream out = null;
                try {
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    final int length = connection.getContentLength();
                    if (length <= 0) {
                        error = new PicoError("Invalid content length. The URL is probably not pointing to a file")
                                .setErrorCode(PicoError.ERROR_INVALID_FILE);
                        this.cancel(true);
                    }
                    is = new BufferedInputStream(connection.getInputStream(), 8192);
                    out = new ByteArrayOutputStream();
                    byte bytes[] = new byte[8192];
                    int count;
                    long read = 0;
                    while ((count = is.read(bytes)) != -1) {
                        read += count;
                        out.write(bytes, 0, count);
                        publishProgress((int) ((read * 100) / length));
                    }
                    bitmap = BitmapFactory.decodeByteArray(out.toByteArray(), 0, out.size());
                } catch (Throwable e) {
                    if (!this.isCancelled()) {
                        error = new PicoError(e).setErrorCode(PicoError.ERROR_GENERAL_EXCEPTION);
                        this.cancel(true);
                    }
                } finally {
                    try {
                        if (connection != null)
                            connection.disconnect();
                        if (out != null) {
                            out.flush();
                            out.close();
                        }
                        if (is != null)
                            is.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap result) {
                if (result == null) {
                    Log.e(TAG, "factory returned a null result");
                    
                    core().picoCallback.error(new PicoError("downloaded file could not be decoded as bitmap")
                            .setErrorCode(PicoError.ERROR_DECODE_FAILED));
                } else {
                    Log.d(TAG, "download complete, " + result.getByteCount() +
                            " bytes transferred");
                    core().picoLoaded.setBitmap(result);
                }
                System.gc();
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

}
