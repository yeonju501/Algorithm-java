import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2667 {
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int aptCnt;
    static int N;
    static int[] apt = new int[25 * 25];


    public static void main(String[] args) throws IOException {
//7
//0110100
//0110101
//1110101
//0000111
//0100000
//0111110
//0111000
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    aptCnt++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(aptCnt);
        Arrays.sort(apt);
        for(int i = 0; i < apt.length; i++) {
            if(apt[i] != 0) {
                System.out.println(apt[i]);
            }
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        apt[aptCnt]++;
        for(int i = 0 ; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(!visited[nx][ny] && arr[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }

}
