import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution17471 {
//6
//5 2 3 4 1 2
//2 2 4
//4 1 3 6 5
//2 4 2
//2 1 3
//1 2
//1 2
    static int n, min = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            for(int j = 0; j < l; j++) {
                adj.get(i).add(Integer.parseInt(st.nextToken())-1);
            }
        }

        visited = new boolean[n];
        dfs(0, 0);
        if(min == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(min);
        }
    }

    static void dfs(int idx, int depth) {
        if(depth > 0) {
            if(check()) {
                cal();
            }
        }
        if(depth == n) {
            return;
        }

        for(int i = idx; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

    static boolean check() {
        boolean[] c = new boolean[n];

        int cnt1 = -1;
        int cnt2 = -1;
        for(int i = 0; i < n; i++) {
            if(visited[i]) cnt1 = i;
            else cnt2 = i;
        }
        if(cnt1 == -1 || cnt2 == -1) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        c[cnt1] = true;
        q.add(cnt1);
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0; i < adj.get(now).size(); i++) {
                int next = adj.get(now).get(i);
                if(visited[now] != visited[next]) continue;
                if(c[next]) continue;
                c[next] = true;
                q.add(next);
            }
        }

        c[cnt2] = true;
        q.add(cnt2);
        while (!q.isEmpty()) {
            int now = q.poll();
            for(int i = 0; i < adj.get(now).size(); i++) {
                int next = adj.get(now).get(i);
                if(visited[now] != visited[next]) continue;
                if(c[next]) continue;
                c[next] = true;
                q.add(next);
            }
        }

        for(int i = 0; i < n; i++) {
            if(!c[i]) return false;
        }

        return true;
    }

    static void cal() {
        int d1 = 0;
        int d2 = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) d1 += p[i];
            else d2 += p[i];
        }
        min = Math.min(min, Math.abs(d1-d2));
    }

}
