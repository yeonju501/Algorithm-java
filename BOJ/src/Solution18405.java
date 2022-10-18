import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution18405 {

//3 3
//1 0 2
//0 0 0
//3 0 0
//2 3 2
    static int n, k, sec, x, y;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Virus> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0) {
                    visited[i][j] = true;
                    q.add(new Virus(i, j, map[i][j]));
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        sec = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        bfs();
        System.out.print(map[x-1][y-1]);
    }

    static void bfs() {
        for(int k = 0; k < sec; k++) {
            int s = q.size();
            for(int i = 0; i < s; i++) {
                Virus vi = q.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = vi.x + dx[j];
                    int ny = vi.y + dy[j];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(map[nx][ny] <= vi.v && map[nx][ny] != 0) continue;
                    if((map[nx][ny] > vi.v && map[nx][ny] != 0) || map[nx][ny] == 0) {
                        map[nx][ny] = vi.v;
                        q.add(new Virus(nx, ny, vi.v));
                    }
                }
            }
        }
    }

    static class Virus{
        int x, y, v;

        Virus(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

}
