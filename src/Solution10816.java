import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution10816 {

    static int N;
    static int M;
    static int[] cards;

    static int upperBound(int num) {
        int left = 0;
        int right = N;
        while(left < right) {
            int mid = (left + right) / 2;
            if(cards[mid] > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int lowerBound(int num) {
        int left = 0;
        int right = N;
        while(left < right) {
            int mid = (left + right) / 2;
            if(cards[mid] >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException {
//5
//6 3 2 10 -10
//8
//10 9 -5 2 3 4 5 -10
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        cards = new int[N];
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            bw.append(upperBound(num) - lowerBound(num) + " ");
        }
        bw.flush();
    }
}

