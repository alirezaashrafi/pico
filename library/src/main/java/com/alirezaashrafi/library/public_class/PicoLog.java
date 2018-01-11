package com.alirezaashrafi.library.public_class;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class PicoLog extends Throwable{

    private int errorCode;
    public static final int ERROR_IS_DIRECTORY = 4;


    public PicoLog(String message) {
        super(message);
    }

    public PicoLog(Throwable error) {
        super(error.getMessage(), error.getCause());
        this.setStackTrace(error.getStackTrace());
    }

    public PicoLog setErrorCode(int code) {
        this.errorCode = code;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
