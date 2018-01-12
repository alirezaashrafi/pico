package com.alirezaashrafi.library;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class Scale extends Config {

    int width = -1;
    int height = -1;
    float scale = -1;
    int max = -1;


    boolean setMaxWidthHeight = false;
    boolean setHeight = false;
    boolean setWidth = false;
    boolean setMinWidth = false;
    boolean setMinHeight = false;
    boolean setWidthHeight = false;
    boolean setScalePercent = false;
    boolean setMaxWidth = false;
    boolean setMaxHeight = false;
    boolean setScale = false;
    boolean setSmartScale = false;


    Scale(PicoProtected picoProtected) {
        super(picoProtected);
    }


    //done
    public Config setScalePercent(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("The Scale Percent should be greater than zero and less than 100");
        } else {
            setScalePercent = true;
            scale = (float)percent/(float)100;
        }
        return this;
    }
    //done
    public Config setScale(double scale) {
        if (scale < 0 || scale > 1) {
            throw new IllegalArgumentException("The Scale should be greater than zero and less than 1");
        } else {
            setScale = true;
            this.scale = (float)scale;
        }
        return this;
    }

    //done
    public Config setWidthHeight(int width, int height) {
        this.width = width;
        this.height = height;
        setWidthHeight = true;
        return this;
    }


    //done
    public Config setWidth(int width) {
        setWidth = true;
        this.width = width;
        return this;
    }


    //done
    public Config setHeight(int height) {
        setHeight = true;
        this.height = height;
        return this;
    }


    //done
    public Config smartScale() {
        setSmartScale = true;
        return this;
    }


    public Config setMaxWidthHeight(int max) {
        setMaxWidthHeight = true;
        this.max = max;
        return this;
    }


    private Config setMinWidth(int width) {
        setMinWidth = true;
        this.width = width;
        return this;
    }


    private Config setMinHeight(int height) {
        setMinHeight = true;
        this.height = height;
        return this;
    }

    private Config setMaxWidth(int width) {
        setMaxWidth = true;
        this.width = width;
        return this;
    }


    private Config setMaxHeight(int height) {
        setMaxHeight = true;
        this.height = height;
        return this;
    }




}
