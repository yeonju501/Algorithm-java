import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7562 {
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int t, l;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int T = 0; T < t; T++) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;

            int ans = bfs(x, y);
            System.out.println(ans);
        }
    }

    static int bfs(int x, int y) {
        Queue<Chess> q = new LinkedList<>();
        boolean[][] visited = new boolean[l][l];
        visited[x][y] = true;
        if(map[x][y] == 1) return 0;
        q.add(new Chess(x, y, 0));
        while(!q.isEmpty()) {
            Chess chess = q.poll();
            for(int i = 0; i < 8; i++) {
                int nx = chess.x + dx[i];
                int ny = chess.y + dy[i];
                if(nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                if(map[nx][ny] == 1) return chess.depth + 1;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new Chess(nx, ny, chess.depth+1));
            }
        }
        return 0;
    }

    static class Chess {
        int x;
        int y;
        int depth;
        Chess(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
