import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution3055 {

    static int r, c, ans, x, y;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Water> q = new LinkedList<>();
    static Queue<int[]> bq = new LinkedList<>();
    static int[][] visited;

    static class Water {
        int x, y;
        Water(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new int[r][c];
        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'D') {
                    x = i;
                    y = j;
                }
                if(map[i][j] == '*') {
                    q.add(new Water(i, j));
                }
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'S') {
                    bq.add(new int[] {i, j});
                }
            }
        }

        check();
        if(visited[x][y] == 0){
            System.out.println("KAKTUS");
        } else {
            System.out.println(visited[x][y]);
        }
    }

    static void check() {
        int sec = 0;
        while(visited[x][y] == 0) {
            bfs(sec);
            bfs2(sec);
            if(bq.size()== 0) break;
            sec++;
        }
    }
    static void bfs(int sec) {
        int size = q.size();
        for(int j = 0; j < size; j++) {
            Water curT = q.poll();
            int x = curT.x;
            int y = curT.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (map[nx][ny] == '*' || map[nx][ny] == 'X' || map[nx][ny] == 'D') continue;
                if(visited[nx][ny] != 0) continue;
                map[nx][ny] = '*';
                visited[nx][ny] = sec+1;
                q.add(new Water(nx, ny));
            }
        }
    }

    static void bfs2(int sec) {
        int size = bq.size();
        for(int j = 0; j < size; j++){
            int[] xy = bq.poll();
            int x = xy[0];
            int y = xy[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
                if(visited[nx][ny] != 0) continue;
                visited[nx][ny] = sec+1;
                if(map[nx][ny] == 'D') return;
                bq.add(new int[]{nx, ny});
            }
        }
    }
}
