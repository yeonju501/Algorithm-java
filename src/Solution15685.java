import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution15685 {
    static boolean[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
//x, y, d, g
//3
//3 3 0 1
//4 2 1 3
//4 2 2 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragon(x, y, d, g);
        }
        int ans = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static void dragon(int x, int y, int d, int g) {
        ArrayList<Integer> dir= new ArrayList<>();
        dir.add(d);
        for(int i = 0; i < g; i++){
            for(int j = dir.size() - 1; j >= 0; j--) {
                dir.add((dir.get(j)+1) % 4);
            }
        }
        map[y][x] = true;
        for(int i = 0; i < dir.size(); i++) {
            y += dx[dir.get(i)];
            x += dy[dir.get(i)];
            map[y][x] = true;
        }
    }

}
