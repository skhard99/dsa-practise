package unionfind;

public class UnionFindTester {
    public static void main(String[] args) {
        // Let there be 5 persons with ids as
        // 0, 1, 2, 3 and 4
        int n = 5;
        UnionFind uf = 
                new UnionFind(n);

        // 0 is a friend of 2
        uf.union(0, 2);

        // 4 is a friend of 2
        uf.union(4, 2);

        // 3 is a friend of 1
        uf.union(3, 1);

        // Check if 4 is a friend of 0
        if (uf.find(4) == uf.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (uf.find(1) == uf.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
