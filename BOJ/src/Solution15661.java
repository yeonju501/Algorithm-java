import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15661 {

    static int n;
    static int min = 987654321;
    static boolean[] visited;
    static int[][] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        s = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(min);
    }

    static void dfs(int depth) {
        if(min == 0) {
            System.out.println(0);
            System.exit(0);
        }
        if(depth == n) {
            int start = 0;
            int link = 0;
            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j < n; j++) {
                    if(visited[i] && visited[j]) {
                        start += s[i][j] + s[j][i];
                    } else if(!visited[i] && ! visited[j]) {
                        link += s[i][j] + s[j][i];
                    }
                }
            }
            min = Math.min(Math.abs(start-link), min);
            return;
        }
        visited[depth] = true;
        dfs(depth+1);
        visited[depth] = false;
        dfs(depth+1);
    }

}
