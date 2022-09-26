public class Solution_element {

    static int[][] queries = {{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}};

    public static void main(String[] args) {
        int answer = 0;

        // 현재 개수, 크기
        int[][] elements = new int[1001][2];

        // 0이면 2의 거듭제곱만큼
        for(int[] query: queries) {
            int q_idx = query[0];
            int q_add = query[1];
            // 현재 개수 + 더할 개수가 크기보다 크면
            if(elements[q_idx][0] + q_add > elements[q_idx][1]) {
                int size = 0;
                int n = 0;
                //
                while(elements[q_idx][0] + q_add > size) {
                    Double temp = Math.pow(2, n);
                    size = temp.intValue();
                    n++;
                }
                elements[q_idx][1] = size;
                answer += elements[q_idx][0];
                elements[q_idx][0] += q_add;
            } else{
                elements[q_idx][0] += q_add;
            }
        }

        System.out.println(answer);

    }

}
