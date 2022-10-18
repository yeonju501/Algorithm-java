import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution11655 {
    public static void main(String[] args) throws IOException {
//Baekjoon Online Judge
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] ans = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLowerCase(c)){
                if(c - 'a' >= 13) {
                    ans[i] = (char)(s.charAt(i) - 13);
                } else{
                    ans[i] = (char)(s.charAt(i) + 13);
                }
            } else if(Character.isUpperCase(c)) {
                if (c - 'A' >= 13) {
                    ans[i] = (char) (s.charAt(i) - 13);
                } else {
                    ans[i] = (char) (s.charAt(i) + 13);
                }
            } else {
                ans[i] = s.charAt(i);
            }
        }

        for(char c: ans) {
            System.out.print(c);
        }
    }

}
