import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15652 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
//4 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M+1];
        visited = new boolean[N+1];

        dfs(1);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == M+1) {
            for(int i = 1; i < M+1; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i < N+1; i++) {
            if(arr[depth-1] <= i) {
                arr[depth] = i;
                dfs(depth+1);
            }
        }
    }
}
