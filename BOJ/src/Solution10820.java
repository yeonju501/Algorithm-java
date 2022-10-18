import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10820 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
//This is String
//SPACE    1    SPACE
//S a M p L e I n P u T
//0L1A2S3T4L5I6N7E8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null){
            arr = new int[4];
            for(int i = 0; i < s.length(); i++) {
                if(Character.isUpperCase(s.charAt(i))){
                    arr[1]++;
                } else if(Character.isLowerCase(s.charAt(i))) {
                    arr[0]++;
                } else if(Character.isDigit(s.charAt(i))) {
                    arr[2]++;
                } else if(s.charAt(i) == ' ') {
                    arr[3]++;
                }
            }
            for(int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println("");
        };
    }

}
