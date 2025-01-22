import java.util.Scanner;

class Turtle {
    private char NORTE = 'N';    //norte
    private char SUL = 'S';    //sul
    private char ESTE = 'E';    //este
    private char OESTE = 'O';    //oeste
    private int direction;   //direção para a qual a tartaruga olha
    private int x, y;    // posição no tabuleiro
    private boolean penUp = false;   //a caneta não escreve
    private boolean penDown = true;  //a caneta escreve 
    private boolean pen;    //guarda a situação da caneta
    private char CLEAN = '.';    //board 'limpo'
    private char DRAWN = '*';    //board com desenho
    //private int x, y;   //posição da tartaruga
    private int rows, cols;    //tamanho do board
    private char[][] board;    //tabuleiro do jogo

    Turtle (int altura, int largura) {
        x = 0;
        y = 0;
        direction = ESTE;
        pen = penUp;
        rows = altura;
        cols = largura;
        board = new char[altura][largura];
    }

    public void print_coordinates() {
        System.out.println("("+y+","+x+")");
        System.out.println(direction);
    }

    //Preenche o board, pondo tudo a zeros (sem desenho)
    // Se tiver antes um 1 significa que tem desenho
    public void create_board() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = CLEAN;
            }
        }
    }

    public void change_pen_u() {
        pen = penUp;
    }

    public void change_pen_d() {
        pen = penDown;
        board[y][x] = DRAWN;
    }

    //pinta o tabuleiro    antigo x/y  novo x/y  marcador - marca o x ou o y para saber onde está
    private void update_board(int old_pos, int new_pos, int marker) {
        if (pen == penDown) {
            if (direction == SUL) {
                for (int i = old_pos; i <= new_pos; i++) {
                    board[i][marker] = DRAWN;
                }
            } else if (direction == NORTE) {
                for (int j = old_pos; j >= new_pos; j--) {
                    board[j][marker] = DRAWN;
                }
            } else if (direction == ESTE) {
                for (int k = old_pos; k <= new_pos; k++) {
                    board[marker][k] = DRAWN;
                }
            } else if (direction == OESTE) {
                for (int l = old_pos; l >= new_pos; l--) {
                    board[marker][l] = DRAWN;
                }
            }
        }
    }

    public void forward(int incremento) {
        int old_x = x;
        int old_y = y;
        int novo_x;
        int novo_y;
        if (direction == NORTE) {
            novo_y = y - incremento;
            if (novo_y < 0) {y = 0;}
            else {y = novo_y;}
            update_board(old_y, y, x);
        } else if (direction == SUL) {
            novo_y = y + incremento;
            if (novo_y >= rows) {y = rows-1;}
            else {y = novo_y;}
            update_board(old_y, y, x);
        } else if (direction == ESTE) {
            novo_x = x + incremento;
            if (novo_x >= cols) {x = cols-1;}
            else {x = novo_x;}
            update_board(old_x, x, y);
        } else if (direction == OESTE) {
            novo_x = x - incremento;
            if (novo_x < 0) {x = 0;}
            else {x = novo_x;}
            update_board(old_x, x, y);
        }
    }

    public void turn_right() {
        char[] d = {NORTE, ESTE, SUL, OESTE};
        for (int i = 0; i < 4; i++) {
            if (direction == d[i]) {
                int j = i+1;
                if (j == 4) {
                    direction = NORTE;
                    break;
                }
                else {
                    direction = d[j];
                    break;
                }
            }
        }  
    }

    public void turn_left() {
        char[] d = {NORTE, ESTE, SUL, OESTE};
        for (int i = 3; i >= 0; i--) {
            if (direction == d[i]) {
                int j = i-1;
                if (j == -1) {
                    direction = OESTE;
                    break;
                } else {
                    direction = d[j];
                    break;
                }
            }
        }  
    }

    public void flag0() {
        String ans = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == cols-1) {ans += board[i][j];}
                else {ans += board[i][j] + " ";}
            }
            if (i != rows - 1) {ans += "\n";}
        }
        System.out.println(ans);
    }

    private int count_drawn() {
        int counter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == DRAWN) {counter += 1;}
            }
        }
        return counter;
    }

    private boolean check_row(int r) {
        int counter = 0;
        boolean ans = false;
        for (int i = 0; i < cols; i++) {
            if (board[r][i] == CLEAN) {counter += 1;}
        }
        if (counter == cols) {ans = true;}
        return ans;
    }

    private boolean check_cols(int c) {
        int counter = 0;
        boolean ans = false;
        for (int i = 0; i < rows; i++) {
            if(board[i][c] == CLEAN) {counter += 1;}
        }
        if (counter == rows) {ans = true;}
        return ans;
    }

    public void flag1() {
        int counter = count_drawn();
        int counter_r = 0;
        int counter_c = 0;
        int total = rows * cols;
        int resposta = ((counter*100)/total);
        
        for (int i = 0; i < rows; i++) {
            if (check_row(i) == true) {counter_r += 1;}
        }
        for (int j = 0; j < cols; j++) {
            if (check_cols(j) == true) {counter_c += 1;}
        }

        System.out.println(resposta + " " + counter_r + " " + counter_c);  
    }

    private String create_substring(int i, int j, int inc_y, int inc_x) {
        String ans = "";
        for (int m = 0; m <= inc_y; m++) {
            String aux = "";
            for (int n = 0; n <= inc_x; n++) {
                aux += board[i+m][j+n];
            }
            ans += aux;
        }
        return ans;
    }

    public void flag2(String m, int row_m, int cols_m) {
        int incremento_y = row_m-1;
        int incremento_x = cols_m-1;
        String ans;
        boolean resposta = false;
        if (row_m <= rows && cols_m <= cols) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if ((i+incremento_y < rows) && (j+incremento_x < cols)) {
                        ans = create_substring(i, j, incremento_y, incremento_x);
                        if (ans.equals(m)) {
                            resposta = true;
                        }
                    }
                }
            }
        }
        if (resposta == true) {System.out.println("Sim");}
        else {System.out.println("Nao");}
    }

}

public class ed101 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int flag = stdin.nextInt();
        int linhas = stdin.nextInt();
        int colunas = stdin.nextInt();
        Turtle t = new Turtle(linhas, colunas);
        t.create_board();
        String input = stdin.next();
        String f_ = "end";

        while (!input.equals(f_)) {
            char code = input.charAt(0);
            if (code == 'U') {
                t.change_pen_u();
            } else if (code == 'D') {
                t.change_pen_d();
            } else if (code == 'F') {
                int inc = stdin.nextInt();
                t.forward(inc);
            } else if (code == 'L') {
                t.turn_left();
            } else if (code == 'R') {
                t.turn_right();
            }
            input = stdin.next();
        }

        int N = stdin.nextInt();
        int M = stdin.nextInt();
        String matrix = "";
        for (int i = 0; i < N*M; i++){
            matrix += stdin.next();
        }

        if (flag == 0) {
            t.flag0();
        } else if (flag == 1) {
            t.flag1();
        } else if (flag == 2) {
            t.flag2(matrix, N, M);
        }
    }
}