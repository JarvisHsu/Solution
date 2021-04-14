package subject.arithmetic;

/**
 * @author Jarvis
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(getReverseInteger(1534236469));
    }

    private static int getReverseInteger(int num) {
        int rst = 0;
        boolean negativeFlag = false;
        if (num<0){
            num = -num;
            negativeFlag = true;
        }
        StringBuilder string = new StringBuilder(String.valueOf(num));
        string.reverse();
        for (int i = 0; i < string.length(); i++) {
            int temp = string.charAt(i) - '0';
            if(rst>Integer.MAX_VALUE/10||rst<Integer.MIN_VALUE/10||(temp>7&&rst==Integer.MAX_VALUE/10)||(temp<-8)&&rst==Integer.MIN_VALUE/10){
                return 0;
            }
            rst=rst*10+temp;
        }
        if(negativeFlag){
            rst=-rst;
        }
        System.out.println(string.toString());
        return rst;

    }
}
