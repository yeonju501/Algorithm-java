import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10844 {

    public static void main(String[] args) throws IOException {
//2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 테이블 정의
        long dp[][] = new long[n+1][10];

        // 초기값 설정
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        //점화식 정의
        for(int i = 2; i < n+1; i++) {
            dp[i][0] = dp[i-1][1] % 1000000000;
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
            dp[i][9] = dp[i-1][8] % 1000000000;
        }
        long result = 0;
        for (int i = 1; i < 10; i++) {
            result += dp[n][i]%1000000000;
        }
        System.out.println(result%1000000000);
    }

}
