import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1987 {

    static int r, c, max;
    static char[][] map;
    static boolean[] alpha;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
//2 4
//CAAB
//ADCB
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }


        alpha = new boolean[30];
        visited = new boolean[r][c];

        alpha[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int x, int y, int depth) {
        if(max < depth) {
            max = depth;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isWall(nx, ny)) continue;
            if(visited[nx][ny]) continue;
            if(alpha[map[nx][ny] - 'A']) continue;
            visited[nx][ny] = true;
            alpha[map[nx][ny] - 'A'] = true;
            dfs(nx, ny, depth+1);
            visited[nx][ny] = false;
            alpha[map[nx][ny] - 'A'] = false;
        }
    }

    static boolean isWall(int x, int y) {
        if(x >= r || x < 0 || y >= c || y < 0) {
            return true;
        }
        return false;
    }

}
