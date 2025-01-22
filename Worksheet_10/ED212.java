//retirar comentLine para testar
// import java.util.Scanner;

public class ED212 {
    // ED212 - Soma de todos os níveis
    //função que devolve um array contendo a soma de nós de cada nível

    public static int[] sumLevels(BTree<Integer> t) {
        int profundidade = t.depth();
        int[] keeper = new int[profundidade+1];
        return sumLevels(keeper, 0, t.getRoot());
    }

    private static int[] sumLevels(int[] k, int cur, BTNode<Integer> n) {
        if (n != null) {
            k[cur] += n.getValue();
            sumLevels(k, cur+1, n.getLeft());
            sumLevels(k, cur+1, n.getRight());
        }
        return k;
    }

    //retirar comentLine para testar
    // public static void main(String[] args) {
    //     // Ler arvore de inteiros em preorder
    //     Scanner in = new Scanner(System.in);
    //     BTree<Integer> tree = LibBTree.readIntTree(in);

    //     int[] resp = sumLevels(tree);
    //     System.out.print("[");
    //     for (int i = 0; i <= tree.depth(); i++) {
    //         if(i != tree.depth()) {System.out.print(resp[i] + ", ");}
    //         else {System.out.print(resp[i]);}
    //     }
    //     System.out.println("]");
    // } 
}