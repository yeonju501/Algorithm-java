import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution21278 {
//5 4
//1 3
//4 2
//2 5
//3 2
    static int n, m, build1, build2;
    static int min = Integer.MAX_VALUE;
    static boolean[][] map;
    static int[][] distance;
    static boolean[] visited;
    static int[] b = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][n];
        distance = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                    continue;
                }
                distance[i][j] = 1000000000;
            }
        }
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            distance[a][b] = 1;
            distance[b][a] = 1;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        dfs(0, 0);
        System.out.println(build1 + " " + build2 + " " + min);
    }

    static void dfs(int idx, int depth) {
        if (depth == 2) {
            check();
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                b[depth] = i;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void check() {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int n = Math.min(distance[i][b[0]], distance[i][b[1]]);
            cnt += n * 2;
        }
        if(cnt < min) {
            min = cnt;
            build1 = b[0] + 1;
            build2 = b[1] + 1;
        }
    }
}
