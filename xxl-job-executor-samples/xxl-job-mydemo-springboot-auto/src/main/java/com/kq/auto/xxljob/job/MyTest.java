package com.kq.auto.xxljob.job;

import java.util.Date;

/**
 * @author: kq
 * @date: 2023-04-28 16:59:33
 * @since: 1.0.0
 * @description:
 */
public class MyTest {

    public static void main(String[] args) {

        long nowTime = System.currentTimeMillis();
        long afterTime = nowTime + 1000*60*60*24; // add one day

        System.out.println(new Date(nowTime));
        System.out.println(new Date(afterTime));

    }

}
