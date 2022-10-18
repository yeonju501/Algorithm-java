import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ans = br.readLine();
        while(str.length() < ans.length()) {
            StringBuilder sb = new StringBuilder();
            if(ans.endsWith("A")) {
                ans = ans.substring(0, ans.length()-1);
            } else if(ans.endsWith("B")) {
                ans = ans.substring(0, ans.length()-1);
                ans = sb.append(ans).reverse().toString();
            }
        }
        if(ans.equals(str)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
