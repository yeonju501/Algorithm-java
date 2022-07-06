import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution17836 {

    static int N, M, T, ans;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

        if (ans == 0 || ans > T) {
            System.out.println("Fail");
        } else {
            System.out.println(ans);
        }
    }

    static void bfs(int x, int y) {
        visited[0][0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0, 0});
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            x = xy[0];
            y = xy[1];
            int d = xy[2];
            int sword = xy[3];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (sword == 0 && arr[nx][ny] == 0 && !visited[0][nx][ny]) {
                        visited[0][nx][ny] = true;
                        q.add(new int[]{nx, ny, d+1, 0});
                    } else if (sword == 1 && !visited[1][nx][ny]) {
                        visited[1][nx][ny] = true;
                        q.add(new int[]{nx, ny, d+1, 1});
                    } else if (sword == 0 && arr[nx][ny] == 2 && !visited[0][nx][ny]) {
                        visited[1][nx][ny] = true;
                        q.add(new int[]{nx, ny, d+1, 1});
                    }
                    if (nx == N - 1 && ny == M - 1) {
                        ans = d+1;
                        return;
                    }
                }
            }
        }
    }

}
