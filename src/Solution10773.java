import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution10773 {
    public static void main(String[] args) throws IOException {
//4
//3
//0
//4
//0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                arr.add(num);
            } else {
                arr.remove(arr.size()-1);
            }
        }
        int sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        System.out.println(sum);
    }

}
