import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1475 {
    public static void main(String[] args) throws IOException {
//9999
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int[] arr = new int[10];
        for(int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if(n == 6) {
                if(arr[n] > arr[9]) {
                    arr[9]++;
                } else {
                    arr[n]++;
                }
            } else if(n == 9) {
                if(arr[n] > arr[6]) {
                    arr[6]++;
                } else {
                    arr[n]++;
                }
            } else{
                arr[n]++;
            }
        }
        int max = 0;
        for(int i = 0; i < 10; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}
