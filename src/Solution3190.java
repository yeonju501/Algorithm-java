import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution3190 {

    static int n, k, l;
    static int[][] board;
    static List<int[]> snake;
    static int[][] dir;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        snake = new ArrayList<>();
        snake.add(new int[]{0, 0});

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x - 1][y - 1] = 1;
        }
        l = Integer.parseInt(br.readLine());
        dir = new int[l][2];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            dir[i][0] = Integer.parseInt(st.nextToken());
            char temp = st.nextToken().charAt(0);
            dir[i][1] = (temp == 'L') ? -1 : 1;
        }

        System.out.println(check(0, 0, 0));
    }

    static int check(int x, int y, int d) {
        int time = 0;
        int turn = 0;
        while (true) {
            time++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isFinished(nx, ny)) break;
            if (board[nx][ny] == 1) {
                snake.add(new int[]{nx, ny});
                board[nx][ny] = -1;
            } else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);
            }

            x = nx;
            y = ny;
            if (turn < l) {
                if (time == dir[turn][0]) {
                    d = nextDir(d, dir[turn][1]);
                    turn++;
                }
            }
        }
        return time;
    }

    static boolean isFinished(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n) {
            return true;
        }
        for(int i = 0; i < snake.size(); i++) {
            int[] s = snake.get(i);
            if(s[0] == x && s[1] == y) {
                return true;
            }
        }
        return false;
    }

    static int nextDir(int cur, int dir) {
        int next = (cur + dir) % 4;
        if(next == -1) next = 3;
        return next;
    }
}