import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10952 {

    public static void main(String[] args) throws IOException {
//1 1
//2 3
//3 4
//9 8
//5 2
//0 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==0 && b==0) {
                break;
            }

            sb.append(a+b).append("\n");
        }
        System.out.println(sb);
    }

}
