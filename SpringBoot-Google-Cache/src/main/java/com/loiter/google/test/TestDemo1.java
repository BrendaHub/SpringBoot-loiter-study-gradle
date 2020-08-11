package com.loiter.google.test;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Fun Description //TODO
 * @Date 2020/8/9 18:28 09
 * @Author chenhj(brenda)
 * site: https://www.ant-loiter.com
 **/
public class TestDemo1 {

    public static void main2(String[] args) {
//        int[] arr={1,3,2,45,65,33,12};
        int[] arr = new  int[]{12,3,545,1,-112,4,235,-65,3,7,75};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        //选择排序的优化
        for(int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < arr.length; j++){// 选最小的记录
                if(arr[j] < arr[k]){
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println();
        System.out.println("交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
//        int low = 1 ;
//        int high = 50;
//        int mid = (low + high) >>> 1;
//        System.out.println("mid is " + mid);

        int[] arr = new  int[]{12,3,545,1,-12,4,235,65,3,-7,75};

        System.out.println(" 排序前： ");
        for(int i:arr) System.out.print(i + "  " );
        System.out.println();
//        int[] ordered = selectionOrder(arr);
//        System.out.println();
//        System.out.println("排序后： ");
//        for(int i:ordered) System.out.print(i+"  ");
        // 快排
        int[] newarr = FastOrder(arr, 0, arr.length - 1);
        System.out.println();
        for(int i:arr) System.out.print(i + " ; " );
    }

    public static int[] selectionOrder(int[] arr) {
        if (arr != null && arr.length > 0) {
            if (arr.length < 2) {
                return arr;
            } else {
                // 选择排序 时间复杂度为O(N^2) 意味着需要做二遍的循环遍历
                // 大致思路 ，二个循环， 外循环一次， 循环N次，找上本次小最值，并交换， 关键就是在每一次内循环一遍后， 就要记录下来本次最小值的下标，或索引 。
//                int index = 0;
//                for (int item : arr) {
                int index = 0 ;
                for (int item: arr) {
                    int k = index;
                    for (int i = k + 1; i< arr.length ; i ++) {
                        if(arr[k] < arr[i]) {
                            k = i;
                        }
                    }
                    if(k != index) {
                        int temp = item;
                        arr[index] = arr[k];
                        arr[k] = temp;
                    }
                    index ++;
                }
                return arr;
            }
        } else {
            return null;
        }
    }

    // 快排，分治化，分治化就可能需要用到递归算法
    // 要用到递归算法， 就必须有清晰的分界条件，结束递归操作
    public static int[] FastOrder(int[] arr, int start, int end) {
        if (arr != null && arr.length < 2) {
            return arr;
        } else if (start >= end) {
            return arr;
        } else {
            int point = (end + start) >>> 1;
            System.out.println("point is " + point);
            int left = start;
            int right = end;
            while(left < right) {
                while (left < right && arr[left] < arr[point]) {
                    // 交换
//                    int temp = arr[left];
//                    arr[left] = arr[point];
//                    arr[point] = temp;
//                    point = left;
                    left++;
                }
                if (left < right) {
                    arr[right] = arr[left];
                    right --;
                }
                while (left < right && arr[right] > arr[point]) {
//                    int temp = arr[right];
//                    arr[right] = arr[point];
//                    arr[point] = temp;
//                    point = right;
                    right--;
                }
                if(left < right) {
                    arr[left] = arr[right];
                    left++;
                }
            }
            arr[left] = arr[point];
            for(int i:arr) System.out.print(i + " , ");
            FastOrder(arr, start, left -1 );
            FastOrder(arr, left + 1, end);
            return arr;
        }
    }
}
