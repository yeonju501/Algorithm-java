import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2805 {

    static int N;
    static int K;
    static long[] arr;
    static boolean check(long mid) {
        long cnt = 0;
        for(int i = 0; i < N; i++) {
            long val = arr[i] - mid;
            if(val > 0) {
                cnt += val;
            }
        }
        return cnt >= K;
    }
    public static void main(String[] args) throws IOException {
//4 7
//20 15 10 17
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        long max = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        long left = 0;
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
