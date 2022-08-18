import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution12865 {
    static int n, k;
    static int[][] items;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
//4 7
//6 13
//4 8
//3 6
//5 12
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        items = new int[n+1][2];
        dp = new int[n+1][k+1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items[i+1][0] = w;
            items[i+1][1] = v;
        }

        for(int i = 1; i <= n; i++) {
            int w = items[i][0];
            int v = items[i][1];
            for(int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(w <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], v + dp[i-1][j - w]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }

}
