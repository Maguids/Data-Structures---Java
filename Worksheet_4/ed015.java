import java.util.Scanner;

class SopaLetras {
    final char EMPTY = '.';
    final int KEEP = 1;
    final int CLEAR = 0;
    private int lins;
    private int cols;
    private int result[][];
    private char data[][];
    private int n_palavras;
    private String palavras[];

    //Construtor do tabuleiro
    SopaLetras(int y, int x, int n) {
        lins = y;
        cols = x;
        data = new char[lins][cols];
        result = new int[lins][cols];
        n_palavras = n;
        palavras = new String[n];
    }

    //Método para ler o estado inicial da matriz m[][]
    public void read(char[][] d) {
        data = d;
    }

    //Método para imprimir o estado do tabuleiro
    public void write() {
        String ans = "";
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {ans += data[i][j];}
            if (i < lins-1) {ans += "\n";}
        }
        System.out.println(ans);
    }

    //Método para inverter as palavras
    private String inverse_substring(String s, int t) {
        String s_inverse = "";
        for (int i = t-1; i >= 0; i--) {
            s_inverse += s.charAt(i);
        }
        return s_inverse;
    }

    //Método para ler as palavras a procurar e invertê-las
    public void read_p(Scanner stdin) {
        int n = n_palavras/2;
        for (int i = 0; i < n; i++) {
            palavras[i] = stdin.next();
            String p_inverso = inverse_substring(palavras[i],  palavras[i].length());
            palavras[i+n] = p_inverso;
        }
    }

    //Método para imprimir as palavras a procurar
    //apenas para testes
    public void write_p() {
        String ans = "";
        for (int i = 0; i < n_palavras; i++) {
            ans += (palavras[i] + " - " + palavras[i].length());
            if (i < n_palavras-1) {ans += "\n";}
        }
        System.out.println(ans);
    }

    //Método que cria uma subpalavra do tabuleiro
    private String create_substring(int y, int x, int t, int direction) {
        String s = "";
        //direction = 0 - horizontal .... direction = 1 - vertical
        if (direction == 0) {
            for (int i = 0; i < t; i++) {
                s += data[y][x+i];
            }
        } else if (direction == 1) {
            for (int j = 0; j < t; j++) {
                s += data[y+j][x];
            }
        }
        return s;
    }

    //Método que verifica se a palavra está no tabuleiro dentro dos limites
    private void check_horizontal(int y, int x, int t, int i) {
        int inc = t-1; //incremento para obter o tamanho da palavra a procurar
        if (x + inc < cols) {
            String s = create_substring(y, x, t, 0);
            
            if (s.equals(palavras[i])) {
                save_answers(y, x, t, 0);
                //System.out.println("H - Encontrou - " + palavras[i] + " em y = "+y+" e x = "+x);
            }
        }
    }

    //Método que verifica se a palavra está no tabuleiro dentro dos limites
    private void check_vertical(int y, int x, int t, int i) {
        int inc = t-1; //incremento para obter o tamanho da palavra a procurar
        if (y + inc < lins) {
            String s = create_substring(y, x, t, 1);
            
            if (s.equals(palavras[i])) {
                save_answers(y, x, t, 1);
                //System.out.println("V - Encontrou - " + palavras[i] + " em y = "+y+" e x = "+x);
            }
        } 
    }

    //Método que limpa a matriz para guardar as letras que ficam e saem
    private void create_answers() {
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = CLEAR;
            }
        }
    }

    //Método que indica numa matriz quais as letras que ficam e que saem
    //Se saem mantém o '0', se fica muda para '1'
    private void save_answers(int y, int x, int t, int direction) {
        //direction = 0 - horizontal .... direction = 1 - vertical
        if (direction == 0) {
            for (int i = 0; i < t; i++) {result[y][x+i] = KEEP;}
        } else if (direction == 1) {
            for (int j = 0; j < t; j++) {result[y+j][x] = KEEP;}
        }
    }

    private void update_board() {
        for (int i = 0; i < lins; i++) {
            for (int j = 0; j < cols; j++) {
                if (result[i][j] == CLEAR) {data[i][j] = EMPTY;}
            }
        }
    }

    //Método que procura as palavras no tabuleiro
    public void find_words() {
        int tamanho = 0;
        create_answers();    //colocar zeros na matriz
        for (int i = 0; i < n_palavras; i++) {
            tamanho = palavras[i].length();
            for (int y = 0; y < lins; y++) {
                for (int x = 0; x < cols; x++) {
                    check_horizontal(y, x, tamanho, i);
                    check_vertical(y, x, tamanho, i);
                }
            }
        }
        update_board();
    }

}

public class ed015 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int lins = stdin.nextInt();
        int cols = stdin.nextInt();
        int count_in = 1;

        while (lins != 0 && cols != 0) {
            // guardar o tabuleiro temporariamente
            char d[][] = new char[lins][cols];
            for (int i = 0; i < lins; i++) {d[i] = stdin.next().toCharArray();}
            
            int np = stdin.nextInt();
            SopaLetras sl = new SopaLetras(lins, cols, np*2);
            sl.read(d); //introduzir o tabuleiro
            sl.read_p(stdin); //introduzir palavras a procurar

            sl.find_words();
            //testes
            System.out.println("Input #" + count_in);
            sl.write();
            // System.out.println("Palavras:");
            // sl.write_p();


            count_in += 1;
            lins = stdin.nextInt();
            cols = stdin.nextInt();
        }

    }
} 