package com.loiter.tran.tes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

/**
 * @Fun Description //TODO
 * @Date 2020/9/18 14:04 18
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class bigDeisDemo {

    public static void main(String[] args) {
        BigDecimal devTaskWorking = new BigDecimal("23");
        BigDecimal devTaskComplated = new BigDecimal("89");
        BigDecimal workingAComplated = devTaskWorking.add(devTaskComplated);
        BigDecimal bigDecimal = new BigDecimal("22223");

        BigDecimal divide = bigDecimal.divide(workingAComplated, 2, RoundingMode.HALF_UP);

        if (divide.floatValue() > 5.0f) {
            System.out.println("ss" + divide.setScale(2).toString());
        } else {
            System.out.println(divide.setScale(3).doubleValue());
        }

        BigDecimal bigDecimal1 = BigDecimal.valueOf(12);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(34);
        BigDecimal bigDecimal3 = BigDecimal.valueOf(23);
        BigDecimal add = bigDecimal1.add(bigDecimal2).add(bigDecimal3);
        System.out.println(add.setScale(2).toString());
        User user = new User();
        user.setA(20);
        BigDecimal bigDecimal4 =  BigDecimal.valueOf(Optional.ofNullable(user.getA()).orElse(10));
        System.out.println(bigDecimal4.intValue());


//        System.out.println(workingAComplated.floatValue());
//        System.out.println(workingAComplated.intValue());
//        System.out.println(workingAComplated.doubleValue());
//        System.out.println("---" + devTaskComplated.compareTo(BigDecimal.ZERO));
//        System.out.println("---" + devTaskWorking.compareTo(BigDecimal.ZERO));
//        System.out.println("---" + workingAComplated.compareTo(BigDecimal.ZERO));
//        if (workingAComplated.compareTo(BigDecimal.ZERO) == 0) {
//            System.out.println("和为0");
//        } else {
//            System.out.println("和不为0");
//        }
    }
}

class User {
    private int a ;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}