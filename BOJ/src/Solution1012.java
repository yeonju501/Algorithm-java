import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution1012 {
//2
//10 8 17
//0 0
//1 0
//1 1
//4 2
//4 3
//4 5
//2 4
//3 4
//7 4
//8 4
//9 4
//7 5
//8 5
//9 5
//7 6
//8 6
//9 6
//10 10 1
//5 5
    static int M;
    static int N;
    static int K;
    static int arr[][];
    static boolean visited[][];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            visited = new boolean[M][N];
            int cnt = 0;

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[X][Y] = 1;
            }

            for(int j = 0; j < M; j++) {
                for(int z = 0; z < N; z++) {
                    if(arr[j][z] == 1 && !visited[j][z]) {
                        cnt++;
                        dfs(j, z);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
                if(!visited[nx][ny] && arr[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
