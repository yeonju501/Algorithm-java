import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution10815 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
//5
//6 3 2 10 -10
//8
//10 9 -5 2 3 4 5 -10
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long[] cards = new long[N];
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long[] checkCards = new long[M];
        for(int i = 0; i < M; i++) {
            checkCards[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < M; i++) {
            int flag = 0;
            int leftIdx = 0;
            int rightIdx = N-1;
            while(checkCards[i] >= cards[leftIdx] && checkCards[i] <= cards[rightIdx]) {
                int midIdx = (leftIdx + rightIdx) / 2;
                if(cards[midIdx] < checkCards[i]) {
                    leftIdx = midIdx + 1;
                } else if(cards[midIdx] > checkCards[i]){
                    rightIdx = midIdx - 1;
                } else {
                    flag = 1;
                    leftIdx = midIdx;
                    break;
                }
            }
            if (flag == 1) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }
}
