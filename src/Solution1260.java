import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution1260 {

    static int N;
    static int M;
    static int K;
    static ArrayList<Integer> arr[];
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        for(int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i = 0; i < N+1; i++) {
            Collections.sort(arr[i]);
        }

        dfs(K);
        visited = new boolean[N + 1];
        sb.append("\n");
        bfs(K);
        System.out.println(sb);
    }

    static void dfs(int idx) {
        visited[idx] = true;
        sb.append(idx + " ");
        for(int i: arr[idx]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int idx) {
        visited[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()) {
            int a = q.poll();
            sb.append(a + " ");
            for(int i: arr[a]) {
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
