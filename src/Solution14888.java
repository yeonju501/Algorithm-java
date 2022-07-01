import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14888 {
    static int N;
    static int max = -1000000000;
    static int min = 1000000000;
    static int[] nums, op;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
//6
//1 2 3 4 5 6
//2 1 1 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        op = new int[4];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int val) {
        if(depth == N) {
            if(val > max) {
                max = val;
            }
            if(val < min) {
                min = val;
            }
            return;
        }
        for(int j = 0; j < 4; j++) {
            if(op[j] > 0){
                op[j]--;
                if(j == 0) {
                    dfs(depth+1, val+nums[depth]);
                } else if (j == 1) {
                    dfs(depth+1, val-nums[depth]);
                } else if (j == 2) {
                    dfs(depth+1, val*nums[depth]);
                } else {
                    dfs(depth+1, val/nums[depth]);
                }
                op[j]++;
            }
        }
    }
}
