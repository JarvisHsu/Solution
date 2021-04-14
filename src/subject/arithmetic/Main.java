package subject.arithmetic;

/**
 * @author Jarvis
 */
public class Main {
    public static void main(String[] args) {
        String str = new String("      -117xsadf40091539");
        str = str.replace(" ","").replaceAll("[^-\\d.*?][\\D|\\W].*?$","");
        System.out.println(str);
        System.out.println(new Integer(str));
    }
}
