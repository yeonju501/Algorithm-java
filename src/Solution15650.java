import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15650 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
//4 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M+1];
        visited = new boolean[N+1];

        dfs(1);
    }

    static void dfs(int depth) {
        if(depth == M+1) {
            for(int i = 1; i < M+1; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i < N+1; i++) {
            if(!visited[i] && arr[depth-1] < i) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }


}
