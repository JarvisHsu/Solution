package subject.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jarvis
 * 、、大数相乘
 */
public class Solution {
    public static void main(String[] args) {

    }

    //String num1
    //String num2
    public static String twoSum(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        StringBuffer res = new StringBuffer();
        int len1 = num1.length();
        int len2 = num2.length();
        int i = len1 - 1;
        int j = len2 - 1;
        int arr = 0;
        while (i >= 0 || j >= 0) {
            int num = arr;
            arr = 0;
            //两者都不为空
            if (i >= 0 && j >= 0) {
                int i1 = num1.charAt(i--) - '0';
                int i2 = num2.charAt(j--) - '0';
                num += i1 + i2;
                //num1未完
            } else if (i >= 0) {
                int i1 = num1.charAt(i--) - '0';
                num += i1;
                //num2未完
            } else {
                int i2 = num2.charAt(j--) - '0';
                num += i2;
            }
            //进位
            if (num >= 10) {
                arr = num / 10;
                num %= 10;
            }
            res.append(num);
        }
        if (arr != 0) {
            res.append(arr);
        }
        return res.reverse().toString();
    }

    //乘法：111
    //       11
    //     111
    //    111
    public static String twoOperation(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int minLen = Math.min(len1, len2);
        String mainStr = len1 != minLen ? num1 : num2;
        String assistStr = len1 != minLen ? num2 : num1;
        int count = 0;
        //生成乘法模拟表
        List<StringBuffer> list = new ArrayList<>();
        for (int i = minLen - 1; i >= 0; i--) {
            StringBuffer temp = new StringBuffer();
            temp.append(multiply(mainStr, assistStr.charAt(i)));
            //补零
            for (int j = 0; j < count; j++) {
                temp.append('0');
            }
            list.add(temp);
            count++;
        }
        //计算最终结果
        for (int i = list.size() - 1; i > 0; i--) {
            StringBuffer temp = new StringBuffer(twoSum(list.get(i).toString(), list.get(i - 1).toString()));
            list.remove(i);
            list.set(i - 1, temp);
        }
        StringBuffer rst = list.get(0);
        return rst.toString();
    }

    private static String multiply(String mainStr, char num) {
        StringBuffer rst = new StringBuffer();
        int arr = 0;
        for (int i = mainStr.length() - 1; i >= 0; i--) {
            int temp = arr;
            arr = 0;
            int i1 = mainStr.charAt(i) - '0';
            temp += (num - '0') * i1;
            if (temp >= 10) {
                arr = temp / 10;
                temp %= 10;
            }
            rst.append(temp);
        }
        if (arr != 0) {
            rst.append(arr);
        }
        return rst.reverse().toString();
    }

}
