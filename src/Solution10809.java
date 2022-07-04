import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10809 {
    public static void main(String[] args) throws IOException {
//baekjoon
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        for(int i = 0; i < 26; i++) {
            arr[i] = -1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(arr[s.charAt(i) - 'a'] == -1) {
                arr[s.charAt(i) - 'a'] = i;
            }
        }

        for(int a: arr){
            System.out.print(a + " ");
        }
    }

}
