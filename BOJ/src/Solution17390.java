import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution17390 {
    public static void main(String[] args) throws IOException {
//5 6
//2 5 1 4 3
//1 5
//2 4
//3 3
//1 3
//2 5
//4 5
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] sum = new int[N+1];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        for(int i = 0; i < N; i++) {
//            int min_idx = i;
//            for(int j = i; j < N; j++) {
//                if(arr[j] < arr[min_idx]) {
//                    min_idx = j;
//                }
//            }
//            int tmp = arr[min_idx];
//            arr[min_idx] = arr[i];
//            arr[i] = tmp;
//
//        }

        Arrays.sort(arr);

        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i-1] + arr[i-1];
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            System.out.println(sum[R] - sum[L-1]);
        }

    }
}
