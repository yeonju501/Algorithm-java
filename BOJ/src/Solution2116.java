import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2116 {

    static int n, max;
    static int[][] dice;
    static int[] pair = {5, 3, 4, 1, 2, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dice = new int[n][6];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 6; i++) {
            int topIdx = i;
            int bottomIdx = pair[i];
            int m = getMax(topIdx, bottomIdx, 0);
            pileDice(dice[0][i], 1, m);
        }

        System.out.println(max);
    }

    static int getMax(int idx1, int idx2, int diceIdx) {
        int m = 0;
        for(int i = 0; i < 6; i++) {
            if(i == idx1 || i == idx2) continue;
            m = Math.max(m, dice[diceIdx][i]);
        }
        return m;
    }

    static void pileDice(int bottom, int depth, int sum) {
        if(depth == n) {
            max = Math.max(sum, max);
            return;
        }

        int bottomIdx = 0;
        for(int i = 0; i < 6; i++) {
            if(dice[depth][i] == bottom) {
                bottomIdx = i;
            }
        }
        int topIdx = pair[bottomIdx];

        int m = getMax(topIdx, bottomIdx, depth);


        pileDice(dice[depth][topIdx], depth+1, sum + m);
    }
}
