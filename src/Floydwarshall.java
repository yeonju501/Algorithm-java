import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floydwarshall {
/*
sample input(첫 번째 숫자는 노드의 개수, 두 번째 숫자는 간선의 개수 이다).
5
8
0 1 5
0 4 1
0 2 7
0 3 2
1 2 3
1 3 6
2 3 10
3 4 4
 */

    static int n, m;
    static int[][] dist;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n][n];
        // 테이블 초기화
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = 1000000000;
            }
        }

        // 간선 거리 저장
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], d);
            dist[b][a] = Math.min(dist[b][a], d);
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
