import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution11060 {
    static int N;
    static int[] map;
    static int[] dp;
    public static void main(String[] args) throws IOException {
//10
//1 2 0 1 3 2 1 5 4 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+101];
        dp = new int[N+101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 10000);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 1; j <= map[i]; j++) {
                dp[i+j] = Math.min(dp[i] + 1, dp[i+j]);
            }
        }
        if(dp[N-1] == 10000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N-1]);
        }

    }

}
