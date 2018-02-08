package com.alirezaashrafi.library;

import java.io.File;

/**
 * pico Created by AlirezaAshrafi on 2/8/2018.
 */

public class OnlineLoad1 extends Scale {
    OnlineLoad1(PicoProtected picoProtected) {
        super(picoProtected);
    }

    /////////////////1

    protected CompressFormat compressFormat;
    protected int quality;
    protected String name = "";

    protected boolean smartCache = false;
    protected boolean superCache = false;
    protected boolean easyCache = false;
    protected boolean customCache = false;

    protected File dir;

    public Scale smartCache() {
        this.smartCache = true;
        return this;
    }

    private void setDir(File dir) {
        if (dir == null) {
            throw new IllegalArgumentException("dir must be not null");
        } else {
            this.dir = dir;
        }
    }

    public Scale advanceCache(File dir, String name, CompressFormat compressFormat, int quality) {

        setDir(dir);

        if (quality < 0 || quality > 100) {
            throw new IllegalArgumentException("quality must be 0..100");
        }
        this.quality = quality;
        this.compressFormat = compressFormat;
        this.customCache = true;
        this.name = name;
        return this;
    }

}
