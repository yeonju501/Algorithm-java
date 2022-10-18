import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2023 {
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
//4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int num, int depth) {
        if(depth == N) {
            if(isPrime(num)) {
                sb.append(num + "\n");
            }
        }
        for(int i = 1; i <= 9; i++) {
            int n = num * 10 + i;
            if(isPrime(n)) {
                dfs(n, depth+1);
            }
        }
    }

    static boolean isPrime(int num) {
        if(num == 1) return false;

        int sqrt = (int) Math.sqrt(num);
        for(int i = 2; i <= sqrt; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

}
