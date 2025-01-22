import java.util.Scanner;

class Tabuleiro {
    private int n;
    private char data[][];

    //Construtor que recebe como argumentoo tamanho n
    Tabuleiro(int size) {
        n = size;
        data = new char[n][n];
    }

    void read(Scanner in) {
        for (int i = 0; i < n; i++){
            String buf = in.next();
            for (int j = 0; j < n; j++){
                data[i][j] = buf.charAt(j);
            }
        }
    }

    public String toString() {
        String ans = "";
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                ans += data[i][j] + " ";
            }
            ans += "\n";
        }
        return ans;
    }

    void verify (int y, int x, int incy, int incx) {
        if (data[y][x] == '.') {
            return;         //Posição por preencher
        }
        for (int i = 0, yy = y, xx = x; i < n; i++, yy += incy, xx += incx) {
            if (data[y][x] != data[yy][xx]) {
                return;
            }
        }
        win(data[y][x]);
    }

    void win(char player) {
        System.out.println("Ganhou o " + player);
        System.exit(0);     //Sai do programa
    }

    void check() {
        for (int i = 0; i < n; i++)  {
            verify(i, 0, 0, 1);             //linha
        } 
            
        for (int j = 0; j < n; j++) {
            verify(0, j, 1, 0);             //coluna
        }
        
        verify(0, 0, 1, 1);                 //diagonal
        verify(0, n-1, 1, -1);              //outra diagonal

        if (!finished()) {
            System.out.println("Jogo incompleto");
        } else {
            System.out.println("Empate");
        }             
    }

    boolean finished() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}

public class ed004 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        Tabuleiro t = new Tabuleiro(n);
        t.read(in);
        t.check();
    }
}