import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1946 {
    public static void main(String[] args) throws IOException {
//2
//5
//3 2
//1 4
//4 1
//2 3
//5 5
//7
//3 6
//7 3
//4 2
//1 4
//5 7
//2 5
//6 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] scores;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            scores = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                scores[j][0] = Integer.parseInt(st.nextToken());
                scores[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(scores, Comparator.comparingInt((int[] o) -> o[0]));
            int cnt = 1;
            int min = scores[0][1];
            for(int j = 1; j < N; j++) {
                if(scores[j][1] < min) {
                    cnt++;
                    min = scores[j][1];
                }
            }
            sb.append(cnt + " ");
        }
        System.out.println(sb);
    }
}
