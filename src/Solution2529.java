import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2529 {

    static int k;
    static String[] signs;
    static boolean[] visited;
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        signs = new String[k];
        visited = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            signs[i] = st.nextToken();
        }
        dfs("", 0);

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

    }

    static void dfs(String num, int depth) {
        if(depth == k+1) {
            list.add(num);
            return;
        }
        for(int i = 0; i < 10; i++) {
            if(visited[i]) continue;
            if(depth == 0 || check(Character.getNumericValue(num.charAt(depth-1)), i, signs[depth-1])) {
                visited[i] = true;
                dfs(num+i, depth+1);
                visited[i] = false;
            }
        }
    }

    static boolean check(int a, int b, String s) {
        if(s.equals(">")) {
            if(a < b) return false;
        } else if(s.equals("<")) {
            if(a > b) return false;
        }
        return true;
    }

}
