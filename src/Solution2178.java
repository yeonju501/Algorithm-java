import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution2178 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
//4 6
//101111
//101010
//101011
//111011
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        int[] xy = {x, y};
        q.add(xy);
        while(!q.isEmpty()) {
            xy = q.poll();
            x = xy[0];
            y = xy[1];
            if(x == N-1 && y == M-1) {
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(arr[nx][ny] != 0 && !visited[nx][ny]) {
                        visited[nx][ny]= true;
                        arr[nx][ny] = arr[x][y] + 1;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }

    }

}
