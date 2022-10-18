import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution17070 {
    static int n;
    // 0 가로 1 대각선 2 세로
    static int[][] map, dir = {{0, 1}, {1, 2}, {0, 1, 2}};
    static int[][] dxy = {{0, 1}, {1, 1}, {1, 0}};
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n][3];

        dp[0][1][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int d = 0; d < 3; d++) {
                    if(dp[i][j][d] > 0 && map[i][j] == 0) {
                        movePipe(i, j, d);
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 3; i++) {
            ans += dp[n-1][n-1][i];
        }
        System.out.println(ans);
    }

    static void movePipe(int x, int y, int d) {
        for(int i : dir[d]) {
            int nx = x + dxy[i][0];
            int ny = y + dxy[i][1];
            if(nx < n && ny < n && map[nx][ny] == 0) {
                if(i == 1) {
                    if (map[x + 1][y] == 0 && map[x][y + 1] == 0) {
                        dp[nx][ny][i] += dp[x][y][d];
                    }
                } else {
                    dp[nx][ny][i] += dp[x][y][d];
                }
            }
        }
    }
}
