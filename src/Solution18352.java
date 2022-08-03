import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution18352 {
    static int N, M, K, X;
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    static int[] dist;
    public static void main(String[] args) throws IOException {
//4 4 2 1
//1 2
//1 3
//2 3
//2 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        for(int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
            dist[i] = -1;
        }

        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b); // 단방향
        }

        dist[X] = 0;
        bfs(X);
        boolean flag = false;
        for(int i = 1; i <= N; i++) {
            if(dist[i] == K) {
                flag = true;
                System.out.println(i);
            }
        }

        if(!flag) {
            System.out.println(-1);
        }
    }

    static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0; i < nodes.get(now).size(); i++) {
                int next = nodes.get(now).get(i);
                if(dist[next] == -1) { // 방문체크
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
