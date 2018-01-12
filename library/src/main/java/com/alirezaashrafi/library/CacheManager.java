package com.alirezaashrafi.library;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

 class CacheManager {

    private  final long MAX_SIZE = 5242880L; // 5MB


    public  void cacheData(Context context, byte[] data, String name) throws IOException {

        File cacheDir = context.getCacheDir();
        long size = getDirSize(cacheDir);
        long newSize = data.length + size;

        if (newSize > MAX_SIZE) {
            cleanDir(cacheDir, newSize - MAX_SIZE);
        }

        File file = new File(cacheDir, name);
        FileOutputStream os = new FileOutputStream(file);
        try {
            os.write(data);
        }
        finally {
            os.flush();
            os.close();
        }
    }

    public  byte[] retrieveData(Context context, String name) throws IOException {

        File cacheDir = context.getCacheDir();
        File file = new File(cacheDir, name);

        if (!file.exists()) {
            // Data doesn't exist
            return null;
        }

        byte[] data = new byte[(int) file.length()];
        FileInputStream is = new FileInputStream(file);
        try {
            is.read(data);
        }
        finally {
            is.close();
        }

        return data;
    }

    private  void cleanDir(File dir, long bytes) {

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

    private  long getDirSize(File dir) {

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