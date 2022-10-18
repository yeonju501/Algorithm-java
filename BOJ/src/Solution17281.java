import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution17281 {

    static int[] order;
    static int[][] players;
    static boolean[] base, visited;
    static int max, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        order = new int[9];
        players = new int[n][9];
        base = new boolean[4];
        visited = new boolean[9];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true;
        order[3] = 0;
        dfs(0);
        System.out.println(max);
    }

    static void dfs(int depth) {
        if(depth == 9) {
            playBaseball();
            return;
        }

        if(depth == 3) {
            dfs(depth+1);
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    static void playBaseball() {
        int startPlayer = 0;
        int score = 0;
        for(int i = 0; i < n; i++) {
            int outCnt = 0;
            base = new boolean[4];
            outer: while(true) {
                for(int j = startPlayer; j < 9; j++) {
                    int hitter = players[i][order[j]];
                    switch (hitter) {
                        case 0: outCnt++; break;
                        case 1:
                            for(int k = 3; k > 0; k--) {
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
                            for(int k = 3; k > 0; k--) {
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
                            for(int k = 3; k > 0; k--) {
                                if(base[k]) {
                                    score++;
                                    base[k] = false;
                                }
                            }
                            score++;
                            break;
                    }
                    if(outCnt == 3) {
                        startPlayer = j+1;
                        if(startPlayer == 9) {
                            startPlayer = 0;
                        }
                        break outer;
                    }
                }
                startPlayer = 0;
            }
        }
        max = Math.max(max, score);
    }
}
