package com.ffl.baselib.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class GsonHelper {

    private final Gson mGson;

    //单例模式
    private static final class Holder {
        private static final GsonHelper INSTANCE = new GsonHelper();
    }

    public static GsonHelper getInstance() {
        return Holder.INSTANCE;
    }

    public GsonHelper() {
        mGson = new GsonBuilder().disableHtmlEscaping().create();
    }

    public Gson getGson() {
        return mGson;
    }

    /**
     * 转json字符串
     *
     * @param o
     * @return
     */
    public String toJsonStr(Object o) {
        return mGson.toJson(o);
    }

    /**
     * json字符串转对象
     *
     * @param json
     * @param classOfT
     * @param <T>
     * @return
     * @throws JsonSyntaxException
     */
    public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException{
        return mGson.fromJson(json, classOfT);
    }
}
