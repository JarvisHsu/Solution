package subject.arithmetic.sort;

import java.util.Arrays;

/**
 * @author Jarvis
 * 计数排序：优点：待排数据范围小时，排序效率高。
 * 缺点：1、当数列元素不是整数，并不适用计数排序。(解决方案：桶排序)
 * 2、当数列最大最小值差距过大时，并不适用计数排序。
 * 当原始数组规模为N，统计数组规模为M时。时间复杂度为O(M+N)空间复杂度为O(M)
 */
public class CountSort {
    private static int[] countSort(int[] arr) {
        //1、找到最大最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        //2、创建计数数组
        int[] countArray = new int[max - min + 1];
        for (int i : arr) {
            countArray[i - min]++;
        }
        //3、计数数组变形，每位加上前面位数的和
        int sum = 0;
        for (int i = 0; i < countArray.length; i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }
        //4、倒序遍历原始数列，从统计数组找到正确位置，输出到结果数组
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArray[countArray[arr[i]-min]-1]=arr[i];
            countArray[arr[i]-min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,8,4,7,6,6,9,0};
        System.out.println(Arrays.toString(countSort(arr)));
    }
}
