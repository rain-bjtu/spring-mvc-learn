package com.rain.learn.sms.util;

import java.util.Collection;
import java.util.Map;

public abstract class CollectionUtil {

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> boolean isEqual(Collection<T> a, Collection<T> b) {
        if (a == null || b == null) {
            return false;
        }
        return a.containsAll(b) && b.containsAll(a);
    }
}
