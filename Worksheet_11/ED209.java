// Colocar o seguinte código dentro de BSTree

   // ED209 - intervalo de valores
   public int countBetween(T a, T b) {
      return countBetween(root, a, b);
   }

   private int countBetween(BSTNode<T> n, T a, T b) {
      if (n == null) {return 0;}
      if (a.compareTo(n.getValue()) > 0 || b.compareTo(n.getValue()) < 0) {return countBetween(n.getLeft(), a, b) + countBetween(n.getRight(), a, b);}
      return 1 + countBetween(n.getLeft(), a, b) + countBetween(n.getRight(), a, b);
   }