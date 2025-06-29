package unionfind;

public class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        this.size = new int[n];
        for (int i=0; i<n; i++) {
            size[i] = 1;
        }
        this.parent = new int[n];
        // Make everyone their own representative
        for (int i=0; i<n;i++) {
            parent[i] = i;
        }
    }

    // Find Representative along with path compression
    public int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        // Find representatives of both
        a = find(a);
        b = find(b);
        // If both have same top parent, nothing to do
        if (a == b) return;
        // Make small one child of bigger one
        if (size[a] > size [b]) {
            parent[b] = a;
            size[a] += size[b];
        } else {
            parent[a] = b;
            size[b] += size[a];
        }

    }
}