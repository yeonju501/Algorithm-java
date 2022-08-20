import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i = 100; i <= n; i++) {
            String num = String.valueOf(i);
            int gap = num.charAt(num.length()-1) - num.charAt(num.length()-2);
            boolean flag = true;
            for(int j = num.length()-1; j > 0; j--) {
                if(num.charAt(j) - num.charAt(j-1) != gap) {
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }

        if(n < 100) {
            System.out.println(n);
        } else {
            System.out.println(cnt + 99);
        }
    }

}
