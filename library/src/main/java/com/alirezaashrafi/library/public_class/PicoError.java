package com.alirezaashrafi.library.public_class;

/**
 * pico Created by AlirezaAshrafi on 1/10/2018.
 */

public class PicoError extends Throwable{

    private int errorCode;
    public static final int ERROR_GENERAL_EXCEPTION = -1;
    public static final int ERROR_INVALID_FILE = 0;
    public static final int ERROR_DECODE_FAILED = 1;
    public static final int ERROR_FILE_EXISTS = 2;
    public static final int ERROR_PERMISSION_DENIED = 3;
    public static final int ERROR_IS_DIRECTORY = 4;


    public PicoError(String message) {
        super(message);
    }

    public PicoError(Throwable error) {
        super(error.getMessage(), error.getCause());
        this.setStackTrace(error.getStackTrace());
    }

    public PicoError setErrorCode(int code) {
        this.errorCode = code;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
