package subject.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jarvis
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。
 * 由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
 * 编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 */
public class InterviewQuestion16_19 {
    public static void main(String[] args) {
        int[][] land = new int[][]{{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        System.out.println(Arrays.toString(pondSizes(land)));
    }

    private static int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int temp = findPool(land, i, j);
                if (temp != 0) {
                    list.add(temp);
                }
            }
        }
        //优雅的List转基本集合方法
        int[] result = list.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(result);
        return result;
    }

    /**
     * 从x,y点开始查
     */
    private static int findPool(int[][] land, int x, int y) {
        int num = 0;
        if (x < 0 || y < 0 || x >= land.length || y >= land[0].length || land[x][y] != 0) {
            return num;
        }
        num++;
        //已查
        land[x][y] = -1;
        //查其他八个方向
        num += findPool(land, x + 1, y);
        num += findPool(land, x - 1, y);
        num += findPool(land, x, y + 1);
        num += findPool(land, x, y - 1);
        num += findPool(land, x + 1, y + 1);
        num += findPool(land, x + 1, y - 1);
        num += findPool(land, x - 1, y + 1);
        num += findPool(land, x - 1, y - 1);
        return num;
    }
}
