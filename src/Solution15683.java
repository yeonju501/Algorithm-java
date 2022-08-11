import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution15683 {
    static int N, M, cctvNum, min = 70;
    static int[][][] direction;
    static int[][] map;
    static ArrayList<boolean[]> visited;
    static int[] dx = {0, 0, -1, 1}; //좌우 상하
    static int[] dy = {-1, 1, 0, 0};
    static int[] arr, s = {0, 4, 2, 4, 4, 1};
    static ArrayList<Cctv> cctvList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
//4 6
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 1 0 6 0
//0 0 0 0 0 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        direction = new int[][][] { {{}},
            {
                {0}, {1}, {2}, {3},
            },
            {
                {0, 1},
                {2, 3}
            },
            {
                {0, 2},
                {1, 2},
                {0, 3},
                {1, 3}
            },
            {
                {0, 1, 2},
                {0, 1, 3},
                {0, 2, 3},
                {1, 2, 3}
            },
            {
                {0, 1, 2, 3}
            }
        };

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0 && map[i][j] < 6) {
                    cctvList.add(new Cctv(i, j, map[i][j]));
                    cctvNum++;
                }
            }
        }

        visited = new ArrayList<>();
        for(int i = 0; i < cctvNum; i++) {
            visited.add(new boolean[s[cctvList.get(i).idx]]);
        };
        arr = new int[cctvNum];

        dfs(0);
        System.out.println(min);
    }

    static void dfs(int depth) {
        if(depth == cctvNum) {
            bfs();
            return;
        }
        // cctv 경우의 수
        for(int j = 0; j < s[cctvList.get(depth).idx]; j++) {
            if(!visited.get(depth)[j]) {
                arr[depth] = j;
                visited.get(depth)[j] = true;
                dfs(depth + 1);
                arr[depth] = 0;
                visited.get(depth)[j] = false;
            }

        }

    }
    static void bfs() {
        int[][] copyMap = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        for(int k = 0; k < cctvNum; k++) {
            Cctv cctv = cctvList.get(k);
            for(int i = 0; i < direction[cctv.idx][arr[k]].length; i++) {
                int x = cctv.x;
                int y = cctv.y;
                while(true) {
                    x += dx[direction[cctv.idx][arr[k]][i]];
                    y += dy[direction[cctv.idx][arr[k]][i]];
                    if(isWall(x, y)) break;
                    if(copyMap[x][y] == 6) break;
                    copyMap[x][y] = cctv.idx;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        min = Math.min(min, cnt);
    }

    static boolean isWall(int x, int y) {
        if(x >= N || x < 0 || y >= M || y < 0) {
            return true;
        }
        return false;
    }

    static class Cctv {
        int x;
        int y;
        int idx;
        Cctv(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

}
