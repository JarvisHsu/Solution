package subject.arithmetic;

import java.util.Scanner;

public class BagPro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int bagV = sc.nextInt();
//        int[] weight = new int[num];
//        int[] value = new int[num];
//        for (int i = 0; i < num; i++) {
//            weight[i] = sc.nextInt();
//        }
//        for (int i = 0; i < num; i++) {
//            value[i] = sc.nextInt();
//        }
        int num = 4;
        int bagV = 15;
        int[] weight = new int[]{5, 3, 4, 6};
        int[] value = new int[]{20, 10, 12, 30};

        System.out.println(getMaxValue(num, bagV, weight, value));
    }

    public static int getMaxValue(int num, int bagV, int[] weight, int[] value) {
        if(num==0){
            return 0;
        }
        int[][] dp = new int[num][bagV+1];
        for (int i = 1  ; i <=bagV; i++) {
            if(i>= weight[0]){
                dp[0][i]=value[0];
            }else{
                dp[0][i]=0;
            }

        }
        for (int i = 1; i <num; i++) {
            for (int j = 1  ; j <=bagV; j++) {
                int val = (j-weight[i]>=0)?(value[i]+dp[i-1][j-weight[i]]):(0);
                int valw = dp[i-1][j];
                dp[i][j]=Math.max(val,valw);
            }
        }
        return dp[num-1][bagV];
    }
}
