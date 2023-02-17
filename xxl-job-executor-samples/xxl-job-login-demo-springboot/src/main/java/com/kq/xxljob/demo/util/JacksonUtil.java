package com.kq.xxljob.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Map;

public class JacksonUtil {

    static ObjectMapper mapper = new ObjectMapper();


    public static Map<String, Object> object2Map(Object obj) throws JsonProcessingException {
        if(obj == null){
            return Collections.emptyMap();
        }

        Map map = mapper.readValue(mapper.writeValueAsString(obj), Map.class);

        return map;
    }

}
