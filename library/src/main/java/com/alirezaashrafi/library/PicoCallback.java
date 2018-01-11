package com.alirezaashrafi.library;

import com.alirezaashrafi.library.interfaces.OnError;
import com.alirezaashrafi.library.interfaces.OnLog;
import com.alirezaashrafi.library.public_class.PicoError;
import com.alirezaashrafi.library.public_class.PicoLog;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

 class PicoCallback extends PicoCore{

    PicoCallback(PicoProtected picoProtected) {
        super(picoProtected);
    }
    OnError onError;
    OnLog onLog;

    void onError(PicoError error){
        if (onError!=null){
            onError.error(error);
        }
    }

     void log(PicoLog log){
        if (onLog!=null){
            onLog.onlog(log);
        }
    }

}
