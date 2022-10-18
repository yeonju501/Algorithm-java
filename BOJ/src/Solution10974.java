import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10974 {
    static int N;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
//3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        arr = new int[N+1];
        sb = new StringBuilder();
        dfs(1);
        System.out.println(sb);


    }

    static void dfs(int depth) {
        if(depth == N+1) {
            for(int i = 1; i <= N; i++){
                sb.append(arr[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(!visited[i]){
                visited[i] = true; // 들어가는 수가 i
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

}
