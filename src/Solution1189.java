
import java.io.IOException;
import java.util.Scanner;

public class Solution1189 {

    static int R, C, K, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
//3 4 6
//....
//.T..
//....
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = sc.nextLine().toCharArray();
        }
        visited[R-1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.println(cnt);
    }

    static void dfs(int x, int y, int depth) {
        if (depth == K){
            if(x == 0 && y == C - 1) {
                cnt++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != 'T' && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

}

