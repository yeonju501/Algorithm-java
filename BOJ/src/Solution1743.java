import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1743 {
    static int N, M, K, cnt, max;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
//3 4 5
//3 2
//2 2
//3 1
//2 3
//1 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
        }

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < M+1; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    dfs(i, j);
                    max = Math.max(cnt, max);
                }
            }
        }

        System.out.println(max);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 1 && nx < N+1 && ny >= 1 && ny < M+1){
                if(arr[nx][ny] != 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    cnt++;
                    dfs(nx, ny);
                }
            }
        }
    }

}
