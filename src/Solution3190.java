import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution3190 {

    static int N, K, L;
    static int[][] board;
    static int[][] dir;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static List<int[]> snake;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        board = new int[N][N];
        snake = new LinkedList<>();
        snake.add(new int[] {0, 0});
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x-1][y-1] = 2;
        }

        L = Integer.parseInt(br.readLine());
        dir = new int[L][2];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            dir[i][0] = x;
            char temp = st.nextToken().charAt(0);
            dir[i][1] = (temp == 'L') ? -1 : 1;
        }

        int time = check(0, 0, 0);
        System.out.println(time);
    }

    static int check(int x, int y, int d) {
        int time = 0;
        int turn = 0;
        while (true) {
            time++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isFinished(nx, ny)) break;
            if (board[nx][ny] == 2) {
                snake.add(new int[]{nx, ny});
                board[nx][ny] = -1;
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0); // 꼬리 삭제
            }
            x = nx;
            y = ny;

            if (turn < L) {
                if (time == dir[turn][0]) {
                    d = nextDir(d, dir[turn][1]);
                    turn++;
                }
            }
        }
        return time;
    }

    static boolean isFinished(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= N) {
            return true;
        }
        for(int i = 0; i < snake.size(); i++) {
            int[] s = snake.get(i);
            if(s[0] == x && s[1] == y) return true;
        }
        return false;
    }

    static int nextDir(int cur, int dir) {
        int next = (cur + dir) % 4;
        if(next == -1) next = 3;
        return next;
    }
}