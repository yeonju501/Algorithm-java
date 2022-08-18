import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4963 {
    static int[][] map;
    static int w, h;
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer st;
        while(!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            int ans = 0;
            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(map[i][j] == 1) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        map[x][y] = 1;
        q.add(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] xy = q.poll();
            x = xy[0]; y = xy[1];
            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isNotLand(nx, ny)) continue;
                map[nx][ny] = 0;
                q.add(new int[] {nx, ny});
            }
        }
    }

    static boolean isNotLand(int x, int y) {
        if(x < 0 || x >= h || y < 0 || y >= w) {
            return true;
        }
        if(map[x][y] == 0) {
            return true;
        }
        return false;
    }

}
