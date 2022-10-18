import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2206 {

    static char[][] map;
    static boolean[][] visited, visited2;
    static int n, m, min = Integer.MAX_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        visited2 = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bfs();
    }

    static class Pos {
        int x;
        int y;
        int flag;
        int cnt;
        Pos(int x, int y, int flag, int cnt) {
            this.x = x;
            this.y = y;
            this.flag = flag;
            this.cnt = cnt;
        }
    }
    static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 0, 1));
        visited[0][0] = true;
        while(!q.isEmpty()) {
            Pos p = q.poll();
            int x = p.x;
            int y = p.y;
            if(x == n-1 && y == m-1) {
                System.out.println(p.cnt);
                return;
            }
            for(int i = 0; i < 4; i++) {
                int flag = p.flag;
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(flag == 0) {
                    if(visited[nx][ny]) continue;
                    if(map[nx][ny] == '1') {
                        visited2[nx][ny] = true;
                        q.add(new Pos(nx, ny, 1, p.cnt+1));
                        continue;
                    }
                    visited[nx][ny] = true;
                    q.add(new Pos(nx, ny, 0, p.cnt+1));
                } else if(flag == 1) {
                    if(visited2[nx][ny]) continue;
                    if(map[nx][ny] == '0') {
                        visited2[nx][ny] = true;
                        q.add(new Pos(nx, ny, flag, p.cnt+1));
                    }
                }
            }
        }
        System.out.println(-1);
    }

}
