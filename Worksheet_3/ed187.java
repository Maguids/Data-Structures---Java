import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matriz
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }   

   public Matrix transpose() {
      Matrix resposta = new Matrix(cols, rows);
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            resposta.data[j][i] = data[i][j];
         }
      }
      return resposta;
   }

   public static Matrix identity(int n) {
      Matrix resposta = new Matrix(n,n);
      for (int i = 0; i < n; i++){
         for (int j = 0; j < n; j++){
            if (i == j) {
               resposta.data[i][j] = 1;
            } else {
               resposta.data[i][j] = 0;
            }
         }
      }
      return resposta;
   }

   public Matrix sum(Matrix m) {
      Matrix resposta = new Matrix(rows, cols);

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            resposta.data[i][j] = m.data[i][j] + data[i][j];
         }
      }
      return resposta;
   }

   public Matrix multiply(Matrix m) {
      Matrix resposta = new Matrix(rows, m.cols);
      
      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < m.cols; j++) {
               int soma = 0;
               for (int k = 0; k < cols; k++) {
                  soma += data[i][k] * m.data[k][j];
               }
               resposta.data[i][j] = soma;
         }
      }
      return resposta;
   }

}

class ed187 {
   public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);

      Matrix m1 = Matrix.identity(5);
      System.out.println("m1");
      System.out.println(m1);
      
      Matrix m2 = new Matrix(stdin.nextInt(), stdin.nextInt());
      m2.read(stdin);
      System.out.println("m2");
      System.out.println(m2);
      Matrix m3 = new Matrix(stdin.nextInt(), stdin.nextInt());
      m3.read(stdin);
      System.out.println("m3");
      System.out.println(m3);
      Matrix m4 = new Matrix(stdin.nextInt(), stdin.nextInt());
      m4.read(stdin);
      System.out.println("m4");
      System.out.println(m4);

      Matrix m5 = m1.transpose();
      System.out.println("m5");
      System.out.println(m5);
      Matrix m6 = m2.transpose();
      System.out.println("m6");
      System.out.println(m6);

      Matrix m7 = m2.sum(m3);
      System.out.println("m7");
      System.out.println(m7);
      Matrix m8 = m2.multiply(m4);
      System.out.println("m8");
      System.out.println(m8);
   }
}