import java.util.Scanner;

public class ed120 {

   static int find_midd (int n){
        int midd;
        midd = (n + 1)/2;
        return midd;
   }

   static int count_espacos (int midd){
    int espacos = midd*2 - 1;
    return espacos/2;
   }
    
    static void line (int x, int espacos){
        //primeira parte dos espaços
        for (int i = 1; i <= espacos; i++){
            System.out.print(".");
        }
        //numero de #
        for (int i = 1; i <= x; i++){
            System.out.print("#");
        }
        //resto dos espaçoc
        for (int i = 1; i <= espacos; i++){
            System.out.print(".");
        }
        System.out.println();
   }

   static int draw_1 (int y, int espacos){
        //y = numero de linhas a desenhar
        int x = 1;
        for (int i = 1; i <= y; i++){
            line(x, espacos);
            espacos -= 1;
            x += 2;
        }
        return (x-4);
   }

   static void draw_2 (int x, int n, int midd, int espacos){
        for (int j = 1; j <= espacos; j++){
            line(x, j);
            x -= 2;
        }
   }

   public static void main (String[] args){

        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int midd = find_midd(n);
        int espacos = count_espacos(midd);

        int x = draw_1(midd, espacos);
        draw_2(x, n, midd, espacos);

   }
}