package topologicalsort;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        int nodes = 6;
        int[][] edges = {{2, 3}, {3, 1}, {4, 0}, {4, 1}, {5, 0}, {5, 2}};
        /*
         * Adjacency List
         * 2 -> 3
         * 3 -> 1
         * 4 -> 0, 1
         * 5 -> 0, 2
         * 
         * Answer : 5,4,2,3,1,0
         */
        topoSortDFS(nodes, edges);
    }

    private static void topoSortDFS(int nodes, int[][] edges) {
        boolean[] visited = new boolean[nodes];
        List<Integer>[] adjList = getAdjList(nodes, edges);
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<nodes; i++) {
            if (!visited[i]) {
                topoDFSUtil(i, adjList, visited, stack);
            }
        }
        System.out.println("Topological Sort with DFS is: ");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    private static void topoDFSUtil(int i, List<Integer>[] adjList, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;
        List<Integer> neighbors = adjList[i];
        for (int n : neighbors) {
            if (!visited[i]) {
                topoDFSUtil(n, adjList, visited, stack);
            }
        }
        
        stack.push(i);
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