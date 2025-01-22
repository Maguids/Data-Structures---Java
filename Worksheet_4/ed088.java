import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char m[][];      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
	rows = r;
	cols = c;
	m = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz m[][]
    public void read(Scanner in) {
	for (int i = 0; i < rows; i++)
	    m[i] = in.next().toCharArray();
    }
    
    // Metodo para escrever a matriz m[][]
    public void write() {
        String ans = "";
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                ans += m[i][j];
            }
            if (i != rows - 1) {
            ans += "\n";
            }
        }
        System.out.println(ans);
    }

    //Metodo usado para contar os ALIVES das posições dos cantos
    private int countCorner(int y, int x, int incy, int incx) {
        int counter = 0;
        if (m[y+incy][x] == ALIVE) counter += 1;
        if (m[y+incy][x+incx] == ALIVE) counter += 1;
        if (m[y][x+incx] == ALIVE) counter += 1;
        return counter;
    }

    //Metodo usado para contar os ALIVES da border to tabuleiro, exceto cantos
    private int countBorder(int y, int x, int inc, int p) {
        int counter = 0;
        // p = 0 - superior/inferior ... p = 1 - esquerda/direita
        // inc = indica a "direção" da border, (ex: se p = 0 e o canto for o superior, então inc = 1, para contar a linha de baixo de onde está)
        if (p == 0) {
            if (m[y][x-1] == ALIVE) {counter += 1;}
            if (m[y][x+1] == ALIVE) {counter += 1;}
            for (int j = x-1; j <= x+1; j++) {
                if (m[y+inc][j] == ALIVE) {counter += 1;}
            }
        } else if (p == 1) {
            if (m[y-1][x] == ALIVE) {counter += 1;}
            if (m[y+1][x] == ALIVE) {counter += 1;}
            for (int i = y-1; i <= y+1; i++) {
                if (m[i][x+inc] == ALIVE) {counter += 1;}
            }
        }
        return counter;
    }

    //contor os ALIVES das posições do centro, ou seja, tudo menos as posições que formam a border e os cantos
    private int countMiddle(int y, int x) {
        int counter = 0;
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i == y && j == x) continue; // Ignore the current cell
                if (m[i][j] == ALIVE) {counter += 1;}
            }
        }
        return counter;
    }

    //função que conta os ALIVES caso o tabuleiro seja uma unica linha ou coluna ou então seja 1x1
    private int excessao(int y, int x) {
        int counter = 0;
        if (rows == 1 && cols == 1) {
            return 0;
        } else if (rows == 1) {
            if (x == 0 || x == cols - 1) {
                return 0;
            } else {
                if (m[y][x-1] == ALIVE) {counter += 1;}
                if (m[y][x+1] == ALIVE) {counter += 1;}
            }
        } else if (cols == 1) {
            if (y == 0 || y == rows -1) {
                return 0;
            } else {
                if (m[y-1][x] == ALIVE) {counter += 1;}
                if (m[y+1][x] == ALIVE) {counter += 1;}
            }
        }
        return counter;
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    int countAlive(int y, int x) {
        int count = 0;
        if (y == 0){
            if (x == 0) {
                count = countCorner(y, x, 1, 1);
            } else if (x == cols-1) {
                count = countCorner(y, x, 1, -1);
            } else {
                count = countBorder(y, x, 1, 0);
            }
        } else if (y == rows-1) {
            if (x == 0) {
                count = countCorner(y, x, -1, 1);
            } else if (x == cols-1) {
                count = countCorner(y, x, -1, -1);
            } else {
                count = countBorder(y, x, -1, 0);
            }
        } else if (x == 0 && (y > 0 && y < rows-1)) {
            count = countBorder(y, x, 1, 1);
        } else if (x == cols-1 && (y > 0 && y < rows-1)) {
            count = countBorder(y, x, -1, 1);
        } else if ((y > 0 && y < rows-1) && (x > 0 && x < cols-1)) {
            count = countMiddle(y, x);
        }
        return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
        char m2[][] = new char[rows][cols];
        int counter;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //determinar se é 'excessão'
                if (rows == 1 || cols == 1){
                    counter = excessao(i,j);
                } else {
                    counter = countAlive(i,j);
                }

                //Regras do jogo
                if (m[i][j] == ALIVE && (counter == 0 || counter == 1)) {
                    m2[i][j] = DEAD;
                } else if (m[i][j] == ALIVE && counter >= 4) {
                    m2[i][j] = DEAD;
                } else if (m[i][j] == ALIVE && (counter == 2 || counter == 3)) {
                    m2[i][j] = ALIVE;
                } else if (m[i][j] == DEAD && counter == 3) {
                    m2[i][j] = ALIVE;
                } else {
                    m2[i][j] = DEAD;
                }
            }
        }
        m = m2;
    }

}


// Classe principal com o main()
public class ed088 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ler linhas, colunas e numero de iteracoes
        int rows = in.nextInt();
        int cols = in.nextInt();
        int n = in.nextInt();

        // Criar objecto para conter o jogo e ler estado inicial
        Game g = new Game(rows, cols);
        g.read(in);

        for (int k = 0; k < n; k++) {
            g.iterate();
        }

        g.write();
    }
}