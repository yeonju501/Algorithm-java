import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10992 {
    public static void main(String[] args) throws IOException {
//   *
//  * *
// *   *
//*******
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            if(i == N) {
                for(int j = 0; j < 2*i-1; j++) {
                    System.out.print("*");
                }
                continue;
            }
            for(int j = 0; j < N-i; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < 1; j++) {
                System.out.print("*");
            }
            for(int j = 0 ; j < 2*(i-1)-1; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < 1; j++) {
                if(i == 1) {
                    continue;
                }
                System.out.print("*");
            }
            System.out.println("");
        }
    }

}
