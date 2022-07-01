import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution14889 {
    static int N;
    static int min = 987654321;
    static boolean[] visited;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
//4
//0 1 2 3
//4 0 5 6
//7 1 0 2
//3 4 5 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(min);
    }

    static void dfs(int idx, int depth) {
        if(depth == N/2) {
            cal();
            return;
        }
        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    static void cal() {
        int start = 0;
        int link = 0;
        for(int i = 0; i < N-1; i++) {
            for(int j = i+1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    start += arr[i][j] + arr[j][i];
                } else if(!visited[i] && !visited[j]) {
                    link += arr[i][j] + arr[j][i];
                }
            }
        }

        int val = Math.abs(start - link);

        min = Math.min(min, val);
    }

}
