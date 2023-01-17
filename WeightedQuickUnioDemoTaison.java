/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnioDemoTaison {
    private int[] parent; // parent[i] = parent of i
    private int[] size;  // size[i] = number of elements in subtree rooted at i
    private int count; // number of components


    public WeightedQuickUnioDemoTaison(int n) {
        int count = n;
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
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean connectedDemo(int p, int q) {
        return findDemo(p) == findDemo(q);
    }

    public void validateDemo(int p) {
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
        WeightedQuickUnioDemoTaison wqu = new WeightedQuickUnioDemoTaison(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (wqu.findDemo(p) == wqu.findDemo(q)) continue;
            wqu.unionDemo(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(wqu.countDemo() + " components");
    }
}
