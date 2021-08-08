package com.musinsa.urlshortening.utils;

import org.apache.commons.validator.routines.UrlValidator;

public class CommonUtils {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static final int BASE = ALPHABET.length();
    public static final int SHORT_KEY_LENGTH = 8;

    public static void validateUrl(final String url) {
        if (!new UrlValidator().isValid(url)) {
            throw new IllegalArgumentException("URL 형식이 아닙니다.");
        }
    }

    public static String convertShortKey(final String url) {
        return encodeBase62(hashUrl(url));
    }

    public static int hashUrl(final String url) {
        int hash = 0;
        if (hash == 0 && url.length() > 0) {
            char[] urlArr = url.toCharArray();

            for (int i = 0; i < urlArr.length; i++) {
                hash = (31 * hash) + urlArr[i];
            }
        }
        return hash;
    }

    private static String encodeBase62(int hash) {
        int value = hash;
        final StringBuffer sb = new StringBuffer();
        do {
            int i = value % BASE;
            sb.append(ALPHABET.charAt(i));
            value /= BASE;
        } while (value > 0);

        String result = sb.toString();
        validateKeyLength(result.length());
        return result;
    }

    private static void validateKeyLength(int length) {
        if (length > SHORT_KEY_LENGTH) {
            throw new IllegalArgumentException(
                "키의 길이가 " + SHORT_KEY_LENGTH + "자를 넘었습니다.");
        }
    }

}
