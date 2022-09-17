import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution24891 {
    static int l, n;
    static String[] word, pickedWord;
    static boolean[] visited;
    static int[] picked;
    static ArrayList<String[]> mabang = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        word = new String[n];
        mabang = new ArrayList<>();
        visited = new boolean[n];
        picked = new int[n];
        pickedWord = new String[l];

        for(int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }
        // 1. 먼저 정렬을 한다.
        Arrays.sort(word);

        // 2. 순열을 만들어서 배열로 만든다.
        // 3. 체크를 하고 바로 출력
        dfs(0);

        System.out.println("NONE");
    }

    static void dfs(int depth) {
        if(depth == l) {
            for(int i = 0; i < l; i++) {
                pickedWord[i] = word[picked[i]];
            }
            if(check()){
                for(int i = 0; i < l; i++) {
                    for(int j = 0; j < l; j++) {
                        System.out.print(pickedWord[i].charAt(j));
                    }
                    System.out.println("");
                }
                System.exit(0);
            };
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                // 순열의 경우 순서가 상관있기 때문에 결과 배열이 필요
                // 그리고 dfs는 모든 재귀를 먼저 실행하고 다음 메소드를 실행한다고 보면 된다.
                picked[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    static boolean check() {
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                if(pickedWord[i].charAt(j) != pickedWord[j].charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
