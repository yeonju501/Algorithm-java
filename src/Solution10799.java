import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10799 {
    public static void main(String[] args) throws IOException {
//()(((()())(())()))(())
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] stack = new int[100000];
        int[] laser = new int[100000];
        int size = 0;
        int laserSize = 0;
        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack[size] = i;
                size++;
            } else if(c == ')') {
                if(stack[size-1] == i-1){
                    laser[laserSize] = i-1;
                    laserSize++;
                } else {
                    for(int j = 0; j < laserSize; j++) {
                        if(laser[j] > stack[size-1] && laser[j] < i){
                            cnt++;
                        }
                    }
                    cnt++;
                }
                stack[size-1] = 0;
                size--;
            }
        }
        System.out.println(cnt);
    }
}
