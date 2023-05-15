import java.util.Calendar;
import java.util.Date;

/**
 * @author: kq
 * @date: 2023-05-10 16:12:37
 * @since: 1.0.0
 * @description:
 */
public class DateTest {


    public static void main(String[] args) {

        test();
        dayOfWeek();

    }

    public static void dayOfWeek(){


        Calendar itemDay = Calendar.getInstance();

        System.out.println(itemDay.getTime());

        System.out.println(itemDay.get(Calendar.DAY_OF_WEEK));
        // month: 4 : 5月
        itemDay.set(2023,4,14);
        System.out.println(itemDay.get(Calendar.DAY_OF_WEEK));

        System.out.println(itemDay.getTime());

        System.out.println((itemDay.getFirstDayOfWeek() == Calendar.SUNDAY));


//        if(isFirstSunday){
//            weekDay = weekDay - 1;
//            if(weekDay == 0){
//                weekDay = 7;
//            }
//        }

    }

    private static void test(){

        for (int i = 0; i < 3; i++) {

            // today
            Calendar itemDay = Calendar.getInstance();
            itemDay.add(Calendar.DAY_OF_MONTH, -i); // todo 今天、昨天、前天
            itemDay.set(Calendar.HOUR_OF_DAY, 0);
            itemDay.set(Calendar.MINUTE, 0);
            itemDay.set(Calendar.SECOND, 0);
            itemDay.set(Calendar.MILLISECOND, 0);

            Date todayFrom = itemDay.getTime(); // todo 改天的开始时间(某天第1毫秒)
            System.out.println(i+",todayFrom="+todayFrom);

            itemDay.set(Calendar.HOUR_OF_DAY, 23);
            itemDay.set(Calendar.MINUTE, 59);
            itemDay.set(Calendar.SECOND, 59);
            itemDay.set(Calendar.MILLISECOND, 999);

            Date todayTo = itemDay.getTime(); // todo 该天地结束最后(某天最后1毫秒)

            System.out.println(i+",todayTo="+todayTo);


        }
    }

}
