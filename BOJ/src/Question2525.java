import java.util.Scanner;

public class Question2525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int result = 0;
        int [] b = new int[4];
        for(int i = 0; i < a.length(); i++) {
            b[i] = a.charAt(i) - '0';
            result += b[i];
        }
        System.out.println(result);
    }
}
