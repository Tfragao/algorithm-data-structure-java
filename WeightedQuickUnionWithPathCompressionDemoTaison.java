/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionWithPathCompressionDemoTaison {
    private int[] parent;
    private int[] size;
    private int count;

    public WeightedQuickUnionWithPathCompressionDemoTaison(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = i;
        }
    }

    public int countDemo() {
        return count;
    }

    public int findDemo(int p) {
        validateDemo(p);
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        while (p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }

    public boolean connectedDemo(int p, int q) {
        return findDemo(p) == findDemo(q);
    }

    private void validateDemo(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public void unionDemo(int p, int q) {
        int rootP = findDemo(p);
        int rootQ = findDemo(q);
        if (rootP == rootQ) return;

        //make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        WeightedQuickUnionWithPathCompressionDemoTaison wquwpc
                = new WeightedQuickUnionWithPathCompressionDemoTaison(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (wquwpc.findDemo(p) == wquwpc.findDemo(q)) continue;
            wquwpc.unionDemo(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(wquwpc.countDemo() + " components");
    }
}
