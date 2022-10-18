import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1158 {
    static int N;
    static int K;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N+1; i++) {
            q.add(i);
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()){
            if(cnt < K-1){
                q.add(q.poll());
                cnt++;
            } else {
                sb.append(q.poll() + ", ");
                cnt = 0;
            }
        }
        sb.delete(sb.lastIndexOf(","), sb.lastIndexOf(",")+2);
        sb.append(">");
        System.out.println(sb);

    }

}
