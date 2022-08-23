import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1890 {
    static int n;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] != 0 && map[i][j] != 0) {
                    if(isValid(i+map[i][j])) {
                        dp[i+map[i][j]][j] += dp[i][j];
                    }
                    if(isValid(j+map[i][j])) {
                        dp[i][j+map[i][j]] += dp[i][j];

                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);

    }

    static boolean isValid(long val) {
        if(val >= 0 && val < n) {
            return true;
        }
        return false;
    }

}
