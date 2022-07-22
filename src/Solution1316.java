import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1316 {
    public static void main(String[] args) throws IOException {
//3
//happy
//new
//year
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] used;
        int ans = 0;
        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            used = new boolean[27];
            boolean flag = false;
            for(int j = 0; j < word.length(); j++) {
                int idx = word.charAt(j) - 'a';
                if(!used[idx]) {
                    used[idx] = true;
                } else if(used[idx] && word.charAt(j-1) != word.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}
