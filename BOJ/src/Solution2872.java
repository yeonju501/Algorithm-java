import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] book = new int[n];
        for(int i = 0; i < n; i++) {
            book[i] = Integer.parseInt(br.readLine());
        }

        int max = n;
        int cnt = 0;
        for(int i = n-1; i >= 0; i--) {
            if(book[i] == max) {
                max--;
            } else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
