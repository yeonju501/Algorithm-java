import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution10026 {
    static int N, cnt, cnt2;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
//5
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cnt++;
                    dfs(i, j, arr[i][j]);
                }
                if(arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
        System.out.print(cnt + " ");

        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    cnt2++;
                    dfs(i, j, arr[i][j]);
                }
            }
        }

        System.out.print(cnt2);


    }

    static void dfs(int x, int y, char c) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if(arr[nx][ny] == c && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, c);
                }
            }
        }
    }
}
