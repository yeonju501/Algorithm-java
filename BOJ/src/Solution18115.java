import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution18115 {
//5
//1 1 1 1 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.reverse(list);
        for(int i = 0; i < n; i++) {
            int v = list.get(i);
            if(v == 1) {
                dq.addLast(i+1);
            } else if (v == 2) {
                int v2 = dq.removeLast();
                dq.addLast(i+1);
                dq.addLast(v2);
            } else if(v == 3) {
                dq.addFirst(i+1);
            }
        }

        Iterator<Integer> it = dq.descendingIterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()) {
            sb.append(it.next() + " ");
        }
        System.out.println(sb);
    }

}
