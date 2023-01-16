/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class QuickFindUFDemoTaison {
    private int[] id;

    public QuickFindUFDemoTaison(int N) {
        id = new int[N];
        /*
         * Each element is an id that is the same as the element position starting from 0
         * Such as id of position 1 is 1, id of position 0 is 0, id of position 7 is 7
         */
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connectedDemo(int p, int q) {
        return id[p] == id[q];
    }

    public void unionDemo(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            // where you find the id of p, change it to id of q
            if (id[i] == pid) id[i] = qid;
        }
    }

    public static void main(String[] args) {
        QuickFindUFDemoTaison quickObj = new QuickFindUFDemoTaison(9);
        System.out.println(quickObj.connectedDemo(3, 4));
        quickObj.unionDemo(3, 4);
        System.out.println(quickObj.connectedDemo(3, 4));
    }
}
