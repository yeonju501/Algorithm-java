public class Combination {

    static int[] se = new int[5];
    static int n = 8;
    static boolean[] visited = new boolean[n];
    public static void main(String[] args) {
        dfs(1, 0);
    }
    static void dfs(int idx, int depth) {
        if(depth == 5) {
            for(int i = 0; i < n; i++) {
                if(visited[i]) System.out.print(i + " ");
            }
            System.out.println("");
            return;
        }
        for(int i = idx; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                se[depth] = i;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

}
