
public class ED194 {
    
    public static void reverse(MyStack<Integer> s, int n) {
        int[] keeper = new int[n];

        //guardar os valores na lista (e retirar da pilha)
        for (int i = 0; i < n; i++) {
            keeper[i] = s.pop();
        }

        //colocar os valores de volta
        for (int j = 0; j < n; j++) {
            s.push(keeper[j]);
        }
    }

   // Main apenas para testar no seu computador
   public static void main(String[] args) {
      MyStack<Integer> s = new LinkedListStack<Integer>();

      for (int i=5; i>0; i--)
         s.push(i);
      System.out.println(s); // Antes da chamada a reverse
      reverse(s, 3);
      System.out.println(s); // Depois da chamada a reverse
   }
}