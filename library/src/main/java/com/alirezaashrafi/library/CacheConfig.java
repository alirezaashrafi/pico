package com.alirezaashrafi.library;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class CacheConfig extends Cache {

    CacheConfig(PicoProtected picoProtected) {
        super(picoProtected);
    }



    public Cache setForceUpdateCache(boolean force){
        core().forceUpdate = force;
        return this;
    }

    public boolean isForceUpdateCache(){
        return core().forceUpdate;
    }


}

