public class SolutionBinary {

    static int[] A = {13, 7, 2, 8, 3};

    public static void main(String[] args) {
        int[] cnt = new int[Integer.toBinaryString(1000000000).length()];
        for(int i = 0; i < A.length; i++) {
            String bin = Integer.toBinaryString(A[i]);
            for(int j = 0; j < bin.length()-1; j++) {
                if(bin.charAt(j) == '1') {
                    cnt[bin.length() - j - 1]++;
                }
            }
        }

        int max = 0;
        for(int i : cnt) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }

}
