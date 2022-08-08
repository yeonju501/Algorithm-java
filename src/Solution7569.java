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
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Tomato> q = new LinkedList<>();
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

        boolean all_ripe = true;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < M; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < N; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 0) {
                        all_ripe = false;
                    }
                    if(map[i][j][k] == 1) {
                        q.add(new Tomato(i, j, k));
                    }
                }
            }
        }

        bfs();
        int max = check();

        if(all_ripe) {
            System.out.println(0);
        } else {
            System.out.println(max-1);
        }
    }

    static int check() {
        int max = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    max = Math.max(max, map[i][j][k]);
                    if(map[i][j][k] == 0){
                        return 0;
                    }
                }
            }
        }
        return max;
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Tomato to = q.poll();
            for(int i = 0; i < 6; i++) {
                int nx = to.x + dx[i]; int ny = to.y + dy[i]; int nz = to.z + dz[i];
                if(isWall(nz, nx, ny)) continue;
                if(map[nz][nx][ny] != 0) continue;
                map[nz][nx][ny] = map[to.z][to.x][to.y] + 1;
                q.add(new Tomato(nz, nx, ny));
            }
        }

    }

    static boolean isWall(int nz, int nx, int ny) {
        if(nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) {
            return true;
        }
        return false;
    }

    static class Tomato {
        int x, y, z;
        Tomato(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

}
