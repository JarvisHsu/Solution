package subject.arithmetic;

import java.util.Scanner;

/**
 * @author Jarvis
 */
public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int[][] points = new int[6][6];
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                points[i][j] = sc.nextInt();
//                if (points[i][j] == -1) {
//                    points[i][j] = Integer.MAX_VALUE;
//                }
//            }
//        }
        int[][] points = new int[][]{
                {0,1,12,-1,-1,-1},
                {-1,0,9,3,-1,-1},
                {-1,-1,0,-1,5,-1,},
                {-1,-1,4,0,13,15},
                {-1,-1,-1,-1,0,4},
                {-1,-1,-1,-1,-1,0}};
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(points[i][j]==-1){
                    points[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        int[] d = getDistence(points);
        for (int i : d) {
            System.out.println(i);
        }
    }

    private static int[] getDistence(int[][] points) {
        int maxTime = Integer.MAX_VALUE;
        int N = 6;
        int[] dist = new int[N];
        boolean[] isVisited = new boolean[N];
        System.arraycopy(points[0], 0, dist, 0, N);
        isVisited[0] = true;
        for (int i = 0; i < N; i++) {
            int min = maxTime;
            int k = 0;
            for (int j = 0; j < N; j++) {
                if (!isVisited[j] && dist[j] < min) {
                    min = dist[j];
                    k = j;
                }
            }
            isVisited[k] = true;
            for (int j = 0; j < N; j++) {
                if (!isVisited[j] && points[k][j] != maxTime) {
                    if (dist[j] >= points[k][j] + dist[k]) {
                        dist[j] = points[k][j] + dist[k];
                    }
                }
            }
        }
        return dist;
    }
}
