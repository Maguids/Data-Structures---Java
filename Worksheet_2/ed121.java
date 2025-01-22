import java.util.Scanner;

public class ed121 {

    static String modificar(String s){
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isLetter(c) == false){
                s = s.substring(0,i) + s.substring(i+1);
                i -= 1;
            }
        }
        //System.out.printf("alterado - " + s);
        return s;
    }

    static void palindromo(String s){
        int counter = 0;
        int comp = s.length();
        //System.out.println("comp = "+comp);
        for (int j = 0; j < comp; j++){
            if(s.charAt(j) == s.charAt(comp - j - 1)){
                //System.out.println("sim - "+s.charAt(j)+(j)+" "+s.charAt(comp-j-1)+(comp-j-1));
                counter += 1;
            } else {
                //System.out.println("não - "+s.charAt(j)+(j)+" "+s.charAt(comp-j-1)+(comp-j-1));
            }
        }
        if(counter == s.length()){
            System.out.println("sim");
        } else {
            System.out.println("nao");
        }
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);

        int n = Integer.parseInt(stdin.nextLine());
        String[] frases = new String[n];
        for(int i = 0; i < n; i++){
            String s = stdin.nextLine().toLowerCase();
            s = modificar(s);
            frases[i] = s;
        }

        System.out.println(n);
        for(int k = 0; k<n; k++){
            if (frases[k].length() == 0){
                //System.out.println("Palavra " + k + " - " + frases[k]);
                System.out.println("nao");
            } else {
                //System.out.println("Palavra " + k + " - " + frases[k]);
                palindromo(frases[k]);
            }
        }
    }
}