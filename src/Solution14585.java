import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14585 {

    static int n, m;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[303][303];
        dp = new int[303][303];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x+1][y+1] = 1;
        }
        // 오른쪽 아래쪽

        int max = 0;
        for(int i = 1; i < 302; i++) {
            for(int j = 1; j < 302; j++) {
                if(i+j <= m+2) {
                    if(board[i][j] == 1) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + m - i - j + 2;

                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        System.out.println(max);
    }

}
