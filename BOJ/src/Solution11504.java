import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution11504 {

    public static void main(String[] args) throws IOException {
//3
//8 3
//2 0 0
//3 1 1
//3 7 8 3 1 9 2 7
//5 2
//8 8
//9 9
//1 3 2 5 4
//6 3
//0 0 0
//9 9 9
//1 2 3 4 5 6

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int result = 0;
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(br.readLine().replace(" ", ""));
            int Y = Integer.parseInt(br.readLine().replace(" ", ""));
            String[] numsStr = br.readLine().split(" ");

            // 숫자 세개씩 뽑자
            for(int j = 0; j < N; j++) {
                String numStr = "";
                for(int z = 0; z < M; z++) {
                    numStr += numsStr[(j+z)%N];
                }
                int num = Integer.parseInt(numStr);
                if(num >= X && num <= Y) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
