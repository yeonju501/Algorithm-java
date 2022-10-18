package programmers;
import java.util.*;
class SolutionMinMax {
    public String solution(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] sArr = s.split(" ");
        for(int i = 0; i < sArr.length; i++) {
            list.add(Integer.parseInt(sArr[i]));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        sb.append(" ");
        sb.append(list.get(list.size()-1));
        return sb.toString();
    }
}