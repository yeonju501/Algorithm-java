import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2743 {
    public static void main(String[] args) throws IOException {
//pulljima
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while((s = br.readLine()) != null) {
            System.out.println(s.length());
        }
    }

}
