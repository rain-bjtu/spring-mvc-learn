package com.rain.learn.sms.util;

public abstract class StringUtil {
    private static final int INFO_LENGTH = 100;

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isEmpty(String... strs) {
        for (String str : strs) {
            if (!isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean notEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean notEmpty(String... strs) {
        for (String str : strs) {
            if (isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean lengthValid(String str) {
        if (isEmpty(str) || str.length() > INFO_LENGTH) {
            return false;
        }
        return true;
    }

    public static boolean lengthValid(String... strs) {
        for (String str : strs) {
            if (isEmpty(str) || str.length() > INFO_LENGTH) {
                return false;
            }
        }
        return true;
    }
}
