import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution1759 {
    static int L, C;
    static String[] letter;
    static boolean[] visited;
    static ArrayList<String> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
//4 6
//a t c i s w
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        letter = new String[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            letter[i] = st.nextToken();
        }
        Arrays.sort(letter);

        dfs(0, 0);

        Collections.sort(ans);
        for(String s: ans){
            System.out.println(s);
        }
    }

    static void dfs(int idx, int depth){
        if (depth == L) {
            boolean hasVowel = false;
            int consonantCnt = 0;
            String result = "";
            for(int i = 0; i < C; i++) {
                if(visited[i]){
                    result += letter[i];
                    if(letter[i].equals("a") || letter[i].equals("e") || letter[i].equals("i") || letter[i].equals("o") || letter[i].equals("u")){
                        hasVowel = true;
                    } else {
                        consonantCnt++;
                    }
                }
            }
            if(hasVowel && consonantCnt >= 2) {
                ans.add(result);
                return;
            }
            return;
        }

        for(int i = idx; i < C; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}
