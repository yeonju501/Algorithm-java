import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1106 {
    static int C, N;
    static int[] dp;
    static ArrayList<Ad> ads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//12 2
//3 5
//1 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[C + 101];
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            ads.add(new Ad(person, price));
        }

        for(int i = 1; i < C + 101; i++) {
            int temp = 987654321;
            for(Ad ad : ads) {
                int per = ad.person;
                int pri = ad.price;
                // dp[i]
                if(i - per >= 0 && temp > dp[i-per] + pri) {
                    temp = dp[i-per] + pri;
                }
            }
            dp[i] = temp;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = C; i < C+101; i++) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);



    }

    static class Ad {
        int person;
        int price;
        Ad (int person, int price){
            this.person = person;
            this.price = price;
        }
    }

}
