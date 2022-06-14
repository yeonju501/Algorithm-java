import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1986 {

    static int n;
    static int m;
    static int[][] board;
    // 상 하 좌 우 우상 우하 좌상 좌하
    static int[] qi = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] qj = {-1, 1, 0, 0, -1, 1, -1, 1};

    static void qCheck(int i, int j) {
        for(int d = 0; d < 8; d++) {
            int ni = i;
            int nj = j;
            while(true) {
                ni += qi[d];
                nj += qj[d];
                if(ni >= 1 && ni <= n && nj >= 1 && nj <= m && (board[ni][nj] == 0 || board[ni][nj] == -1)){
                    board[ni][nj] = -1;
                } else {
                    break;
                }
            }
        }
    }

    static int[] ki = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] kj = {-1, -2, -2, -1, 1, 2, 2, 1};

    static void kCheck(int i, int j) {
        for(int d = 0; d < 8; d++) {
            int ni = i + ki[d];
            int nj = j + kj[d];
            if(ni >= 1 && ni <= n && nj >= 1 && nj <= m && (board[ni][nj] == 0)) {
                board[ni][nj] = -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
//4 4
//2 1 4 2 4
//1 1 2
//1 2 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];

        st = new StringTokenizer(br.readLine());
        int qCnt = Integer.parseInt(st.nextToken());
        for(int i = 0; i < qCnt; i++) {
            int qi = Integer.parseInt(st.nextToken());
            int qj = Integer.parseInt(st.nextToken());
            board[qi][qj] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int kCnt = Integer.parseInt(st.nextToken());
        for(int i = 0; i < kCnt; i++) {
            int ki = Integer.parseInt(st.nextToken());
            int kj = Integer.parseInt(st.nextToken());
            board[ki][kj] = 2;
        }

        st = new StringTokenizer(br.readLine());
        int pCnt = Integer.parseInt(st.nextToken());
        for(int i = 0; i < pCnt; i++) {
            int pi = Integer.parseInt(st.nextToken());
            int pj = Integer.parseInt(st.nextToken());
            board[pi][pj] = 3;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(board[i][j] == 1){
                    qCheck(i, j);
                } else if(board[i][j] == 2) {
                    kCheck(i, j);
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(board[i][j] == 0) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
