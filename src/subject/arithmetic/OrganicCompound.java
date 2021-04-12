package subject.arithmetic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jarvis
 * 题目：有机化合物
 * 京东试题
 * 输入：字符串格式 如C4H9OH
 * 输出：整数格式 相对分子质量 74
 * 元素只包含C、H、O、N，12、16、1、14
 */
public class OrganicCompound {
    private static int getOrganicCompound(String str) {
        int res = 0;
        int len = str.length();
        String[] s = str.split("[CHON]");
        for (String s1 : s) {
            System.out.println(s1);
        }
        Map<Character, Integer> map = new HashMap<>();
//        for(int i = 1;i<len;){
//            //当前不为元素符号
//            if(str.charAt(i-1) != 'C'&&str.charAt(i-1) != 'H'&& str.charAt(i-1) != 'O'&&str.charAt(i-1) != 'N') {
//                i++;
//                continue;
//            }
//            char ch = str.charAt(i-1);
//            int num = 0;
//            if(str.charAt(i) != 'C'&&str.charAt(i) != 'H'&& str.charAt(i) != 'O'&&str.charAt(i) != 'N'){
//                while(i<len&&'0'<=str.charAt(i)&&str.charAt(i)<='9'){
//                    num= num*10+str.charAt(i++)-'0';
//                }
//            }else {
//                num=1;
//                i++;
//            }
//            if (map.containsKey(ch)) {
//                map.replace(ch, map.get(ch) + num);
//            } else {
//                map.put(ch, num);
//            }
//        }





//        for (int i = 1; i < len; i++) {
//            if (str.charAt(i - 1) == 'C' || str.charAt(i - 1) == 'H' || str.charAt(i - 1) == 'O' || str.charAt(i - 1) == 'N') {
//                int num = 1;
//                char ch = str.charAt(i - 1);
//                if (str.charAt(i) != 'C'&&str.charAt(i) != 'H'&& str.charAt(i) != 'O'&&str.charAt(i) != 'N') {
//                    num = str.charAt(i) - '0';
//                    i++;
//                }
//                if (map.containsKey(ch)) {
//                    map.replace(ch, map.get(ch) + num);
//                } else {
//                    map.put(ch, num);
//                }
//            }
//        }
        map.forEach((character, integer) -> System.out.println(character+" "+integer));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getOrganicCompound("CHON"));
    }
}
