import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_terms {

    static String[] terms = {"A 6", "B 12", "C 3"};
    static String today = "2022.05.19";
    static String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            StringTokenizer st = new StringTokenizer(terms[i]);
            String t = st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            map.put(t, m);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(today, ".");
        int today_y = Integer.parseInt(st.nextToken());
        int today_m = Integer.parseInt(st.nextToken());
        int today_d = Integer.parseInt(st.nextToken());
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            StringTokenizer st2 = new StringTokenizer(privacy[0], ".");
            int year_p = Integer.parseInt(st2.nextToken());
            int month_p = Integer.parseInt(st2.nextToken());
            int day_p = Integer.parseInt(st2.nextToken());

            // 일 계산 부터
            if(day_p == 1) {
                if(month_p == 1) {
                    year_p--;
                    month_p = 12;
                } else {
                    month_p--;
                }
                day_p = 28;
            } else {
                day_p--;
            }
            // 월 계산 12보다 크면
            int add_month = map.get(privacy[1]);
            System.out.println(add_month);
            month_p += add_month % 12;
            if(month_p > 12) {
                year_p++;
                month_p = month_p % 12;
            }
            year_p += add_month / 12;

            if(year_p < today_y || (year_p == today_y && month_p < today_m) || (year_p == today_y && month_p == today_m && day_p < today_d)) {
                answer.add(i+1);
            }
        }

        int[] arr = new int[answer.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = answer.get(i);
        }
    }

}
