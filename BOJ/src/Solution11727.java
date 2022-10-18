import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution11727 {
    public static void main(String[] args) throws IOException {
//8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];

        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i < N+2; i++) {
            dp[i] = (dp[i-2] * 2 + dp[i-1]) % 10007;
        }
        System.out.println(dp[N]);
    }
}
