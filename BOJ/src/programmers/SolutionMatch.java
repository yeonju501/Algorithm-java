import java.util.ArrayList;
import java.util.HashSet;

public class SolutionMatch {

    static int k = 6;

    static int[] match = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static boolean[] visited = new boolean[10];
    static HashSet<Integer> nums = new HashSet<>();
    public static void main(String[] args) {

        dfs(0, 1, 0);
        System.out.println(nums.size());
        Long.valueOf(nums.size());
    }

    static void dfs(int cnt, int depth, int num) {
        if(cnt >= k) {
            if(cnt == k) {
                nums.add(num);
            }
            return;
        }
        for(int i = 0; i < 10; i++) {
            if(depth == 1 && i == 0) {
                continue;
            }
            if(cnt + match[i] <= k) {
                dfs(cnt + match[i], depth+1, num * 10 + i);
            }
        }
    }

}
