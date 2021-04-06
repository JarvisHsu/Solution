package subject.arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SQLsubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        Stream<String> str = reader.lines();
        final StringBuffer[] s = {new StringBuffer()};
        str.forEach(s1 -> s[0].append(s1));
        List<String> arr = findSQL(Arrays.toString(s));
        for (String s2 : arr) {
            System.out.println(s2);
        }
    }

    private static List<String> findSQL(String str) {
        List<String> list = new ArrayList<>();
        Matcher m = Pattern.compile("(?i)(?<=(?:from|into|update|join)\\s{1,1000}"+"(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"+"(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"+"(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"+"(?:\\w{1,1000}(?:\\s{0,1000},\\s{0,1000})?)?"+")(\\w+)").matcher(str);
        while (m.find()){
            list.add(m.group().replace(" ","").replace("\n",""));
        }
        return list;
    }

}
