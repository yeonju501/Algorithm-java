import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution_menu_renewal {

    static String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
    static int[] course = {2,3,5};

    static HashMap<String, Integer> menus;

    static ArrayList<boolean[]> visited = new ArrayList<>();
    public static void main(String[] args) {

        for(int i = 0; i < orders.length; i++) {
            visited.add(new boolean[orders[i].length()]);
        }

        for(int i = 0; i < orders.length; i++) {
            char[] temp = orders[i].toCharArray();
            Arrays.sort(temp);
            orders[i] = String.valueOf(temp);
        }

        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < course.length; i++) {
            menus = new HashMap<>();
            for(int j = 0; j < orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                if(course[i] <= orders[j].length()) {
                    dfs(course[i], orders[j], 0, 0, sb, j);
                }
            }
            int max = 0;
            for(Entry<String, Integer> entry: menus.entrySet()){
                max = Math.max(max, entry.getValue());
            }

            for(Entry<String, Integer> entry: menus.entrySet()) {
                if(max >= 2 && entry.getValue() == max) {
                    result.add(entry.getKey());
                }
            }
        }


        Collections.sort(result);
        for(String s: result) {
            System.out.println(s);
        }
        String[] arr = result.toArray(new String[result.size()]);
    }

    static void dfs(int cnt, String str, int idx, int depth, StringBuilder sb, int m) {
        if(depth == cnt) {
            menus.put(sb.toString(), menus.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for(int i = idx; i < str.length(); i++) {
            if(!visited.get(m)[i]) {
                visited.get(m)[i] = true;
                sb.append(str.charAt(i));
                dfs(cnt, str, i+1,depth+1, sb, m);
                sb.delete(depth, depth+1);
                visited.get(m)[i] = false;
            }

        }
    }

}
