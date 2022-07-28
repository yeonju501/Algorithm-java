import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1138 {
    static int N;
    static int[] arr;
    static int[] ans;
    public static void main(String[] args) throws IOException{
//4
//2 1 1 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        ans = new int[N+1];
        for(int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int cnt = arr[i];
            for(int j = 1; j < N+1; j++) {
                if (cnt == 0 && ans[j] == 0) {
                    ans[j] = i;
                    break;
                }
                if(ans[j] == 0) {
                    cnt--;
                }
            }
        }
        for(int i = 1; i < N+1; i++){
            System.out.print(ans[i]);
            System.out.print(" ");
        }
    }

}
