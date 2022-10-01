import java.util.LinkedList;
import java.util.Queue;

public class SolutionCountry {

    static String[] maps = {"AABCA.QA", "AABC..QX", "BBBC.Y..", ".A...T.A", "....EE..", ".M.XXEXQ", "KL.TBBBQ"};

    static char[][] map;
    static int[][] visited;
    static int n, m, cn = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {

        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }

        cn = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && map[i][j] != '.') {
                    cn++;
                    bfs(i, j);
                }
            }
        }

        int[] cnt = new int[26];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != '.'){
                    cnt[map[i][j] - 'A']++;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i]);
        }
        System.out.println(max);

    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        int[] cnt = new int[26];
        visited[x][y] = cn;
        cnt[map[x][y] - 'A']++;
        q.add(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] xy = q.poll();
            x = xy[0];
            y = xy[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny] == cn) continue;
                if(map[nx][ny] == '.') continue;
                visited[nx][ny] = cn;
                cnt[map[nx][ny] - 'A']++;
                q.add(new int[] {nx, ny});
            }
        }

        int max = 0;
        int maxIdx = 0;
        for(int i = 0; i < 26; i++) {
            if(max <= cnt[i]) {
                max = cnt[i];
                maxIdx = i;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == cn && cnt[map[i][j]-'A'] < cnt[maxIdx]) {
                    map[i][j] = (char)(maxIdx + 'A');
                }
            }
        }
    }

}
