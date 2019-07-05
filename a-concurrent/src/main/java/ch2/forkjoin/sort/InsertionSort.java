package ch2.forkjoin.sort;

import java.util.Arrays;

/**
 * 类说明: 插入排序
 */
public class InsertionSort {


    public static int[] sort(int[] arr){
        if(arr.length==0){
           return arr;
        }
        //当前待排序数据,该元素之前的元素已经被排序
        int currentValue;
        for (int i = 0; i < arr.length - 1; i++) {
            /*已被排序数据的索引*/
            int preIndex = i;
            currentValue = arr[preIndex + 1];

            /*在已被排序过数据中倒序寻找合适的位置,
            如果当前排序数据比比较的元素要小
            将比较的元素后移一位*/

            while(preIndex >= 0 && currentValue < arr[preIndex]){
                //将当前元素后移一位
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            //while循环结束,说明已经找到当前排序的合适位置插入;
            arr[preIndex + 1] = currentValue;
        }
        return arr;
    }


    public static void main(String[] args){

        System.out.println(Arrays.toString(sort(MakeArray.makeArray())));
    }



}
