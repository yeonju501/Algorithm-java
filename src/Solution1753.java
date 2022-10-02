import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1753 {

//5 6
//1
//5 1 1
//1 2 2
//1 3 3
//2 3 4
//2 4 5
//3 4 6
    static int v, e, start;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static class Node{
        int idx;
        int cost;
        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        dist = new int[v+1];

        for(int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        dist[start] = 0;
        q.offer(new Node(start, 0));

        while(!q.isEmpty()) {
            Node curNode = q.poll();
            if(dist[curNode.idx] < curNode.cost) continue;
            for(int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nNode = graph.get(curNode.idx).get(i);
                if(nNode.cost + curNode.cost < dist[nNode.idx]) {
                    dist[nNode.idx] = nNode.cost + curNode.cost;
                    q.offer(new Node(nNode.idx, dist[nNode.idx]));
                }
            }
        }

        for(int i = 1; i < v+1; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

}
