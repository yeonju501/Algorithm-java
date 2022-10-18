import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution2606 {
    static int N;
    static int M;
    static ArrayList<Integer> arr[];
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
//7
//6
//1 2
//2 3
//1 5
//5 2
//5 6
//4 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i = 1; i < N + 1; i++) {
            Collections.sort(arr[i]);
        }

        dfs(1);

        System.out.println(cnt);
    }

    static void dfs(int idx) {
        visited[idx] = true;
        for(int i: arr[idx]) {
            if(!visited[i]){
                visited[i] = true;
                cnt++;
                dfs(i);
            }
        }
    }

}
