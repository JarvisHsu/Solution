package subject.arithmetic.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Jarvis
 */
public class QuickSort {
    private static int partition(int[]arr,int low,int high){
        int i = low;
        int j = high;
        int key = arr[i];
        while(i<j){
            while(i<j&&key<=arr[j]){
                j--;
            }
            if(i<j){
                arr[i]=arr[j];
            }
            while (i<j&&key>=arr[i]){
                i++;
            }
            if(i<j){
                arr[j] = arr[i];
            }
        }
        arr[i]=key;
        return i;
    }
    //递归方式
    private static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int i = partition(arr,low,high);
            quickSort(arr,low,i-1);
            quickSort(arr,i+1,high);
        }
    }

    /**
     * //非递归方式:腾讯PCG二面
     * 递归本身就是栈调用，转换为非递归方式直接选择栈。
     */
    private static void quickSort(int[] arr){
        int low = 0;
        int high = arr.length-1;
        Stack<Integer> stack = new Stack<>();
        if(low<high){
            stack.push(high);
            stack.push(low);
            //如果栈不为空
            while(!stack.isEmpty()){
                int left = stack.pop();
                int right = stack.pop();
                int mid = partition(arr,left,right);
                if(left<mid){
                    stack.push(mid);
                    stack.push(left);
                }
                if(right>mid+1){
                    stack.push(high);
                    stack.push(mid+1);
                }
            }
        }
    }
    //错误答案
    private static void quickSort_2(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int mid = partition(arr,low,high);
        while (mid<high){
            mid = partition(arr,mid+1,high);
        }
        while (mid>low){
            mid = partition(arr,low,mid);
        }
    }



    public static void main(String[] args) {
        int[] arr = new int[]{3,3,2,2,5,5,8,8,4,4,7,7,6,6,9,9,0,0,1,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
