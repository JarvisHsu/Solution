package subject.fileoperation.iostream;

import java.io.*;

/**
 * @author Jarvis
 */
public class BufferedStreamTest {
    public static void main(String[] args) throws FileNotFoundException ,IOException {
        File file = new File("./src/subject/fileoperation/iostream/data.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        PrintWriter writer = new PrintWriter(System.out);
        while(reader.ready()){
            String s=reader.readLine();
            System.out.println(s);
        }
    }
}
