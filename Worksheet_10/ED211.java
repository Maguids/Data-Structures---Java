//retirar comentLine para testar
//import java.util.Scanner;

public class ED211 {
    // ED211 - Contando os números pares
    //função que devolve a quantidade de números pares que são elementos da árvore

    public static int countEven(BTree<Integer> t) {
        return countEven(t.getRoot());
    }
    public static int countEven(BTNode<Integer> n) {
        int counter = 0;
        if (n != null) {
            if (n.getValue() % 2 == 0) {counter = 1;}
            return counter + countEven(n.getLeft()) + countEven(n.getRight());
        }
        return counter;
    }

    //retirar comentLine para testar
    // public static void main(String[] args) {
    // // Ler arvore de inteiros em preorder
    // Scanner in = new Scanner(System.in);
    // BTree<Integer> tree = LibBTree.readIntTree(in);

    // System.out.println("countEvent(t) = " + countEven(tree));
    // } 
}