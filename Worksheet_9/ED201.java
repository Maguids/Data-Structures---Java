import java.util.Scanner;

class ED201 {
   // Escrever todos os subconjuntos do array v[]
   static void sets (int v[], int d) {
      boolean used[] = new boolean[v.length];
      int resp = goSets(0, v, used, d); // chamar funcao recursiva
      System.out.println(resp);
   }

   // Gera todos os subconjuntos a partir da posicao 'cur'
   static int goSets(int cur, int v[], boolean used[], int d) {
        if (cur == v.length) {  // Caso base: terminamos o conjunto
            int counter = 0;
            for (int i=0; i<v.length; i++) 
                if (used[i]) {counter += v[i];}
            if (counter <= d) {
                return counter;
            } else {return 0;}
        } else {                  // Se nao terminamos, continuar a gerar
            used[cur] = true;      // Subconjuntos que incluem o elemento actual
            int c1 = goSets(cur+1, v, used, d);// Chamada recursiva
            used[cur] = false;     // Subconjuntos que nao incluem o el. actual
            int c2 = goSets(cur+1, v, used, d);// Chamada recursiva
            return Math.max(c1,c2);
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
      sets(v,d);
   }
}