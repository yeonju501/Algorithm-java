import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution15686 {
    static int N, M;
    static int ans = 987654321;
    static int[][] map;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> houses = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
//5 3
//0 0 1 0 0
//0 0 2 0 1
//0 1 2 0 0
//0 0 1 0 0
//0 0 0 0 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    chickens.add(new int[] {i, j});
                } else if(map[i][j] == 1) {
                    houses.add(new int[] {i, j});
                }
            }
        }

        visited = new boolean[chickens.size()];
        cal(0, 0);
        System.out.println(ans);
    }

    static void cal(int idx, int depth){
        if(depth == M) {
            ArrayList<int[]> comb = new ArrayList<>();
            for(int i = 0; i < chickens.size(); i++) {
                if(visited[i]) {
                    comb.add(chickens.get(i));
                }
            }

            int sum = 0;
            for(int i = 0; i < houses.size(); i++) {
                int min = 987654321;
                int[] xyHouse = houses.get(i);
                int xHouse = xyHouse[0];
                int yHouse = xyHouse[1];
                for(int j = 0; j < comb.size(); j++) {
                    int[] xyChicken = comb.get(j);
                    int xChicken = xyChicken[0];
                    int yChicken = xyChicken[1];
                    min = Math.min(min, Math.abs(xHouse-xChicken) + Math.abs(yHouse-yChicken));
                }
                sum += min;
            }
            ans = Math.min(sum, ans);
        }

        for(int i = idx; i < chickens.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                cal(i+1, depth+1);
                visited[i]= false;
            }
        }
    }

}
