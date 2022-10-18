import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution14891 {

    static ArrayList<List<String>> wheels = new ArrayList<>();
    static int k;
    public static void main(String[] args) throws IOException {
        // 1. 처음에 돌린다.
        // 2. 시계방향은 뒤에서 빼서 앞으로 반시계방향은 앞에서 빼서 뒤로
        // 3. 극이 다르면 반대방향으로 회전 같으면 가만히
        // 4. 2번과 6번을 체크
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 4; i++) {
            wheels.add(Arrays.stream(br.readLine().split("")).collect(Collectors.toList()));
        }

        k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            turn(idx, dir);
        }

        int ans = 0;
        for(int i = 0; i < 4; i++) {
            if(wheels.get(i).get(0).equals("1")){
                ans += Math.pow(2, i);
            }
        }
        System.out.println(ans);
    }

    static void turn(int idx, int dir) {
        leftSide(idx-1, -dir);
        rightSide(idx+1, -dir);
        rotation(idx, dir);
    }

    static void leftSide(int idx, int dir) {
        if(idx < 0) return;
        if(wheels.get(idx).get(2).equals(wheels.get(idx+1).get(6))) return;
        leftSide(idx-1, -dir);
        rotation(idx, dir);
    }

    static void rightSide(int idx, int dir) {
        if(idx > 3) return;
        if (wheels.get(idx).get(6).equals(wheels.get(idx-1).get(2))) return;
        rightSide(idx+1, -dir);
        rotation(idx, dir);
    }

    static void rotation(int idx, int dir) {
        if(dir == 1) {
            String end = wheels.get(idx).remove(7);
            wheels.get(idx).add(0, end);
        } else {
            String start = wheels.get(idx).remove(0);
            wheels.get(idx).add(start);
        }
    }

}
