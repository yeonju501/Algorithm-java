import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution10819 {
    static int N, max;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
//6
//20 1 15 8 4 10
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, new ArrayList<>());
        System.out.println(max);
    }

    static void dfs(int depth, ArrayList<Integer> list) {
        if (depth == N) {
            int sum = 0;
            for(int i = 0; i < list.size()-1; i++) {
                sum += Math.abs(list.get(i) - list.get(i+1));
            }
            max = Math.max(max, sum);
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                dfs(depth+1, list);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

}
