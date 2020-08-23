package com.loiter.tran.order;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 选择性排序Java 实现
 */
public class selectionOrder {

    public static Integer[] orderBySelec(Integer[] intarr) {
        if(intarr != null && intarr.length <= 1) {
            return intarr;
        } else {
            Integer[] ordered = null;
            // 选择性排序时间复杂度为 O(n^2), 意味着需要有二次遍历
            for (Integer item : intarr) {
                Integer minValue = intarr[0];
                int minIndex = 0;
                for (int i = 1 ; i < intarr.length; i++) {
                    if (minValue > intarr[i]) {
                        minValue = intarr[i];
                        minIndex = i;
                    }
                }
                ordered = ArrayUtil.append(ordered, intarr[minIndex]);
                intarr = ArrayUtil.remove(intarr, minIndex);
            }
            return ordered;
        }
    }

    public static void main(String[] args) {
        Integer[] initArray = new Integer[] {23,-43,12,4,-1,-11,32,434};
        Integer [] ordered = selectionOrder.orderBySelec(initArray);
        System.out.println(ordered);
        for (Integer item: ordered) {
            System.out.print(item + "  ");
        }
    }
}
