import java.util.Scanner;

public class Question2025 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int a = sc.nextInt();
        for(int i=1; i <= a; i++) {
            result += i;
        }
        System.out.println(result);
    }

}
