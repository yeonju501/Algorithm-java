import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1182 {
    static int N, S, cnt;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
//5 0
//-7 -3 -2 5 8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0, 0);
        System.out.println(cnt);
    }

    static void dfs(int idx, int sum, int depth) {
        if(sum == S && depth != 0) {
            cnt++;
        }
        for(int i = idx; i < N; i++){
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1,sum + nums[i], depth+1);
                visited[i] = false;
            }
        }
    }
}
