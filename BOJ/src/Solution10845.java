import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution10845 {
    public static void main(String[] args) throws IOException {
//15
//push 1
//push 2
//front
//back
//size
//empty
//pop
//pop
//pop
//size
//empty
//pop
//push 3
//empty
//front
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                if(s.equals("push")) {
                    list.add(Integer.parseInt(st.nextToken()));
                } else if(s.equals("front")) {
                    if(!list.isEmpty()) {
                        System.out.println(list.get(0));
                    } else {
                        System.out.println(-1);
                    }
                } else if(s.equals("back")) {
                    if(!list.isEmpty()) {
                        System.out.println(list.get(list.size()-1));
                    } else {
                        System.out.println(-1);
                    }
                } else if(s.equals("size")) {
                    System.out.println(list.size());
                } else if(s.equals("empty")){
                    if(list.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                } else if(s.equals("pop")) {
                    if(!list.isEmpty()){
                        int item = list.get(0);
                        list.remove(0);
                        System.out.println(item);
                    } else {
                        System.out.println(-1);
                    }
                }
            }
        }
    }

}
