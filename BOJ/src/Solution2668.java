import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution2668 {
    static int[] arr;
    static boolean[] visited;
    static int N, num;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
//7
//3
//1
//1
//5
//5
//4
//6
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < N+1; i++) {
            visited[i] = true;
            num = i;
            dfs(i);
            visited[i] = false;
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for(int a : ans) {
            System.out.println(a);
        }
    }

    static void dfs(int i) {
        if(arr[i] == num) {
            ans.add(num);
        }
        if(!visited[arr[i]]) {
            visited[arr[i]] = true;
            dfs(arr[i]);
            visited[arr[i]] = false;
        }
    }

}
