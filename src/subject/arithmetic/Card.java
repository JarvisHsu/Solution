package subject.arithmetic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Jarvis
 * n张卡片排成一排 每个卡片上是0或1
 * 现在选择一个卡片移除掉 然后可以拿走任意连续为1的卡片  问最多能拿走的卡片数量
 * 2
 * 3
 * 111
 * 6
 * 110101
 * <p>
 * 2
 * 3
 */
public class Card {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //[1,1000];
        //[1,10^5]
        int n = 3;
        int[] a = new int[n];
        for (int j = 0; j < n; j++) {
            a[j] = sc.nextInt();
        }
        System.out.println(getResult(a, 1));

    }

    public static int getResult(int[] A, int K) {
        int left = 0;
        int right = 0;
        int len = A.length;
        int count = 0;
        int result = 0;
        while (right < len) {
            if (A[right] == 0) {
                count++;
            }
            while (count > K) {
                result = Math.max(result, right - left);
                if (A[left] == 0) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return Math.max(result, right - left)-1;
    }
}






















