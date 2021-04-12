package subject.arithmetic.sort;

import java.util.Arrays;

/**
 * @author Jarvis
 */
public class QuickSort {
    private static void quickSort(int[] arr,int low,int high){
        if(low<high){
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
            quickSort(arr,low,i-1);
            quickSort(arr,i+1,high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,2,2,5,5,8,8,4,4,7,7,6,6,9,9,0,0,1,1};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
