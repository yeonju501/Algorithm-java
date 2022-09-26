public class Solution_emoticon {

    static int[][] users = {{40, 10000}, {25, 10000}};
    static int[] emoticons = {7000, 9000};

    static int[] rate = {10, 20, 30, 40};
    static boolean[][] visited;
    static int[] sequence;
    static int maxPlus, maxPay;
    public static void main(String[] args) {

        sequence = new int[emoticons.length];
        visited = new boolean[emoticons.length][rate.length];

        dfs(0, 0);
        int[] answer = new int[]{maxPlus, maxPay};

    }

    static void dfs(int idx, int depth) {
        if(depth == emoticons.length) {
            cal();
            return;
        }

        for(int i = 0; i < rate.length; i++) {
            if(!visited[depth][i]) {
                visited[depth][i] = true;
                sequence[depth] = rate[i];
                dfs(i+1, depth+1);
                visited[depth][i] = false;
            }

        }
    }

    static void cal() {
        int plus = 0;
        int total_pay = 0;
        for(int i = 0; i < users.length; i++) {
            int pay = 0;
            for(int j = 0; j < emoticons.length; j++) {
                if(sequence[j] >= users[i][0]) {
                    int price = emoticons[j] / 100;
                    price *= 100 - sequence[j];
                    pay += price;
                }
            }
            if(pay >= users[i][1]) {
                plus++;
                continue;
            }
            total_pay += pay;
        }

        if(maxPlus < plus) {
            maxPlus = plus;
            maxPay = total_pay;
        } else if (maxPlus == plus) {
            maxPay = Math.max(maxPay, total_pay);
        }
    }
}
