package com.alirezaashrafi.library;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.alirezaashrafi.library.public_class.PicoError;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

 class PicoWrite extends PicoCore {

    PicoWrite(PicoProtected picoProtected) {
        super(picoProtected);
    }


    @SuppressLint("StaticFieldLeak")
     void write(final File imageFile,
                      final Bitmap image,
                      final Bitmap.CompressFormat format,
                      boolean shouldOverwrite, final int quality) {

        if (imageFile.isDirectory()) {
            core().picoCallback.error(new PicoError("the specified path points to a directory, " +
                    "should be a file").setErrorCode(PicoError.ERROR_IS_DIRECTORY));
            return;
        }

        if (imageFile.exists()) {
            if (!shouldOverwrite) {
                core().picoCallback.error(new PicoError("file already exists, " +
                        "write operation cancelled").setErrorCode(PicoError.ERROR_FILE_EXISTS));
                return;
            } else if (!imageFile.delete()) {
                core().picoCallback.error(new PicoError("could not delete existing file, " +
                        "most likely the write permission was denied")
                        .setErrorCode(PicoError.ERROR_PERMISSION_DENIED));
                return;
            }
        }

        File parent = imageFile.getParentFile();
        if (!parent.exists() && !parent.mkdirs()) {
            core().picoCallback.error(new PicoError("could not create parent directory")
                    .setErrorCode(PicoError.ERROR_PERMISSION_DENIED));
            return;
        }

        try {
            if (!imageFile.createNewFile()) {
                core().picoCallback.error(new PicoError("could not create file")
                        .setErrorCode(PicoError.ERROR_PERMISSION_DENIED));
                return;
            }
        } catch (IOException e) {
           
            core().picoCallback.error(new PicoError(e).setErrorCode(PicoError.ERROR_GENERAL_EXCEPTION));
            return;
        }

        new AsyncTask<Void, Void, Void>() {

            private PicoError error;

            @Override
            protected Void doInBackground(Void... params) {
                FileOutputStream fos = null;
                try {
                    fos = new FileOutputStream(imageFile);
                    image.compress(format, quality, fos);
                } catch (IOException e) {
                    error = new PicoError(e).setErrorCode(PicoError.ERROR_GENERAL_EXCEPTION);
                    this.cancel(true);
                } finally {
                    if (fos != null) {
                        try {
                            fos.flush();
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return null;
            }

            @Override
            protected void onCancelled() {
                core().picoCallback.error(error);
            }

            @Override
            protected void onPostExecute(Void result) {
                // TODO: 1/10/2018  
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
