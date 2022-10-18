import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1920 {
    static int[] nums;
    static int[] arr;
    public static void main(String[] args) throws IOException {
//5
//4 1 5 2 3
//5
//1 3 7 9 5
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int M  = Integer.parseInt(br.readLine());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        for(int i : arr){
            System.out.println(binarySearch(i));
        }
    }

    static int binarySearch(int num){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] > num) {
                right = mid - 1;
            } else if (nums[mid] < num) {
                left = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
