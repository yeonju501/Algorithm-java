import java.util.Scanner;

public class Solution10950 {
//5
//1 1
//2 3
//3 4
//9 8
//5 2
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(sc.nextInt() + sc.nextInt());
        }
        sc.close();
    }
}
