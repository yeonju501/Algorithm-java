import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 테이블 정의
        long[][] dp = new long[n+1][10];

        // 2. 초기값 설정
        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 3. 점화식 정의
        for(int i = 2; i < n+1; i++) {
            for(int j = 0; j < 10; j++) {
                for(int z = j; z < 10; z++) {
                    dp[i][j] += dp[i-1][z] % 10007;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < 10; i++) {
            result += dp[n][i] % 10007;
        }
        System.out.println(result % 10007);
    }

}
