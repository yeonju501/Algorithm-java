public class SolutionGlass {

    static int N = 10;
    static int K = 5;
    public static void main(String[] args) {

        int ans = 0;
        if(N >= K) {
            ans = 1;
        } else {
            for(int i = N; i > 0; i--) {
                if((K - i) >= 0) {
                    K -= i;
                    ans++;
                }
                if(K == 0) {
                    break;
                }
            }
            if(K > 0) {
                ans = -1;
            }
        }

        System.out.println(ans);



    }

}
