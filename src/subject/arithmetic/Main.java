package subject.arithmetic;

/**
 * @author Jarvis
 */
public class Main {
    public static void main(String[] args) {
        String str = new String("    0101  www s12314");
        str = str.replace(" ","").replaceAll("\\D","");
        System.out.println(str);
        System.out.println(new Integer(str));
    }
}
