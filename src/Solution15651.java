import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution15651 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
//4 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if(depth == M) {
            for(int a: arr){
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i < N+1; i++) {
            arr[depth] = i;
            dfs(depth+1);
        }
    }

}
