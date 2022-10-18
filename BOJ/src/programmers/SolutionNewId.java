import java.util.Arrays;
import java.util.List;

public class SolutionNewId {

    static String[] registered_list = {"cow", "cow1", "cow2", "cow3"};
    static String new_id = "cow1";

    public static void main(String[] args) {

        String ans = "";
        List<String> list = Arrays.asList(registered_list);
        if (list.contains(new_id)) {
            int num = 1;
            String s = new_id;
            for (int i = 0; i < new_id.length(); i++) {
                if (Character.isDigit(new_id.charAt(i))) {
                    // 숫자면
                    num = Integer.parseInt(new_id.substring(i));
                    s = new_id.substring(0, i);
                    break;
                }
            }
            StringBuilder sb = new StringBuilder(s);
            sb.append(num);
            while (list.contains(sb.toString())) {
                int l = String.valueOf(num).length();
                sb.delete(sb.length() - l, sb.length());
                num++;
                sb.append(num);
            }
            new_id = s + num;
        }
        ans = new_id;
        System.out.println(ans);
    }

}
