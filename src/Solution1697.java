import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1697 {
    static int[] map;
    static int n, k, min = 987654321;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[100001];
        bfs();
        System.out.println(map[k] - 1);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        map[n] = 1;
        while(!q.isEmpty()) {
            int val = q.poll();
            if(val == k) break;
            if(check(val+1) && map[val+1] == 0) {
                map[val+1] = map[val] + 1;
                q.add(val+1);
            }
            if(check(val-1) && map[val-1] == 0) {
                map[val-1] = map[val] + 1;
                q.add(val-1);
            }
            if(check(val * 2) && map[val * 2] == 0) {
                map[val * 2] = map[val] + 1;
                q.add(val * 2);
            }
        }
    }

    static boolean check(int v) {
        if(v >= 0 && v <= 100000) {
            return true;
        }
        return false;
    }

}
