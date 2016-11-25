package com.rain.learn.sms.util;

public abstract class StringUtil {

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
}
