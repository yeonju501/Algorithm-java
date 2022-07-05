import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution16234 {

    static int N, L, R, cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
//2 20 50
//50 30
//20 40
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        cnt = 0;
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(flag){
            flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }
            if(flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        int val = arr[x][y];
        int num = 1;
        q.add(new int[] {x, y});
        Queue<int[]> nara = new LinkedList<>();
        nara.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            x = xy[0];
            y = xy[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int gap = Math.abs(arr[x][y] - arr[nx][ny]);
                    if (gap >= L && gap <= R && !visited[nx][ny]) {
                        flag = true;
                        visited[nx][ny] = true;
                        val += arr[nx][ny];
                        num++;
                        q.add(new int[] {nx, ny});
                        nara.add(new int[] {nx, ny});
                    }
                }
            }
        }

        while(!nara.isEmpty()) {
            int[] xy = nara.poll();
            x = xy[0];
            y = xy[1];
            arr[x][y] = val/num;
        }
    }

}
