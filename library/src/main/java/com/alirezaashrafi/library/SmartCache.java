package com.alirezaashrafi.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class SmartCache {


    @SuppressLint("StaticFieldLeak")
    static void save(final Context context, final Bitmap data, final String name) throws IOException {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                File cacheDir = context.getCacheDir();
                long size = getDirSize(cacheDir);
                long newSize = sizeOf(data) + size;

                if (newSize > PicoConfigs.maxCacheDir) {
                    cleanDir(cacheDir, newSize - PicoConfigs.maxCacheDir);
                }


                File file = new File(cacheDir, name);
                FileOutputStream os = null;
                try {
                    os = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                data.compress(Bitmap.CompressFormat.PNG,80,os);
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    static int sizeOf(Bitmap data) {
        //return data.getRowBytes() * data.getHeight();
        return data.getByteCount();
    }

    static Bitmap load(Context context, String name) throws IOException {

        File cacheDir = context.getCacheDir();
        File file = new File(cacheDir, name);

        if (!file.exists()) {
            // Data doesn't exist
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return  BitmapFactory.decodeFile(file.getPath(), options);
    }

    static void cleanDir(File dir, long bytes) {
        long bytesDeleted = 0;
        File[] files = dir.listFiles();

        for (File file : files) {
            bytesDeleted += file.length();
            file.delete();

            if (bytesDeleted >= bytes) {
                break;
            }
        }
    }

    static long getDirSize(File dir) {
        long size = 0;
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                size += file.length();
            }
        }

        return size;
    }
}