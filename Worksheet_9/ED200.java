import java.util.Scanner;

class ED200 {
   static int rows;            // Numero de linhas
   static int cols;            // Numero de colunas   
   static char m[][];          // Matriz de celulas
   static boolean visited[][]; // Saber se uma dada posicao ja foi visitada

   // Tamanho da mancha que inclui posicao (y,x)
    static int t(int y, int x) {
        if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
        if (visited[y][x]) return 0;  // Caso base: celula ja visitada
        if (m[y][x] == '.') return 0; // Caso base: celula vazia
        int count = 1;        // celula nao vazia
        visited[y][x] = true; // marcar como visitada
        count += t(y-1, x);   // Adicionando celulas nao vizinhas
        count += t(y+1, x);
        count += t(y, x+1);
        count += t(y, x-1);
        count += t(y-1, x-1);
        count += t(y-1, x+1);
        count += t(y+1, x-1);
        count += t(y+1, x+1);
        return count;
   }
   
   // -----------------------------------------------------------
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Leitura do numero n de inputs
        int n = in.nextInt();
        int[] keeper = new int[n];

        for(int i = 0; i < n; i++) {
            // Leitura de uma matriz de caracteres
            rows = in.nextInt();
            cols = in.nextInt();
            m = new char[rows][cols];
            visited = new boolean[rows][cols];
            for (int j=0; j<rows; j++){
                m[j] = in.next().toCharArray();
            }

            //contar as figuras
            int k = 0;
            for (int a = 0; a < rows; a++) {
                for (int b = 0; b < cols; b++) {
                    int p = t(a,b);
                    if (p > k) {k = p;}
                }
            }
            keeper[i] = k;
        }
      
        // Imprimir resultado
        for (int l = 0; l < keeper.length; l++) {
            System.out.printf(keeper[l]+"\n");  
        }
   }
}