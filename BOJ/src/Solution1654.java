import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1654 {
    static long[] arr;
    static int K;
    static int N;

    static boolean check(long mid) {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            cnt += arr[i] / mid;
        }
        return cnt >= K;
    }

    public static void main(String[] args) throws IOException {
//4 11
//802
//743
//457
//539
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        long max = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        long left = 1;
        long right = max;
        long result = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            if(check(mid)) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
