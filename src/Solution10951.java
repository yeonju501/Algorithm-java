import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution10951 {
//1 1
//2 3
//3 4
//9 8
//5 2
    public static void main(String[] args) throws IOException {

//        solution 1
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextInt()){
//            System.out.println(sc.nextInt() + sc.nextInt());
//        }
//        sc.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;

        while((str=br.readLine()) != null) {
            st = new StringTokenizer(str," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
        System.out.print(sb);
    }
}
