import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution17281 {

    static int[] order;
    static boolean[] visited;
    static int[][] players;
    static int n, max;

    public static void main(String[] args) throws IOException {
        // 1. 모든 순열을 구한다. (4번은 고정)
        // 2. 이닝을 돈다 3아웃하면 마지막 번호 저장하고 다시 돈다. 득점 계산
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        order = new int[10];
        players = new int[n][10];
        visited = new boolean[10];

        StringTokenizer st;
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 9; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[4] = 1;
        visited[1] = true;
        dfs(1);
        System.out.println(max);
    }

    static void dfs(int depth) {
        if(depth == 10) {
            baseball();
            return;
        }

        if(depth == 4) {
            dfs(depth+1);
            return;
        }

        for(int i = 1; i <= 9; i++) {
            if(!visited[i]) {
                order[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    static void baseball(){
        int startPlayer = 1;
        int score = 0;
        for(int i = 1; i <= n; i++) {
            boolean[] base = new boolean[4];
            int outCnt = 0;
            outer: while(true) {
                for(int j = startPlayer; j <= 9; j++) {
                    int hitter = players[i][order[j]];
                    switch (hitter) {
                        case 0: outCnt++; break;
                        case 1:
                            for(int k = 3; k >= 1; k--) {
                                if(base[k]) {
                                    if(k == 3) {
                                        score++;
                                        base[k] = false;
                                        continue;
                                    }
                                    base[k+1] = true;
                                    base[k] = false;
                                }
                            }
                            base[1] = true;
                            break;
                        case 2:
                            for(int k = 3; k >= 1; k--) {
                              if(base[k]) {
                                  if(k == 3 || k == 2) {
                                      score++;
                                      base[k] = false;
                                      continue;
                                  }
                                  base[k+2] = true;
                                  base[k] = false;
                              }
                            }
                            base[2] = true;
                            break;
                        case 3:
                            for(int k = 3; k > 0; k--) {
                                if(base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            base[3] = true;
                            break;
                        case 4:
                            for(int k = 1; k <= 3; k++) {
                                if(base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            score++;
                            break ;
                    }
                    if(outCnt == 3) {
                        startPlayer = j+1;
                        if(startPlayer == 10) {
                            startPlayer = 1;
                        }
                        break outer;
                    }
                }
                startPlayer = 1;
            }
        }
        max = Math.max(max, score);
    }

}
