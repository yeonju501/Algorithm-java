import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution8393 {
    public static void main(String[] args) throws IOException {
//3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i = 1; i <= N; i++) {
            result += i;
        }
        System.out.println(result);
    }

}
