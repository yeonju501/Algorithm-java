import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution2468 {
    static int N, cnt, max;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
//5
//6 8 2 6 2
//3 2 3 4 6
//6 7 3 3 2
//7 2 5 3 6
//8 9 5 2 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int m = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                m = Math.max(m, arr[i][j]);
            }
        }

        for(int i = 0; i < m+2; i++) {
            cnt = 0;
            visited = new boolean[N][N];
            check(i);
        }

        System.out.println(max);
    }

    static void check(int h) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] > h && !visited[i][j]) {
                    cnt++;
                    bfs(i, j, h);
                }
            }
        }
        max = Math.max(cnt, max);
    }

    static void bfs(int x, int y, int h) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[] {x, y});
        while(!q.isEmpty()) {
            int[] xy= q.poll();
            x = xy[0];
            y = xy[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(arr[nx][ny] > h && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
