import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10824 {
    public static void main(String[] args) throws IOException {
//10 20 30 40
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            str[i] = st.nextToken();
        }
        System.out.println(Long.parseLong(str[0]+str[1]) + Long.parseLong(str[2] + str[3]));
    }

}
