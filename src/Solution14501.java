import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14501 {
    public static void main(String[] args) throws IOException {
//7
//3 10
//5 20
//1 10
//1 20
//2 15
//4 40
//2 200
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[] T = new int[N];
        int[] P = new int[N];
        int[] DP = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());

            DP[i] = P[i];
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(i - j >= T[j]) {
                    DP[i] = Math.max(P[i] + DP[j], DP[i]);
                }
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++) {
            if (i + T[i] <= N) {
                if(max < DP[i]) {
                    max = DP[i];
                }
            }
        }

        System.out.println(max);
    }

}
