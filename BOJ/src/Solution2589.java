import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2589 {
    static int N, M;
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
//5 7
//WLLWWWL
//LLLWLLL
//LWLWLWW
//LWLWLLL
//WLLWLWW
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        int ans = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j].equals("L")){
                    visited = new boolean[N][M];
                    int max = bfs(i, j);
                    ans = Math.max(ans, max);
                }
            }
        }
        System.out.println(ans);
    }

    static int bfs(int x, int y) {
        visited[x][y] = true;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y, 0));
        int max = 0;
        while(!q.isEmpty()) {
            Pos p = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(map[nx][ny].equals("W") || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new Pos(nx, ny, p.cnt+1));
                max = Math.max(max, p.cnt+1);
            }
        }
        return max;
    }

    static class Pos{
        int x;
        int y;
        int cnt;
        Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }


}
