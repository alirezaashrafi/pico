package com.alirezaashrafi.library;

import android.graphics.Bitmap;
import android.os.Handler;

import com.alirezaashrafi.library.interfaces.OnComplete;
import com.alirezaashrafi.library.interfaces.OnError;
import com.alirezaashrafi.library.interfaces.OnLog;
import com.alirezaashrafi.library.interfaces.OnProgress;
import com.alirezaashrafi.library.public_class.PicoError;
import com.alirezaashrafi.library.public_class.PicoLog;

import java.util.ArrayList;
import java.util.List;


/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

class PicoCallback extends PicoCore {

    PicoCallback(PicoProtected picoProtected) {
        super(picoProtected);
    }
    private Handler handler;

    List<OnError> onErrors = new ArrayList<>();
    List<OnLog> onLogs = new ArrayList<>();
    List<OnProgress> onProgresses = new ArrayList<>();
    List<OnComplete> onCompletes = new ArrayList<>();

    void error(final PicoError error) {
        for (final OnError onError : onErrors) {
            if (onError != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onError.error(error);

                    }
                });
            }
        }
    }

    void log(final PicoLog log) {
        for (final OnLog onLog : onLogs) {
            if (onLog != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onLog.onlog(log);

                    }
                });
            }
        }

    }


    private void runOnUiThread(Runnable r) {
        if (handler == null) {
            handler = new Handler(core().context.getMainLooper());
        }
        handler.post(r);

    }

    void progess(final int progress) {
        for (final OnProgress onProgress : onProgresses) {
            if (onProgress != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onProgress.progress(progress);
                    }
                });
            }
        }

    }

    void complete(final Bitmap complete) {
        for (final OnComplete onComplete : onCompletes) {
            if (onComplete != null) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onComplete.onComplete(complete);
                    }
                });
            }
        }

    }

}
