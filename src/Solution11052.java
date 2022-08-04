import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11052 {
    static int N;
    static int[] prices;
    static int[] dp;
    public static void main(String[] args) throws IOException {
//4
//1 5 6 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prices = new int[N+1];
        dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            int temp = 0;
            for(int j = 1; j <= N; j++) {
                if(i - j >= 0 && temp < dp[i-j] + prices[j]) {
                    temp = dp[i-j] + prices[j];
                }
            }
            dp[i] = temp;
        }

        System.out.println(dp[N]);

    }

}
