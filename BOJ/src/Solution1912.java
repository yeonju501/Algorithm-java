import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1912 {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
//10
//10 -4 3 1 5 6 -35 12 21 -1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

}
