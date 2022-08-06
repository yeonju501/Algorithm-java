import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7569 {
    static int M, N, H; // 가로, 세로, 높이
    static int[][][] map;
    static int[][][] visited;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
//5 3 1
//0 -1 0 0 0
//-1 -1 0 1 1
//0 0 0 1 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][M][N];
        visited = new int[H][M][N];

        boolean all_ripe = false;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    visited[i][j][k] = Integer.MAX_VALUE;
                    if(map[i][j][k] == 0) {
                        all_ripe = true;
                    }
                }
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    if(map[i][j][k] == 1) {
                        q.add(new int[] {i, j, k, 0});
                    }
                }
            }
        }

        bfs();
        int max = check();

        if(!all_ripe) {
            System.out.println(0);
        } else {
            System.out.println(max);
        }
    }

    static int check() {
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    if(visited[i][j][k] != Integer.MAX_VALUE) {
                        max = Math.max(max, visited[i][j][k]);
                    }
                    if(map[i][j][k] == 0){
                        flag = true;
                    }
                }
            }
        }
        if(flag) {
           return -1;
        } else {
            return max;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] zxy = q.poll();
            int z = zxy[0]; int x = zxy[1]; int y = zxy[2]; int pos = zxy[3];
            for(int i = 0; i < 6; i++) {
                int nx = x + dx[i]; int ny = y + dy[i]; int nz = z + dz[i];
                if(isWall(nz, nx, ny)) continue;
                if(map[nz][nx][ny] != 0) continue;
                if(visited[nz][nx][ny] < pos + 1) continue;
                visited[nz][nx][ny] = pos + 1;
                map[nz][nx][ny] = 1;
                q.add(new int[] {nz, nx, ny, pos + 1});
            }
        }

    }

    static boolean isWall(int nz, int nx, int ny) {
        if(nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) {
            return true;
        }
        return false;
    }

}
