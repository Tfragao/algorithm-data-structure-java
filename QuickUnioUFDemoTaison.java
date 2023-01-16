/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class QuickUnioUFDemoTaison {
    private int[] id;

    public QuickUnioUFDemoTaison(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int findDemo(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i; // returns the root
    }

    public boolean connectedDemo(int p, int q) {
        return findDemo(p) == findDemo(q);
    }

    public void unionDemo(int p, int q) {
        int pid = findDemo(p);
        int qid = findDemo(q);
        id[pid] = qid;

    }

    public static void main(String[] args) {
        QuickUnioUFDemoTaison quObj = new QuickUnioUFDemoTaison(10);
        System.out.println(quObj.connectedDemo(2, 7));
        quObj.unionDemo(2, 7);
        System.out.println(quObj.connectedDemo(2, 7));
    }
}
