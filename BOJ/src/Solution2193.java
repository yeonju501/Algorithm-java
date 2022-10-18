import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 테이블 정의
        long[][] dp = new long[n+2][3];

        // 2. 초기값 설정
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 0;

        // 3. 점화식 정의
        for(int i = 3; i < n+1; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
        }

        System.out.println(dp[n][0] + dp[n][1]);
    }
}
