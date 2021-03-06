package subject.arithmetic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class sql {
    public static String sql = "select t.id, t.name, t.tag_id" +
            "from (" +
            "    select user.id, user.name, tag.tag_id" +
            "    from user" +
            "    inner join user_tag" +
            ") t";
    public static void main(String[] args) {

        /*Set<String> tableList = new HashSet<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> str = reader.lines();
        final StringBuffer[] s = {new StringBuffer()};
        str.forEach(s1 -> s[0].append(s1));
        parseSql(Arrays.toString(s),tableList);
        tableList.forEach(System.out::println);*/
        Set<String> tableList = new HashSet<>();
        parseSql(dSql(sql.toLowerCase().replaceAll("\n", "")), tableList);
        //System.out.println(tableList.toString());
        for (String s : tableList) {
            System.out.println(s);
        }
    }
    //去除注释
    public synchronized static String dSql(String sql) {
        Pattern p = Pattern.compile("(?ms)('(?:''|[^'])*')|--.*?$|/\\*.*?\\*/|#.*?$|");
        return p.matcher(sql).replaceAll("$1");

    }

    //解析sql
    public synchronized static void parseSql(String sql, Set<String> tableList) {


        sql = sql.toLowerCase().replaceAll("\t", " ");

        HashMap<Object, Object> map = new HashMap<>();

        int from_ = sql.indexOf(" from ");
        map.put(from_, 6);
        int where_ = sql.indexOf(" where ");
        map.put(where_, 7 + where_);
        int left_outer_join_ = sql.indexOf("left outer join ");
        map.put(left_outer_join_, 16 + left_outer_join_);
        int limit_ = sql.indexOf(" limit ");
        map.put(limit_, 7 + limit_);
        int group_ = sql.indexOf(" group ");
        map.put(group_, 7 + group_);

        int array[] = {where_, left_outer_join_, limit_, group_};
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                continue;
            } else {
                if (min == -1) {
                    min = array[i];
                }

            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        if (from_ < min) {
            String table = sql.substring(sql.indexOf(" from ") + 6, (int) map.get(min));
            String AfterWhere = sql.substring((int) map.get(min));
            parGet(tableList, table);
            if (AfterWhere.contains(" from ")) {
                parseSql(AfterWhere, tableList);
            }
        } else {


            if (sql.contains(" from ")) {
                String AfterWhere = sql.substring(sql.indexOf(" from ") + 6);
                parGet(tableList, AfterWhere);
            }

        }


    }

    // 获取表名
    private synchronized static void parGet(Set<String> tableList, String table) {


        table.trim().replaceAll(" +", " ");
        if (table.trim().contains(" from ")) {
            String from_ = table.substring(table.indexOf(" from ") + 6);
            if (from_.contains(" where ")) {
                from_ = from_.substring(0, from_.indexOf(" where "));
            }

            if (from_.contains(" from ")) {
                from_ = from_.substring(from_.indexOf(" from ") + 6);
            }

            if (from_.contains(")")) {
                from_ = from_.substring(0, from_.indexOf(")"));
            }

            if (from_.trim().contains(",")) {
                String[] splits = from_.split(",");
                for (String s :
                        splits) {
                    if (s.trim().contains(" ")) {
                        s = s.trim().split(" ")[0];
                    }
                    tableList.add(s.trim());
                }
            } else {
                tableList.add(from_.trim());
            }


        } else if (table.trim().contains(" where ")) {
            table = table.substring(0, table.indexOf(" where "));

            if (table.trim().contains(",")) {
                String[] splits = table.split(",");
                for (String s :
                        splits) {
                    if (s.trim().contains(" ")) {
                        s = s.trim().split(" ")[0];
                    }
                    tableList.add(s.trim());
                }
            } else {
                tableList.add(table.trim());
            }
        } else if (table.trim().contains(",")) {

            String[] splits = table.split(",");
            for (String s :
                    splits) {
                if (s.trim().contains(" ")) {
                    s = s.trim().split(" ")[0];
                }
                tableList.add(s.trim());
            }

        } else if (table.trim().contains(" ")) {

            table = table.trim().split(" ")[0];
            tableList.add(table.trim());

        } else {
            tableList.add(table.trim());
        }


    }
}
