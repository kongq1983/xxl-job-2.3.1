package com.kq.xxljob.demo.util;

public class NumberUtil {


    /**
     * string to long
     * @param id
     * @return
     */
    public static Long toLong(String id) {


        try {
            return Long.valueOf(id);
        }catch (NumberFormatException e) {
            return 0L;
        }

    }

}
