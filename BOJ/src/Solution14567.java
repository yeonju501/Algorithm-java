import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14567 {

    static int n, m;
    static int[][] pre;
    static int[][] dp;
    static int[] max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pre = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        max = new int[n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pre[b][a] = 1;
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(pre[i][j] == 1) {
                    dp[i][j] = max[j] + 1;
                    max[i] = Math.max(max[i], dp[i][j]);
                }
            }
        }

        for(int i = 1; i < n+1; i++) {
            System.out.print((max[i]+1) + " ");
        }
    }
}
