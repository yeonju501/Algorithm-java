import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10818 {
    public static void main(String[] args) throws IOException {
//5
//20 10 35 30 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = 1000000;
        int max = -1000000;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n > max){
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        System.out.print(min + " " + max);

    }

}
