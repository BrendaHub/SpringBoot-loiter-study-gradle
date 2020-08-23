package io.netty.example.study.util;

import com.google.gson.Gson;

public class JsonUtil {
    private static final Gson GSON = new Gson();

    private JsonUtil() {
        // no instance
    }
    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        // 将json串反序列化成class实例
        return GSON.fromJson(jsonStr, clazz);
    }

    public static String toJson(Object object) {
        return GSON.toJson(object);
    }
}
