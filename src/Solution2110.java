import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2110 {
    static int N;
    static int C;
    static long[] arr;

    static boolean check(long mid) {
        long cnt = 1;
        int idx = 0;
        for(int i = 1; i < N; i++) {
            if((arr[i] - arr[idx]) >= mid) {
                cnt++;
                idx = i;
            }
        }
        return cnt >= C;
    }

    public static void main(String[] args) throws IOException {
//5 3
//1
//2
//8
//4
//9
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new long[N];
        long max = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);

        long left = 1;
        long right = max;
        long distance = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            if(check(mid)) {
                left = mid + 1;
                distance = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(distance);
    }
}
