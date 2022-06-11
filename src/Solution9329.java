import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9329 {

    public static void main(String[] args) throws IOException {
//3
//2 10
//3 1 2 3 100
//4 4 5 6 7 200
//2 3 1 4 5 2 2 1 3 4
//3 6
//2 1 2 100
//3 3 4 5 200
//1 6 300
//1 2 3 4 5 6
//3 6
//2 1 2 100
//3 3 4 5 200
//1 6 300
//1 2 0 4 5 6

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
         String[] temp = br.readLine().split(" ");
         int numPrize = Integer.parseInt(temp[0]);
         int numSticker = Integer.parseInt(temp[1]);
         int [][] prizes = new int[numPrize][100];
         int [] stickers = new int [numSticker+1];
         for (int j = 0; j < numPrize; j++) {
             String[] temp2 = br.readLine().split(" ");
             prizes[j][0] = Integer.parseInt(temp2[0]);
             for (int z = 1; z <= prizes[j][0] + 1; z++) {
                 prizes[j][z] = Integer.parseInt(temp2[z]);
             }
         }
         String[] temp3 = br.readLine().split(" ");
         for (int j = 0; j < numSticker; j++) {
             stickers[j] = Integer.parseInt(temp3[j]);
         }

         int result = 0;
         for (int j = 0; j < numPrize; j++) {
             int min = 987654321;
             for (int z = 1; z <= prizes[j][0]; z++) {
                 if (stickers[prizes[j][z] - 1] < min){
                     min = stickers[prizes[j][z] - 1];
                 }
             }
             result += prizes[j][prizes[j][0] + 1] * min;

         }
         System.out.println(result);
        }
    }
}
