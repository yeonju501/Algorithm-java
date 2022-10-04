import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution15683_3 {

    static int[][][] dir = {
        {{}},
        {{0}, {1}, {2}, {3}},
        {{0, 1}, {2, 3}},
        {{0, 2}, {0, 3}, {1, 2}, {1, 3}},
        {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}},
        {{0, 1, 2, 3}}
    };

    // 우 좌 하 상
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m, cctvNum, min = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<Cctv> cctvs = new ArrayList<>();
    static int[] s;
    static ArrayList<boolean[]> visited = new ArrayList<>();
    static class Cctv {
        int x;
        int y;
        int idx;
        Cctv(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }
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
                    cctvNum++;
                }
            }
        }
        s = new int[cctvNum];

        for(int i = 0; i < cctvNum; i++) {
            visited.add(new boolean[dir[cctvs.get(i).idx].length]);
        }
        dfs( 0);

        System.out.println(min);

    }

    static void dfs(int depth) {
        if(depth == cctvNum) {
            check();
            return;
        }

        for(int j = 0; j < dir[cctvs.get(depth).idx].length; j++) {
            if(!visited.get(depth)[j]) {
                s[depth] = j;
                visited.get(depth)[j] = true;
                dfs(depth+1);
                visited.get(depth)[j] = false;
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

        for(int i = 0; i < cctvNum; i++) {
            for(int j = 0; j < dir[cctvs.get(i).idx][s[i]].length; j++) {
                int x = cctvs.get(i).x;
                int y = cctvs.get(i).y;
                while(true) {
                    int nx = x + dx[dir[cctvs.get(i).idx][s[i]][j]];
                    int ny = y + dy[dir[cctvs.get(i).idx][s[i]][j]];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) break;
                    if(copyMap[nx][ny] == 6) break;
                    copyMap[nx][ny] = cctvs.get(i).idx;
                    x = nx;
                    y = ny;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copyMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        min = Math.min(min, cnt);
    }

}
