import java.util.Scanner;

public class ED202 {
    // Escrever todos as permutacoes do array v[]
    static void permutations(int v[], float[][] d) {
        boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
        int perm[] = new int[v.length];         // permutacao actual
        float resp = goPerm(0, v, used, perm, d); // chamar funcao recursiva
        System.out.println(Math.round(resp*100.0)/100.0);
    }
    
    // Acrescentamos a matriz d para ir buscar as distâncias
    static float goPerm(int cur, int v[], boolean used[], int perm[], float[][] d) {
        //vamos buscar apenas as que terminam em 0
        if (cur == v.length && perm[v.length-1] == 0) {  // Caso base: terminamos a permutacao
            float distancia = 0;
            for (int i=0; i<v.length; i++){ // Escrever a permutacao
                if (i == 0) {distancia += d[0][perm[i]];}
                else {distancia += d[perm[i-1]][perm[i]];}
            }
            return distancia;
        } else { // Se nao terminamos, continuar a gerar
            int control = 0;
            float min = 0;
            for (int i=0; i<v.length; i++){ // Tentar todos os elementos
                if (!used[i]) {
                    used[i] = true; 
                    perm[cur] = i;
                    float d1 = goPerm(cur+1, v, used, perm, d);
                    used[i] = false;
                    if(d1 != 0 && control != 1) {min = d1; control = 1;}
                    if(d1 != 0 && d1 < min) {min = d1;}
                }
            }
            return min;
        }
    }   

   // -----------------------------------------------------------
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] locais = new String[n];
        float[][] d = new float[n][n];

        //ir buscar os locais não serve de nada porque depois crio l_permuta em que os locais correspondem a numeros
        for(int k = 0; k < n; k++) {locais[k] = in.next();}
        //ir buscar as distâncias (isto não sofre permutações, serve para ir buscar os dados)
        for(int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {d[y][x] = in.nextFloat();}
        }

        //vamos fazer as permutações dos lugares e só depois ver as distâncias
        //queremos apenas as permutações que terminam em 0 (para voltar ao lugar de partida)
        int[] l_permuta = new int[n];
        for(int a = 0; a < n; a++) {l_permuta[a] = a;} //são bento - 0; camera - 1; clerigos - 2 ....
        permutations(l_permuta, d);
    }
}