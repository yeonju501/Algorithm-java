import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution24480 {
    static int N;
    static int M;
    static int R;
    static ArrayList<Integer> arr[];
    static int[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
//5 5 1
//1 4
//1 2
//2 3
//2 4
//3 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N+1];
        visited = new int[N+1];

        for(int i = 1; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for(int i = 1; i < N+1; i++) {
            Collections.sort(arr[i], Comparator.reverseOrder());
        }

        dfs(R);
        for(int i = 1; i < N+1; i++){
            System.out.println(visited[i]);
        }
    }

    static void dfs(int idx) {
        visited[idx] = ++cnt;
        for(int i: arr[idx]){
            if(visited[i] == 0) {
                dfs(i);
            }
        }

    }

}
