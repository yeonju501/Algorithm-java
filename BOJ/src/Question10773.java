import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] nums = br.readLine().split(" ");
        int hour = Integer.parseInt(nums[0]);
        int minute = Integer.parseInt(nums[1]);
        if (minute < 45) {
            if (hour == 0){
                hour = 23;
            } else {
                hour--;
            }
            minute = 15 + minute;
        } else {
            minute = minute - 45;
        }
        System.out.println(hour + " " + minute);
    }
}
