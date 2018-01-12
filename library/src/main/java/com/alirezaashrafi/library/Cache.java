package com.alirezaashrafi.library;

import java.io.File;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class Cache extends Into {

    Cache(PicoProtected picoProtected) {
        super(picoProtected);
    }
    String file_name = "";
    boolean smartCache = false;
    boolean customCache = false;
    boolean useformat = false;


    public Into smartCache(){
        smartCache = true;
        return this;
    }


    public Into customCache(File Dir,String name,boolean useformat){
        customCache = true;
        this.useformat=useformat;
        file_name = name;
        return this;
    }

}
