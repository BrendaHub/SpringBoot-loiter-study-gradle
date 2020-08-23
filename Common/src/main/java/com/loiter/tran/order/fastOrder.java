package com.loiter.tran.order;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.json.JSONUtil;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * 快排 时间复杂度O(nLGN)
 */
public class fastOrder {

    public static Integer[] order(Integer[] arr, int begin, int end) {
        // 快排java实现
        if (arr != null && arr.length < 2) {
            return arr;
        } else if (end < begin) {
            return arr;
        } else {
            // 初始化left 和 right
            int left = begin;
            int right = end;
            // 以第一个元素判断
            Integer temp = arr[left];
            while (left < right) {
                // 如果左右定位到的元素小于从最右边的定位元素，位置不变，
                if (left < right && temp < arr[right]) {
                    ;  // 空操作不交换位置， 但是游标需要操作
                    right--;

                } else if (left < right && temp > arr[right]){
                    // 要交换位置内容
                    arr[left] = arr[right];
                    arr[right] = temp;
                    // 这里， left + 1 , right - 1
                    left = left + 1;
                }
                temp = arr[left];
            }
            System.out.println(Arrays.toString(arr));
            order(arr, begin, left - 1);
            order(arr, left + 1, end);
            return arr;
        }
    }

    public static void main(String[] args) {
        Integer[] initArray = new Integer[] {23,-43,12,4,-1,-11,32,434};
        Integer[] ordered = order(initArray, 0, initArray.length);
        System.out.println(Arrays.toString(ordered));
    }
}
