package com.loiter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * @Fun Description //TODO
 * @Date 2020/9/4 12:56 04
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class MiaoDemo {

        public static void main(String[] args) {
            //秒
            long second = 1403;
            //转换为日时分秒
            String days = secondToTime(second);
            System.out.println(days);
            System.out.println(secondToHour(second));
            //转换为所需日期格式
//            String dateString = secondToDate(second,"yyyy-MM-dd hh:mm:ss");
//            System.out.println(dateString);
            if (BigDecimal.valueOf(0.45).compareTo(BigDecimal.valueOf(1.01)) < 0 ) {
                System.out.println(" 小于 " + BigDecimal.valueOf(23.45).floatValue());
            } else if (BigDecimal.valueOf(0.45).compareTo(BigDecimal.valueOf(1.01)) == 0){
                System.out.println("== " + BigDecimal.valueOf(23.45).floatValue());

            } else {
                System.out.println("大");
            }

            if (new BigDecimal("1.01").compareTo(new BigDecimal("1.01")) < 0 ) {
                System.out.println(" 小于 " + BigDecimal.valueOf(23.45).floatValue());
            } else if (new BigDecimal("1.01").compareTo(new BigDecimal("1.01")) == 0){
                System.out.println("== " + BigDecimal.valueOf(23.45).floatValue());

            } else {
                System.out.println("大");
            }

            System.out.println(BigDecimal.valueOf(23.445).setScale(2, RoundingMode.HALF_UP).toString());
        }
        /**
         * 秒转换为指定格式的日期
         * @param second
         * @param patten
         * @return
         */
        private static String secondToDate(long second,String patten) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(second * 1000);//转换为毫秒
            Date date = calendar.getTime();
            SimpleDateFormat format = new SimpleDateFormat(patten);
            String dateString = format.format(date);
            return dateString;
        }
        /**
         * 返回日时分秒
         * @param second
         * @return
         */
        private static String secondToTime(long second) {
            long days = second / 86400;//转换天数
            second = second % 86400;//剩余秒数
            long hours = second / 3600;//转换小时数
            second = second % 3600;//剩余秒数
            long minutes = second / 60;//转换分钟
            second = second % 60;//剩余秒数
            if (0 < days){
                return days + "天，"+hours+"小时，"+minutes+"分，"+second+"秒";
            }else {
                return hours+"小时，"+minutes+"分，"+second+"秒";
            }
        }

        private static String secondToHour(long second) {
            Long secondParam = Optional.ofNullable(second).orElse(0L);
            BigDecimal bigDecimal = BigDecimal.valueOf(secondParam);
            BigDecimal divide = bigDecimal.divide(BigDecimal.valueOf(3600), 2, RoundingMode.HALF_UP);
            return divide.toString() + "h";
        }

}
