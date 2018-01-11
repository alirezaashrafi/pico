package com.alirezaashrafi.library;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


 class Hash {
    private static final String TAG = "Hash";
    private final String MD5 = "MD5";
    private final String SHA1 = "SHA-1";
    private final String SHA256 = "SHA-256";
    private final String SHA384 = "SHA-384";
    private final String SHA512 = "SHA-512";
    private String key = "";
    private String HashType = MD5;
    private OnHash onHash;

    public Hash(String key, OnHash onHash) {
        this.key = key;
        this.onHash = onHash;
        run();
    }

    private void run() {
                try {
                    MessageDigest digest = MessageDigest.getInstance(HashType);
                    digest.update(key.getBytes());
                    byte messageDigest[] = digest.digest();

                    // Create Hex String
                    StringBuilder hexString = new StringBuilder();
                    for (byte aMessageDigest : messageDigest) {
                        String h = Integer.toHexString(0xFF & aMessageDigest);
                        while (h.length() < 2)
                            h = "0" + h;
                        hexString.append(h);
                    }

                    onHash.hash(hexString.toString());

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
    }

    public void md5() {
        HashType = MD5;
    }

    public void sha1() {
        HashType = SHA1;
    }

    public void sha256() {
        HashType = SHA256;
    }

    public void sha384() {
        HashType = SHA384;
    }

    public void sha512() {
        HashType = SHA512;
    }

    public interface OnHash {
        void hash(String code);
    }

}
