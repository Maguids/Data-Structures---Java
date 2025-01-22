// -----------------------------------------------------------
// Estruturas de Dados 2023/2024 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~miguel-areias/teaching/2324/ed/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);

      // Escrever resultado de chamada a alguns metodos
      System.out.println("numberNodes = " + t.numberNodes());
      System.out.println("depth = " + t.depth());
      System.out.println("contains(2) = " + t.contains(2));
      System.out.println("contains(3) = " + t.contains(3));
      //ED204
      System.out.println("numberLeafs = " + t.numberLeafs());
      //ED205
      System.out.println("strict() = " + t.strict());
      //ED206
      System.out.println("path() = " + t.path("DE"));
      //ED207
      System.out.println("nodesLevel() = " + t.nodesLevel(0));

      // Escrever nos da arvore seguindo varias ordens possiveis
      t.printPreOrder();      
      t.printInOrder();
      t.printPostOrder();
      t.printBFS();
      t.printDFS();
   }
}