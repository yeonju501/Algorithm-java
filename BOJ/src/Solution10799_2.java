import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution10799_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' && str.charAt(i+1) == ')') {
                ans += stack.size();
                i++;
            } else if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                ans++;
            }
        }
        System.out.println(ans);
    }
}
