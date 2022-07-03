import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution1038 {

    static int N;
    static ArrayList<Long> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
//18

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        if(N <= 10) {
            System.out.println(N);
        } else {
            for(int i = 0; i < 10; i++) {
                dfs(i, 1);
            }

            Collections.sort(arr);

            if(arr.size() < N+1) {
                System.out.println(-1);
            } else {
                System.out.println(arr.get(N));
            }
        }

    }

    static void dfs(long num, int numLength) {
        if(numLength > 10) {
            return;
        }
        arr.add(num);
        for(int i = 0; i < 10; i++) {
            if(num % 10 > i) {
                dfs((num * 10) + i,  numLength+1);
            }
        }
    }
}
