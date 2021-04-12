package subject.arithmetic;

import java.util.*;

/**
 * @author Jarvis
 */
public class SumReturnIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[]{3,2,5,8,4,7,6,9};
        System.out.println(Arrays.toString(twoSum(nums,11)));
        System.out.println(twoSum("733064366","459309139"));
    }
    public static int[] twoSum(int[] nums,int target){
        int[] rst = new int[2];
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            //map中存在与当前值求和为target的值
            if(map.containsKey(target-nums[i])){
                rst[0] = map.get(target-nums[i]);
                rst[1] = i;
                break;
            }else{
                map.put(nums[i],i);
            }
        }
        return rst;
    }

    /**
     * 字符串参数，相加，返回字符串和
     * @param s
     * @param t
     * @return
     */
    public static String twoSum(String s,String t){
        StringBuilder stringBuffer = new StringBuilder();
        int sL = s.length()-1;
        int tL = t.length()-1;
        //进位
        int arr = 0;
        while(sL>=0||tL>=0){
            int num = arr;
            arr = 0;
            int temp =0;
            //可以求和的
            if(sL>=0&&tL>=0){
                int a= s.charAt(sL--)-'0';
                int b = t.charAt(tL--)-'0';
                temp = a+b;
            }else if(sL<0){
                temp = t.charAt(tL--)-'0';
            }else{
                temp = s.charAt(sL--)-'0';
            }
            num+=temp;

            if(num>=10){
                arr = num/10;
                num = num%10;
            }
            stringBuffer.append(num);
        }
        if(arr!=0) {
            stringBuffer.append(arr);
        }
        return stringBuffer.reverse().toString();
    }

}
