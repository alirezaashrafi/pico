package com.alirezaashrafi.library;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class PicoScale extends TestClass {

    protected int width = -1;
    protected int height = -1;
    protected float scale = -1;
    protected int max = -1;


    protected boolean setMaxWidthHeight = false;
    protected boolean setHeight = false;
    protected boolean setWidth = false;
    protected boolean setMinWidth = false;
    protected boolean setMinHeight = false;
    protected boolean setWidthHeight = false;
    protected boolean setScalePercent = false;
    protected boolean setMaxWidth = false;
    protected boolean setMaxHeight = false;
    protected boolean setScale = false;
    protected boolean setSmartScale = false;


    PicoScale(PicoProtected picoProtected) {
        super(picoProtected);
    }


    private TestClass testClass() {
        // TODO: 1/10/2018
        return core().testClass;
    }


    //done
    public TestClass setScalePercent(int percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("The Scale Percent should be greater than zero and less than 100");
        } else {
            setScalePercent = true;
            scale = (float)percent/(float)100;
        }
        return testClass();
    }
    //done
    public TestClass setScale(double scale) {
        if (scale < 0 || scale > 1) {
            throw new IllegalArgumentException("The Scale should be greater than zero and less than 1");
        } else {
            setScale = true;
            this.scale = (float)scale;
        }
        return testClass();
    }

    //done
    public TestClass setWidthHeight(int width, int height) {
        this.width = width;
        this.height = height;
        setWidthHeight = true;
        return testClass();
    }


    //done
    public TestClass setWidth(int width) {
        setWidth = true;
        this.width = width;
        return testClass();
    }


    //done
    public TestClass setHeight(int height) {
        setHeight = true;
        this.height = height;
        return testClass();
    }


    //done
    public TestClass smartScale() {
        setSmartScale = true;
        return testClass();
    }


    public TestClass setMaxWidthHeight(int max) {
        setMaxWidthHeight = true;
        this.max = max;
        return testClass();
    }


    private TestClass setMinWidth(int width) {
        setMinWidth = true;
        this.width = width;
        return testClass();
    }


    private TestClass setMinHeight(int height) {
        setMinHeight = true;
        this.height = height;
        return testClass();
    }

    private TestClass setMaxWidth(int width) {
        setMaxWidth = true;
        this.width = width;
        return testClass();
    }


    private TestClass setMaxHeight(int height) {
        setMaxHeight = true;
        this.height = height;
        return testClass();
    }



}
