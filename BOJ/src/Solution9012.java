import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9012 {
    public static void main(String[] args) throws IOException {
//6
//(())())
//(((()())()
//(()())((()))
//((()()(()))(((())))()
//()()()()(()()())()
//(()((())()(
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] stack = new String[50];
            int size = 0;
            int flag = 0;
            String[] strArray = br.readLine().split("");
            for (String s: strArray){
                if(s.equals("(")) {
                    stack[size] = "(";
                    size++;
                } else {
                    if (size == 0) {
                        System.out.println("NO");
                        flag = 1;
                        break;
                    }
                    stack[size] = "";
                    size--;
                }
            }
            if(flag == 0){
                if (size != 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
