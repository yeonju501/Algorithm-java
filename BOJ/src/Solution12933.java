import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution12933 {
    static HashMap<String, Integer> quack = new HashMap<String, Integer>() {{
        put("q", 1);
        put("u", 2);
        put("a", 3);
        put("c", 4);
        put("k", 5);
    }};
    static ArrayList<Integer> duck = new ArrayList<>();


    public static void main(String[] args) throws IOException {
//quqacukqauackck
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sound = br.readLine().split("");

        int ans = 0;
        for(String s: sound) {
            int num = quack.get(s);
            if(s.equals("q")) {
                duck.add(1);
            } else {
                boolean flag = false;
                for(int i = 0; i < duck.size(); i++) {
                    if(duck.get(i) == num-1) {
                        duck.set(i, num);
                        flag = true;
                        if(num == 5) {
                            ans = Math.max(ans, duck.size());
                            duck.remove(i);
                        }
                        break;
                    }
                }
                if(!flag) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        if(duck.size() != 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

}
