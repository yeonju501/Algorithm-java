import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution1406 {
    public static void main(String[] args) throws IOException {
//abcd
//3
//P x
//L
//P y
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            leftStack.push(str.charAt(i));
        }

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("L") && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            } else if (s.equals("D") && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            } else if (s.equals("B") && !leftStack.isEmpty()) {
                leftStack.pop();
            } else if (s.equals("P")) {
                leftStack.push(st.nextToken().charAt(0));
            }
        }

        while(!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}
