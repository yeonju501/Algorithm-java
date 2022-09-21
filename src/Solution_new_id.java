import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_new_id {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String new_id = br.readLine();

        String answer = "";
        // level 1
        String level1 = new_id.toLowerCase();

        // level 2
        char[] level1_arr = level1.toCharArray();
        StringBuilder level2 = new StringBuilder();
        for(char c: level1_arr) {
            if((c >= '0' && c <= '9') || c == '-' || c == '.' || c == '_' || (c >= 'a' && c <= 'z')) {
                level2.append(c);
            }
        }

        // level 3
        String level3 = level2.toString().replace("..", ".");
        while(level3.contains("..")) {
            level3 = level3.replace("..", ".");
        }

        // level 4
        String level4 = level3;
        if(level4.length() > 0) {
            if(level4.charAt(0) == '.') {
                level4 = level4.substring(1, level4.length()-1);
            }
        }

        if(level4.length() > 0) {
            if(level4.charAt(level4.length()-1) == '.') {
                level4 = level4.substring(0, level4.length()-1);
            }
        }

        // level 5
        String level5 = level4;
        if(level5.equals("")){
            level5 = "a";
        }

        // level 6
        String level6 = level5;
        if(level6.length() >= 16) {
            level6 = level6.substring(0, 15);
            if(level6.charAt(level6.length()-1) == '.') {
                level6 = level6.substring(0, level6.length()-1);
            }
        }

        // level 7
        StringBuilder level7 = new StringBuilder(level6);
        if(level7.length() <= 2){
            char last = level7.charAt(level7.length()-1);
            while(level7.length() < 3) {
                level7.append(last);
            }
        }

        answer = level7.toString();
        System.out.println(answer);

    }

}
