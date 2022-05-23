import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1924 {

    public static void main(String[] args) throws IOException {
//3 14
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int result = 0;
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int [] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String [] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        for(int i = 0; i < m-1; i++) {
            result += dayOfMonth[i];
        }
        result += d;
        result %= 7;
        System.out.println(dayOfWeek[result]);
    }

}
