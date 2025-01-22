//deu runtime error no mooshak mas está correto

import java.util.Scanner;
import java.util.Stack;

class ED201 {
   // Escrever todos os subconjuntos do array v[]
   static Stack<Integer> sets (int v[], int d) {
      Stack<Integer> result = new Stack<Integer>();
      boolean used[] = new boolean[v.length];
      goSets(0, v, used, result, d); // chamar funcao recursiva
      return result;
   }

   // Gera todos os subconjuntos a partir da posicao 'cur'
   static void goSets(int cur, int v[], boolean used[], Stack<Integer> result, int d) {
      if (cur == v.length) {  // Caso base: terminamos o conjunto
         // Escrever conjunto
         Integer counter = 0;
         for (int i=0; i<v.length; i++) 
            if (used[i]) {counter += v[i];}
         if (counter <= d) {result.push(counter);}
      } else {                  // Se nao terminamos, continuar a gerar
         used[cur] = true;      // Subconjuntos que incluem o elemento actual
         goSets(cur+1, v, used, result, d);// Chamada recursiva
         used[cur] = false;     // Subconjuntos que nao incluem o el. actual
         goSets(cur+1, v, used, result, d);// Chamada recursiva
      }
   }

   // -----------------------------------------------------------
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int d = in.nextInt();
      int n = in.nextInt();

      int[] v = new int[n];
      for(int i = 0; i < n; i++) {
            v[i] = in.nextInt();
      }
      Stack<Integer> ans = sets(v, d);

      //procurar o valor correto
      int keeper = 0;
      while (ans.empty() == false) {
         int atual = ans.pop();
         if (atual <= d && atual > keeper) {keeper = atual;}
      }
      System.out.println(keeper);
   }
}