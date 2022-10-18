import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution14502 {
    static int N, M, max;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
//7 7
//2 0 0 0 1 1 0
//0 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 1 1
//0 1 0 0 0 0 0
//0 1 0 0 0 0 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);
        System.out.println(max);
    }

    static void makeWall(int depth){
        if(depth == 3) {
            bfs();
            return;
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    makeWall(depth+1);
                    arr[i][j] = 0;
                }
            }
        }
    }
    static void bfs() {
        int[][] map = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                map[i][j] = arr[i][j];
                if(map[i][j] == 2){
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] virus = q.poll();
            int x = virus[0];
            int y = virus[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(map[nx][ny] == 0 ) {
                        map[nx][ny] = 2;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }
}
