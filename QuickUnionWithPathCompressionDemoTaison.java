/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionWithPathCompressionDemoTaison {
    private int[] id;
    private int count;

    public QuickUnionWithPathCompressionDemoTaison(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int countDemo() {
        return count;
    }

    public int findDemo(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p != root) {
            int newp = id[p];
            id[p] = root;
            p = newp;
        }

        return root;
    }

    public boolean connectedDemo(int p, int q) {
        return findDemo(p) == findDemo(q);
    }

    public void unionDemo(int p, int q) {
        int rootP = findDemo(p);
        int rootQ = findDemo(q);
        if (rootP == rootQ) return;
        id[rootP] = rootQ;
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnionWithPathCompressionDemoTaison quwpc = new QuickUnionWithPathCompressionDemoTaison(
                n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (quwpc.findDemo(p) == quwpc.findDemo(q)) continue;
            quwpc.unionDemo(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(quwpc.countDemo() + " components");
    }
}
