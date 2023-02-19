package com.kq.xxljob.demo.util;


import java.util.Collections;;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {

    public static final Gson GSON = new Gson ();

    /**
     * 注意：  则int为0的 值 会变成0.0
     * @param obj
     * @return
     */
    public static Map<String, Object> object2Map(Object obj){
        if(obj == null){
            return Collections.emptyMap();
        }

        return GSON.fromJson(GSON.toJson(obj), Map.class);
    }

    public static Map<String, String> object2MapString(Object obj){
        if(obj == null){
            return Collections.emptyMap();
        }
        return GSON.fromJson(GSON.toJson(obj), Map.class);
    }


    public static Map<String, String> stringToMap(String json) {

        if(json==null) {
            return Collections.emptyMap();
        }

        Gson gson = new Gson();
        TypeToken<Map<String, String>> mapType = new TypeToken<Map<String, String>>(){};
        Map<String, String> resultMap = gson.fromJson(json, mapType.getType());

        return resultMap;

    }

}
