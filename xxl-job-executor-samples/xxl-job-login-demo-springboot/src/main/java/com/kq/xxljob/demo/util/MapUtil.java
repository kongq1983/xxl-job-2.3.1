package com.kq.xxljob.demo.util;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtil {


    public static MultiValueMap<String, Object> mapToMultiValueMap(Map<String,Object> map) {


        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();

        if(map==null || map.size()==0) {
            return multiValueMap;
        }

        for(Map.Entry<String,Object> kv : map.entrySet()) {

            if(kv.getValue()!=null) {
                multiValueMap.put(kv.getKey(), valueToListValue(kv.getValue()));
            }

        }

        return multiValueMap;

    }

    public static List<Object> valueToListValue(Object value) {
        List<Object> list = new ArrayList<>();

        list.add(value);

        return list;

    }

}
