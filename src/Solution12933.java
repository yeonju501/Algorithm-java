import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution12933 {
    static ArrayList<Integer> duck = new ArrayList<>();
    static int cnt = -1;
    static HashMap<String, Integer> quack = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
//quqacukqauackck
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        quack.put("q", 1);
        quack.put("u", 2);
        quack.put("a", 3);
        quack.put("c", 4);
        quack.put("k", 5);

        String[] sound = br.readLine().split("");
        for(String s: sound) {
            int num = quack.get(s);
            boolean flag = false;

            if(num == 1) {
                duck.add(1);
            } else {
                for(int i = 0; i < duck.size(); i++) {
                    if(duck.get(i) == num-1){
                        duck.set(i, num);
                        if(num == 5) {
                            cnt = Math.max(cnt, duck.size());
                            duck.remove(i);
                        }
                        flag = true;
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
            System.out.println(cnt);
        }
    }

}
