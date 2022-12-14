package com.kq.xxljob.mydemo.test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author kq
 * @date 2022-12-14 10:17
 * @since 2020-0630
 */
public class MyTest {

    public static void main(String[] args) throws Exception{

        int i= 0;
        System.out.println("i="+i+" ,  "+new Date());
        while (i<1000){
            i++;
            System.out.println(5000 - System.currentTimeMillis()%1000); // sleep 4s - 5s之间
            TimeUnit.MILLISECONDS.sleep(5000 - System.currentTimeMillis()%1000 );
            System.out.println("i="+i+" ,  "+new Date());
        }

//        i=0 ,  Wed Dec 14 10:19:24 CST 2022
//        i=0 ,  Wed Dec 14 10:19:29 CST 2022
//        i=0 ,  Wed Dec 14 10:19:34 CST 2022
//        i=0 ,  Wed Dec 14 10:19:39 CST 2022
//        i=0 ,  Wed Dec 14 10:19:44 CST 2022

    }

}
