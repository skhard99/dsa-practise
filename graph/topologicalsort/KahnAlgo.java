package topologicalsort;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnAlgo {
    public static void main(String[] args) {
        int nodes = 6;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};
        /*
         * Adjacency List
         * 0 -> 1
         * 1 -> 2
         * 2 -> 3
         * 4 -> 5
         * 5 -> 1, 2
         * 
         * Answer : 0,4,5,1,2,3
         */
        kahnBFS(nodes, edges);
    }

    private static void kahnBFS(int nodes, int[][] edges) {
        List<Integer>[] adjList = getAdjList(nodes, edges);
        int[] indegree = new int[nodes];
        for (int[] edge : edges) {
            indegree[edge[1]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i=0; i<nodes;i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        int[] result = new int[nodes];
        int index = 0;
        while (!que.isEmpty()) {
            int curr = que.poll();
            result[index++] = curr;
            List<Integer> neighbors = adjList[curr];
            for (int n: neighbors) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    que.add(n);
                }
            } 
        }
        System.out.println("Topological Sort with BFS is: ");
        for(int i=0; i< nodes; i++) {
            System.out.println(result[i]);
        }
    }

    private static List<Integer>[] getAdjList(int nodes, int[][] edges) {
        List<Integer>[] adj = new ArrayList[nodes];
        for (int i=0; i< nodes; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }

}
