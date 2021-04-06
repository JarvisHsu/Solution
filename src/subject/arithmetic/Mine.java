package subject.arithmetic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jarvis
 */
public class Mine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 7;
        int M = 10;
        int K = 2;
        int[][] arr = new int[][]{{0, 5}, {8, 6}, {10, 8}, {18, 12}, {22, 15}, {25, 12}, {29, 15}};
        System.out.println(getMaxCoin(arr, N, M, K));
    }

    public static int getMaxCoin(int[][] arr, int N, int M, int K) {
        int res = arr[0][1];
        int p = 0;
        int position = arr[0][0];
        int[] smaxCoin = new int[N];
        int cnt = 0;
        for (int i = 0; i < K; ) {
            //找最大金币数(很可能不是最优解)
            int maxCoin = 0;

            for (; p < N && (arr[p][0] - position) <= M; p++) {
                if (maxCoin < arr[p][1]) {
                    smaxCoin[cnt] = maxCoin;
                    maxCoin = arr[p][1];
                } else if (smaxCoin[cnt] < arr[p][1]) {
                    smaxCoin[cnt] = arr[p][1];
                }
            }
            res+=maxCoin;
            position = arr[p-1][0];
            i++;
            cnt++;
            if(p>=N&&i<K){
                System.out.println(Arrays.toString(smaxCoin)+","+i);
                while(i<K&&cnt>=0){
                    res+=smaxCoin[cnt--];
                    i++;
                }
                if(cnt<0){
                    i = K;
                }
            }
        }
        return res;
    }
}
