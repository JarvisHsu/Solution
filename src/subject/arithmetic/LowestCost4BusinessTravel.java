package subject.arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA
 * ClassName: LowestCost4BusinessTravel
 * Package: subject.arithmetic
 * Description:
 *
 * @author : JarvisHsu
 * @date: 2021/04/01 19:57
 */
public class LowestCost4BusinessTravel {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());
        String[] pack = reader.readLine().split(" ");
        String[] price = reader.readLine().split(" ");
        String[] value = reader.readLine().split(" ");
        System.out.println(getMinValue(n,pack,price,value));

    }

    private static int getMinValue(int n, String[] pack, String[] price, String[] value) {

        return -1;
    }
}
