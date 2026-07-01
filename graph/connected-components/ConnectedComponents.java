import java.util.*;

public class ConnectedComponents {

    /*
     * Problem:
     *
     * Given an undirected graph with n vertices labeled from 0 to n - 1,
     * and an array of edges where edges[i] = {u, v} represents an
     * undirected edge between u and v, return the number of connected
     * components in the graph.
     *
     * Constraints:
     * 1 <= n <= 10^5
     * 0 <= edges.length <= 2 * 10^5
     * No self-loops.
     * No duplicate edges.
     */
    private static void dfs (int node, boolean[] visited, ArrayList<Integer>[] adjList) {
        if (visited[node]) return;

        visited[node] = true;
        List<Integer> neighbors = adjList[node];
        for (int n: neighbors) {
            dfs(n, visited, adjList);
        }
    }

    public static int countConnectedComponents(int n, int[][] edges) {

        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(i, visited, adjList);
                ans++;
            }
        }


        return ans;
    }

    


    public static void main(String[] args) {

        runTest(
                1,
                7,
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {3, 4},
                        {5, 6}
                },
                3
        );

        runTest(
                2,
                5,
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {2, 3},
                        {3, 4}
                },
                1
        );

        runTest(
                3,
                5,
                new int[][]{},
                5
        );

        runTest(
                4,
                1,
                new int[][]{},
                1
        );

        runTest(
                5,
                8,
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {2, 0},      // cycle
                        {3, 4},
                        {4, 5},
                        {5, 3},      // cycle
                        {6, 7}
                },
                3
        );

        runTest(
                6,
                10,
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {2, 3},
                        {4, 5},
                        {5, 6},
                        {7, 8}
                        // node 9 is isolated
                },
                4
        );

        runTest(
                7,
                9,
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {2, 3},
                        {3, 4},
                        {4, 0},      // large cycle

                        {5, 6},
                        {6, 7},
                        {7, 5}       // another cycle
                        // node 8 isolated
                },
                3
        );

        runTest(
                8,
                12,
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {2, 3},
                        {3, 0},

                        {4, 5},

                        {6, 7},
                        {7, 8},
                        {8, 9},
                        {9, 6},

                        {10, 11}
                },
                4
        );
    }

    private static void runTest(int testNo, int n, int[][] edges, int expected) {

        int actual = countConnectedComponents(n, edges);

        System.out.println("Test Case " + testNo);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);

        if (actual == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        System.out.println("-----------------------------------");
    }
}