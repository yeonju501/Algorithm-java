import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution11720 {

    public static void main(String[] args) throws IOException {
//5
//54321
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split("");
        int sum = 0;
        for (int i = 0; i < T; i++) {
            sum += Integer.parseInt(str[i]);
        }
        System.out.println(sum);
    }
}
