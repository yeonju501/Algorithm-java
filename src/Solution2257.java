import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2257 {
    public static void main(String[] args) throws IOException {
//(H)2(O)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] stack = new int[100];
        int tmp = 0;
        int size = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'H') {
                tmp = 1;
                stack[size] += 1;
            } else if (c == 'C') {
                tmp = 12;
                stack[size] += 12;
            } else if (c == 'O') {
                tmp = 16;
                stack[size] += 16;
            } else if (c == '(') {
                size++;
                stack[size] = 0;
            } else if (c == ')') {
                tmp = stack[size];
                stack[size] = 0;
                size--;
                stack[size] += tmp;
            } else if(c > '1' && c <= '9') {
                stack[size] += tmp * (c - '1');
            }
        }
        System.out.println(stack[0]);
    }
}
