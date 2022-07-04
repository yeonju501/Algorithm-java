import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution11656 {
    public static void main(String[] args) throws IOException {
//baekjoon
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] strArr = new String[s.length()];
        for(int i = 0; i < s.length(); i++) {
            strArr[i] = s.substring(i);
        }
        Arrays.sort(strArr);

        for(String str: strArr) {
            System.out.println(str);
        }
    }

}
