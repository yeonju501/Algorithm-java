import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2636 {

    static int n, m, ans, cnt;
    static int[][] map;
    static int[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    cnt++;
                }
            }
        }

        bfs();

        int cheese = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == ans) {
                    cheese++;
                }
            }
        }

        System.out.println(ans + " " + cheese);
    }

    static void bfs() {
        int cnt2 = 0;
        visited = new int[n][m];
        while(cnt != cnt2){
            ans++;
            q.add(new int[] {0, 0});
            boolean[][] visit = new boolean[n][m];
            while(!q.isEmpty()) {
                int[] xy = q.poll();
                int x = xy[0];
                int y = xy[1];
                visit[x][y] = true;
                for(int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(visit[nx][ny]) continue;
                    if(map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        visited[nx][ny] = ans;
                        visit[nx][ny] = true;
                        cnt2++;
                        continue;
                    }
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

}



