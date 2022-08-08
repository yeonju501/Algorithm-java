import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1977 {
    public static void main(String[] args) throws IOException {
//60
//100
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = 0;
        boolean flag = false;
        for(int i = 1; i < N+1; i++){
            int g = i * i;
            if(g >= M && g <= N) {
                if(!flag) {
                    min = g;
                    flag = true;
                }
                sum += g;
            } else if(g > N) {
                break;
            }
        }

        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);

        }

    }

}
