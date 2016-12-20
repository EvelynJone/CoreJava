//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.corejava.httpUtil;

import com.fasterxml.jackson.databind.JavaType;

public class JsonUtil {
    private static final JsonMapper mapper = JsonMapper.nonNullMapper();

    public JsonUtil() {
    }

    public static <T> T toObject(String json, Class<T> valueType) {
        return mapper.fromJson(json, valueType);
    }

    public static String toJson(Object obj) {
        return mapper.toJson(obj);
    }

    public static <T> T toObject(String json, Class<?> collectionClass, Class... elementClasses) {
        JavaType jt = mapper.createCollectionType(collectionClass, elementClasses);
        return mapper.fromJson(json, jt);
    }
}
