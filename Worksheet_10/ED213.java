//retirar comentLine para testar
import java.util.Scanner;

public class ED213 {
    // ED213 - Caminho de maior soma
    //função que devolve uma string contendo apenas caracteres 'E' e 'D' indicando o caminho de maior soma

    public static String maxSum(BTree<Integer> t) {
        int profundidade = t.depth();
        if (profundidade == -1) {return "";}
        if (profundidade == 0) {return "R";}
        String s = "";
        return "piu";
    }

    private int numberLeafs(BTNode<T> n) {
        int counter = 0;
        if (n == null) {return 0;}
        if (n.getLeft() == null && n.getRight() == null) {counter += 1;}
        return counter + numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
    }

    private static String[] Caminhos(String[] keeper, String s, int sInKeeper, BTNode<Integer> n) {
        
    }

    //retirar comentLine para testar
    public static void main(String[] args) {
        // Ler arvore de inteiros em preorder
        Scanner in = new Scanner(System.in);
        BTree<Integer> tree = LibBTree.readIntTree(in);

        String p = "";
        System.out.print(p);
        
    } 
}