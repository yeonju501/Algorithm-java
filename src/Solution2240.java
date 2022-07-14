import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2240 {
    static int T, W;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
//7 2
//2
//1
//1
//2
//2
//1
//1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        dp = new int[T+1][3][W+1];

        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            dp[1][1][0] = 1;
            dp[1][2][1] = 0;
        }
        else if(N == 2) {
            dp[1][1][0] = 0;
            dp[1][2][1] = 1;
        }
        for(int i = 2; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            if(N == 1) {
                dp[i][1][0] = dp[i-1][1][0] + 1;
                dp[i][2][0] = dp[i-1][2][0];
                for(int j = 1; j <= W; j++) {
                    dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][2][j-1]) + 1;
                    dp[i][2][j] = Math.max(dp[i-1][1][j-1], dp[i-1][2][j]);
                }
            } else if(N == 2) {
                dp[i][1][0] = dp[i-1][1][0];
                dp[i][2][0] = dp[i-1][2][0] + 1;
                for(int j = 1; j <= W; j++) {
                    dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][2][j-1]);
                    dp[i][2][j] = Math.max(dp[i-1][1][j-1], dp[i-1][2][j]) + 1;
                }
            }
        }

        int max = 0;
        for(int i = 0; i <= W; i++) {
            max = Math.max(max, Math.max(dp[T][1][i], dp[T][2][i]));
        }
        System.out.println(max);
    }

}
