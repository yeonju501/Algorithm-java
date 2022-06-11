import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution10828 {
    public static int size = 0;
    public static int[] stack;
    public static void main(String[] args) throws IOException {
//14
//push 1
//push 2
//top
//size
//empty
//pop
//pop
//pop
//size
//empty
//pop
//push 3
//empty
//top
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stack = new int[N];

        for(int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    System.out.println(pop());
                    break;

                case "size":
                    System.out.println(size());
                    break;

                case "empty":
                    System.out.println(empty());
                    break;

                case "top":
                    System.out.println(top());
                    break;

            }
        }
    }

    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if(size == 0) {
            return -1;
        } else{
            int res = stack[size-1];
            stack[size-1] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if(size == 0) {
            return -1;
        } else {
            return stack[size-1];
        }
    }
}
