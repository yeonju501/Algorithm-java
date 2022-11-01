import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution17142 {

    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    static int[] se;
    static ArrayList<Virus> vis = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        se = new int[m];
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    vis.add(new Virus(i, j, 1));
                }
                if(map[i][j] == 0) {
                    flag = true;
                }
            }
        }
        if(!flag) {
            System.out.println(0);
            System.exit(0);
        }

        visited = new boolean[vis.size()];
        dfs(0, 0);

        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else{
            System.out.println(ans - 1);
        }
    }

    static class Virus {
        int x;
        int y;
        int t;
        Virus(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    static void dfs(int idx, int depth) {
        if(depth == m) {
            check();
            return;
        }
        for(int i = idx; i < vis.size(); i++) {
            if(!visited[i]){
                visited[i] = true;
                se[depth] = i;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    static void check() {
        int[][] copyMap = new int[n][n];
        int[][] visit = new int[n][n];
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                copyMap[i][j] = map[i][j];
                if(copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        Queue<Virus> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            q.add(vis.get(se[i]));
            int x = vis.get(se[i]).x;
            int y = vis.get(se[i]).y;
            copyMap[x][y] = 3;
            visit[x][y] = 1;
        }

        while(!q.isEmpty()) {
            Virus vi = q.poll();
            int x = vi.x;
            int y = vi.y;
            int t = vi.t;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                // 이미 방문한 빈칸이거나 벽일 경우 컨티뉴
                // 바이러스일 경우는 일단 통과
                if(copyMap[nx][ny] == 3 || copyMap[nx][ny] == 1) continue;
                // 방문했으면 컨티뉴
                if(visit[nx][ny] > 0) continue;
                // 빈칸일 경우 빈칸 개수 줄이기
                if(copyMap[nx][ny] == 0) cnt--;
                copyMap[nx][ny] = 3;
                visit[nx][ny] = t+1;
                q.add(new Virus(nx, ny, t+1));
            }
            // 빈칸 개수가 없어지면
            if(cnt == 0) break;
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(copyMap[i][j] == 0) return;
                // 바이러스가 아닐 경우에서 최대
                max = Math.max(visit[i][j], max);
            }
        }

        ans = Math.min(max, ans);
    }

}
