import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
/*
sample input
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */

    static int v, e, start;
    static int[] dist;
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
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
        dist = new int[v + 1];
        graph = new ArrayList<>();
        for(int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        for(int i = 0; i < v+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();
            if(dist[curNode.idx] < curNode.cost) continue;

            for(int i = 0; i < graph.get(curNode.idx).size(); i++) {
                Node nNode = graph.get(curNode.idx).get(i);
                if(curNode.cost + nNode.cost < dist[nNode.idx]) {
                    dist[nNode.idx] = curNode.cost + nNode.cost;
                    q.offer(new Node(nNode.idx, dist[nNode.idx]));
                }
            }
        }

        System.out.println(Arrays.toString(dist));

    }

}
