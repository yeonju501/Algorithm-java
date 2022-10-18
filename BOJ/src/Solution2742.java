import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2742 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            System.out.println(T-i);
        }
    }
}
