package com.alirezaashrafi.library;

 enum CompressFormat {
        JPEG    (0),
        PNG     (1),
        WEBP    (2),
        NONE    (3);

        CompressFormat(int format) {
            this.format = format;
        }
        final int format;
    }