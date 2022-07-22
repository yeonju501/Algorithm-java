import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1107 {

    public static void main(String[] args) throws IOException {
//5457
//3
//6 7 8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> button = new ArrayList<>();
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                button.add(Integer.parseInt(st.nextToken()));
            }
        }
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i <= 999999; i++) {
            // int값을 String으로 바꿔주는 함수
            String str = String.valueOf(i);
            boolean check = true;
            for (int j = 0; j < str.length(); j++) {
                if (button.contains(str.charAt(j) - '0')) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                continue;
            }
            cnt = str.length() + Math.abs(i - N);
            if (cnt < min) {
                min = cnt;
            }
        }
        System.out.println(Math.min(Math.abs(100 - N), min));
    }
}
