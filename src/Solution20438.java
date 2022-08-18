import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution20438 {

    static int n, k, q, m;
    static int[] ns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ns = new int[n+3];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int val = Integer.parseInt(st.nextToken());
            ns[val] = -1;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < q; i++) {
            int code = Integer.parseInt(st.nextToken());
            if (ns[code] == -1) continue;

            int num = code;
            while(num <= n+2) {
                if(ns[num] == 0) {
                    ns[num] = 1;
                }
                num += code;
            }
        }


        int[] cntArr = new int[n+3];
        int cnt = 0;
        for(int i = 3; i < ns.length; i++) {
            if(ns[i] <= 0) {
                cnt++;
            }
            cntArr[i] = cnt;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(cntArr[e] - cntArr[s-1] + "\n");
        }
        System.out.println(sb);
    }

}
