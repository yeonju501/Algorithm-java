import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution15683_2 {
    static int[][][] direction = {
        {{}},

        {
            {0}, {1}, {2}, {3}
        },
        {
            {0, 2}, {1, 3}
        },
        {
            {0, 3}, {0, 1}, {1, 2}, {2, 3}
        },
        {
            {0, 2, 3}, {0, 1, 3}, {0, 1, 2}, {1, 2, 3}
        },
        {
            {0, 1, 2, 3}
        }
    };
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static int n, m, cctvCnt, min = 70;

    static ArrayList<Cctv> cctvs = new ArrayList<>();
    static int[] p, s = {0, 4, 2, 4, 4, 1};
    static ArrayList<boolean[]> visited = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0 && map[i][j] < 6) {
                    cctvs.add(new Cctv(i, j, map[i][j]));
                    cctvCnt++;
                }
            }
        }

        for(int i = 0; i < cctvCnt; i++) {
            visited.add(new boolean[s[cctvs.get(i).idx]]);
        }

        p = new int[cctvCnt];

        dfs(0);
        System.out.println(min);

    }

    static void dfs(int depth) {
        if(depth == cctvCnt) {
            check();
            return;
        }

        for(int i = 0; i < s[cctvs.get(depth).idx]; i++) {
            if(!visited.get(depth)[i]){
                // 감시 방향 선택
                p[depth] = i;
                visited.get(depth)[i] = true;
                dfs(depth+1);
                visited.get(depth)[i] = false;
                p[depth] = 0;
            }
        }
    }

    static void check() {
        int[][] copyMap = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < cctvCnt; i++) {
            for(int j = 0; j < direction[cctvs.get(i).idx][p[i]].length; j++) {
                int x = cctvs.get(i).x;
                int y = cctvs.get(i).y;
                while(true) {
                    int nx = x + dx[direction[cctvs.get(i).idx][p[i]][j]];
                    int ny = y + dy[direction[cctvs.get(i).idx][p[i]][j]];
                    if(nx >= n || nx < 0 || ny >= m || ny < 0) break;
                    if(copyMap[nx][ny] == 6) break;
                    copyMap[nx][ny] = copyMap[x][y];
                    x = nx;
                    y = ny;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        min = Math.min(cnt, min);

    }
    static class Cctv{
        int x;
        int y;
        int idx;
        Cctv(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

}
