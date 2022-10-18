import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution10866 {

    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
//15
//push_back 1
//push_front 2
//front
//back
//size
//empty
//pop_front
//pop_back
//pop_front
//size
//empty
//pop_back
//push_front 3
//empty
//front
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                if (s.equals("push_back")) {
                    list.add(Integer.parseInt(st.nextToken()));
                } else if(s.equals("push_front")) {
                    list.add(0, Integer.parseInt(st.nextToken()));
                } else if (s.equals("front")) {
                    if(!list.isEmpty()) {
                        System.out.println(list.get(0));
                    } else {
                        System.out.println(-1);
                    }
                } else if(s.equals("back")) {
                    if(!list.isEmpty()){
                        System.out.println(list.get(list.size()-1));
                    } else {
                        System.out.println(-1);
                    }
                } else if(s.equals("size")) {
                    System.out.println(list.size());
                } else if(s.equals("empty")) {
                    if(!list.isEmpty()) {
                        System.out.println("0");
                    } else{
                        System.out.println("1");
                    }
                } else if (s.equals("pop_front")) {
                    if(!list.isEmpty()) {
                        System.out.println(list.get(0));
                        list.remove(0);
                    } else {
                        System.out.println("-1");
                    }
                } else if(s.equals("pop_back")) {
                    if(!list.isEmpty()) {
                        System.out.println(list.get(list.size()-1));
                        list.remove(list.size()-1);
                    } else {
                        System.out.println(-1);
                    }
                }
            }
        }

    }

}
