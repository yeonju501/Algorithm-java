import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10808 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
//baekjoon
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a'] += 1;
        }

        for(int a : arr){
            System.out.print(a + " ");
        }
    }

}
