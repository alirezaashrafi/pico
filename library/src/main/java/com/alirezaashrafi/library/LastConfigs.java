package com.alirezaashrafi.library;

import android.widget.ImageView;

import com.alirezaashrafi.library.interfaces.OnComplete;
import com.alirezaashrafi.library.interfaces.OnError;
import com.alirezaashrafi.library.interfaces.OnLog;
import com.alirezaashrafi.library.interfaces.OnProgress;

import java.util.ArrayList;
import java.util.List;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class LastConfigs extends PicoCore {

    LastConfigs(PicoProtected picoProtected) {
        super(picoProtected);
    }

    public LastConfigs setScaleType(ImageView.ScaleType scaleType) {
        core().scaleType = scaleType;
        return this;
    }

    public LastConfigs setOnErrorListener(OnError onErrorListener) {
        core().picoCallback.onErrors.add(onErrorListener);
        return this;
    }

    public LastConfigs setonLogsListener(OnLog onLog) {
        core().picoCallback.onLogs.add(onLog);
        return this;
    }

    public LastConfigs setOnProgressListener(OnProgress onProgress) {
        core().picoCallback.onProgresses.add(onProgress);
        return this;
    }

    public LastConfigs setOnCompleteListener(OnComplete onComplete) {
        core().picoCallback.onCompletes.add(onComplete);
        return this;
    }

    public LastConfigs setPlaceHolder(){


        return this;
    }
}

