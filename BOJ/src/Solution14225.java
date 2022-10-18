import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution14225 {

    static int[] arr, num, se;
    static int n;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n+1];
        visited = new boolean[n+1];
        se = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        arr = new int[2000001];
        dfs(0, 0, 0);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 0){
                System.out.println(i);
                break;
            }
        }


    }

    static void dfs(int idx, int depth, int sum) {
        arr[sum] = 1;
        if(depth == n) {
            return;
        }
        for(int i = idx; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1, sum+num[i]);
                visited[i] = false;
            }
        }
    }

}
