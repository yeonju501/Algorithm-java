import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9465 {
    static int[][] sticker;
    static int[][] DP;
    static int N;
    static int max;
    public static void main(String[] args) throws IOException {
//2
//5
//50 10 100 20 40
//30 50 70 10 60
//7
//10 30 10 50 100 20 40
//20 40 30 50 60 20 80

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0 ; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sticker = new int[2][N+1];
            DP = new int[2][N+1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++) {
                sticker[0][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++) {
                sticker[1][j] = Integer.parseInt(st.nextToken());
            }

            DP[0][1] = sticker[0][1];
            DP[1][1] = sticker[1][1];
            for(int j = 2; j < N+1; j++) {
                DP[0][j] = Math.max(DP[1][j-1] + sticker[0][j], DP[1][j-2] + sticker[0][j]);
                DP[1][j] = Math.max(DP[0][j-1] + sticker[1][j], DP[0][j-2] + sticker[1][j]);

            }
            System.out.println(Math.max(DP[0][N], DP[1][N]));
        }
    }
}
