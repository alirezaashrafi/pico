package com.alirezaashrafi.library;

/**
 * pico Created by AlirezaAshrafi on 2/8/2018.
 */

public class PicoConfigs {

    protected static long maxCacheDir = 5242880L; //5 mg


    protected void setMaxCacheDir(long maxCacheDir) {
        PicoConfigs.maxCacheDir = maxCacheDir;
    }
}
