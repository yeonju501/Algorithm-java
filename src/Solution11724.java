import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution11724 {
    static int N;
    static int M;
    static ArrayList<Integer> arr[];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
//6 5
//1 2
//2 5
//5 1
//3 4
//4 6
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. 그래프 정의
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        // 2. 정점 별 간선 담기
       for(int i = 1; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 1; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        // 3. 간선 정렬
        for(int i = 1; i < N+1; i++) {
            Collections.sort(arr[i]);
        }

        int result = 0;
        for(int i = 1; i < N+1; i++) {
            if(!visited[i]) {
                bfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    static void bfs(int idx) {
        visited[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()) {
            int a = q.poll();
            for(int i: arr[a]) {
                // 4. 큐에 넣을 때 방문 체크
                if(!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
