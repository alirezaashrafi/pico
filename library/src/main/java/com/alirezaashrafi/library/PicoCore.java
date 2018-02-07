package com.alirezaashrafi.library;

import android.content.Context;

/**
 * Created by AlirezaAshrafi on 1/5/2018.
 */

class PicoCore {

    private PicoProtected picoProtected;

    PicoCore(PicoProtected picoProtected) {
        this.picoProtected = picoProtected;
    }


    PicoProtected core() {
        return this.picoProtected;
    }

    Context context() {
        return picoProtected.context;
    }
}
