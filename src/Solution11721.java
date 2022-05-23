import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution11721 {
    public static void main(String[] args) throws IOException {
//OneTwoThreeFourFiveSixSevenEightNineTen
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length() / 10;
        for(int i = 0; i < n; i++) {
            System.out.println(str.substring(i*10, i*10+10));
        }
        n = str.length() % 10;
        System.out.println(str.substring(str.length()-n));
    }

}
