import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1476 {
    static int[] year;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        year = new int[8001];
        int eRange = 15;
        int sRange = 28;
        int mRange = 19;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int n = E;
        while(n <= 8000) {
            year[n] += 1;
            n += eRange;
        }

        n = S;
        while(n <= 8000) {
            year[n] += 1;
            n += sRange;
        }

        n = M;
        while(n <= 8000) {
            year[n] += 1;
            n += mRange;
        }

        for(int i = 0; i < 8000; i++) {
            if(year[i] == 3) {
                System.out.println(i);
                break;
            }
        }
    }

}
