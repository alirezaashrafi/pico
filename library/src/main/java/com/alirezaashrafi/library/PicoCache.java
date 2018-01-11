package com.alirezaashrafi.library;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class PicoCache extends PicoInto {

    PicoCache(PicoProtected picoProtected) {
        super(picoProtected);
    }

    PicoInto into(){
        return core().into;
    }
    public PicoInto smartCache(){

        return into();
    }

}
