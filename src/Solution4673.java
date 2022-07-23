public class Solution4673 {
    public static void main(String[] args){
        boolean[] selfNumber = new boolean[11000];
        for(int i = 1; i <= 10000; i++){
            int n = i;
            if(!selfNumber[i]) {
                while (n <= 10000) {
                    int value = 0;
                    value += n;
                    String s = String.valueOf(n);
                    for (int j = 0; j < s.length(); j++) {
                        value += s.charAt(j) - '0';
                    }
                    selfNumber[value] = true;
                    n = value;
                }
            }
        }
        for(int i = 1; i <= 10000; i++) {
            if (!selfNumber[i]) {
                System.out.println(i);
            }
        }
    }

}
