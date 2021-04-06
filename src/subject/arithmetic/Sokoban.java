package subject.arithmetic;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Sokoban {
    private static final int[][] directions = {{0,-1},{0,1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//        int H = scanner.nextInt();
//        int W = scanner.nextInt();
//        int X = scanner.nextInt();
//        int Y = scanner.nextInt();
//        int[][] arr = new int[N][M];
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                arr[i][j] = scanner.nextInt();
//            }
//        }
        int N = 9 ;
        int M = 7 ;
        int H = 3 ;
        int W = 2 ;
        int X = 4 ;
        int Y = 2;
        int[][] arr = new int[][]{{1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,0,0,0,1},
                {1,1,1,1,0,0,1},
                {1,1,1,0,0,0,1},
                {1,1,0,0,0,0,1},
                {1,1,0,0,0,0,1},
                {1,1,0,0,1,0,1}};
        char[][] aarr = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i==X&&j==Y){
                    aarr[i][j] = 'T';
                }else if(i==H&&j==W){
                    aarr[i][j] = 'B';
                }else if(arr[i][j]==0){
                    aarr[i][j] = '.';
                }else{
                    aarr[i][j] = '#';
                }
            }
        }
        System.out.println(getResult(aarr));
        for (char[] chars : aarr) {
            for (char aChar : chars) {
                System.out.print(aChar+" ");
            }
            System.out.println();
        }
    }

    private static int getResult(char[][] grid) {
        int targetX = -1;
        int targetY = -1;
        int startX = -1;
        int startY = -1;
        int peopleX = -1;
        int peopleY = -1;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][][] visited = new boolean[n][m][4];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]=='T'){
                    targetX = i;
                    targetY = j;
                }else if (grid[i][j]=='B'){
                    startX = i;
                    startY = j;
                    peopleX = i;
                    peopleY = j;
                }
            }
        }
        grid[startX][startY] = '#';
        for (int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            int x= startX+direction[0];
            int y= startY +direction[1];
            if(canReach(grid,n,m,peopleX,peopleY,x,y)){
                queue.add(new Point(startX,startY,x,y));
                visited[startX][startY][i] = true;
            }
        }
        grid[startX][startY] = 'B';
        int step = 0;
        while(!queue.isEmpty()){
            for (int i = queue.size()-1; i >=0 ; i--) {
                Point point = queue.poll();
                assert point != null;
                if(point.x == targetX&&point.y==targetY){
                    return step;
                }
                grid[point.x][point.y] = '#';
                if(point.x-1>=0&&grid[point.x-1][point.y]!='#'&&!visited[point.x-1][point.y][2]&&canReach(grid,n,m,point.peopleX,point.peopleY,point.x+1,point.y)){
                    queue.add(new Point(point.x-1,point.y,point.x,point.y));
                    visited[point.x-1][point.y][2] = true;
                }
                if(point.x+1<n&&grid[point.x+1][point.y]!='#'&&!visited[point.x+1][point.y][3]&&canReach(grid,n,m,point.peopleX,point.peopleY,point.x-1,point.y)){
                    queue.add(new Point(point.x+1,point.y,point.x,point.y));
                    visited[point.x+1][point.y][3] = true;
                }
                if(point.y-1>=0&&grid[point.x][point.y-1]!='#'&&!visited[point.x][point.y-1][1]&&canReach(grid,n,m,point.peopleX,point.peopleY,point.x,point.y+1)){
                    queue.add(new Point(point.x,point.y-1,point.x,point.y));
                    visited[point.x][point.y-1][1] = true;
                }
                if(point.y+1<m&&grid[point.x][point.y+1]!='#'&&!visited[point.x][point.y+1][0]&&canReach(grid,n,m,point.peopleX,point.peopleY,point.x,point.y-1)){
                    queue.add(new Point(point.x,point.y+1,point.x,point.y));
                    visited[point.x][point.y+1][0] = true;
                }
                grid[point.x][point.y]='.';

            }
            step++;
        }
        return -1;
    }

    private static boolean canReach(char[][] grid, int n, int m, int startX, int startY, int targetX, int targetY) {
        if(targetX<0||targetX>=n||targetY<0||targetY>=m){
            return false;
        }
        boolean[][] visited = new boolean[n][m];
        visited[startX][startY] = true;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(startX,startY));
        while(!stack.isEmpty()){
            Point point = stack.pop();
            if(point.x == targetX&&point.y==targetY){
                return true;
            }
            for (int[] direction : directions) {
                int x = point.x+direction[0];
                int y = point.y +direction[1];
                if(x>=0&&x<n&&y>=0&&y<m&&grid[x][y]!='#'&&!visited[x][y]){
                    visited[x][y] = true;
                    stack.add(new Point(x,y));
                }
            }
        }
        return false;
    }
    private static class Point{
        int x;
        int y;
        int peopleX;
        int peopleY;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
        public Point(int x,int y,int peopleX,int peopleY){
            this.x =x;
            this.y = y;
            this.peopleX = peopleX;
            this.peopleY = peopleY;
        }
    }

}
