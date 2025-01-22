import java.util.Arrays;

class BigNumber {
    private int n;
    private String[] numero;
    private int[] number;

    //construtor
    BigNumber(String x) {
        n = x.length();
        numero = new String[1000];
        for (int i = 0; i < n; i++) {numero[i] = String.valueOf(x.charAt(i));}
        number = new int[1000];
        Arrays.fill(number, 0);
        for (int j = n-1; j >= 0; j--) {number[n - j - 1] = Integer.parseInt(numero[j]);}
    }

    public int get_n() {return n;}
    public int[] get_number() {return number;}

    public void write() {
        System.out.println("n = " + n);
        String numero_r = "numero = {";
        String number_r = "number = {";
        for (int i = 0; i < n; i++) {
            numero_r += numero[i];
            if(i!=n-1) {numero_r += ",";}
            number_r += number[i];
            if(i!=n-1) {number_r += ",";}
        }
        numero_r += "}";
        number_r += "}";
        System.out.println(numero_r);
        System.out.println(number_r);
    }

    public String toString() {
        String ans = "";
        for(int i = n-1; i >= 0; i--) {
            ans += number[i];
        }
        return ans;
    }

    public boolean equals(BigNumber x) {
        if(n != x.get_n()) {return false;}
        int[] copy = x.get_number();
        for(int i = 0; i < n; i++) {
            if(number[i] != copy[i]) {return false;}
        }
        return true;
    }

    public BigNumber add(BigNumber x) {
        String resultado = "";
        int[] copy = x.get_number();
        int copy_n = x.get_n();
        int n_max;
        int soma;
        int resto;
        int proximo = 0;

        if(n >= copy_n) {n_max = n;} 
        else {n_max = copy_n;}

        for (int i = 0; i < n_max; i++) {
            soma = copy[i] + number[i] + proximo;
            resto = soma%10;
            proximo = soma/10;
            resultado += Integer.toString(resto);
        }
        if (proximo != 0) {resultado += Integer.toString(proximo);}

        String nova = "";
        for (int j = resultado.length()-1; j >= 0; j--){
            nova += resultado.charAt(j);
        }

        BigNumber ans = new BigNumber(nova);
        return ans;
    }

    public BigNumber multiply(BigNumber x) {
        String resultado = "";
        int[] copy = x.get_number();
        int copy_n = x.get_n();
        int n_max;
        int mult;
        int resto;
        int proximo = 0;

        if(n >= copy_n) {
            for (int i = 0; i < copy_n; i++) {
                
            }
        } 
        else {n_max = copy_n;}

        for (int i = 0; i < n_max; i++) {
            mult = copy[i] * number[i] + proximo;
            resto = mult%10;
            proximo = mult/10;
            resultado += Integer.toString(resto);
        }
        if (proximo != 0) {resultado += Integer.toString(proximo);}

        String nova = "";
        for (int j = resultado.length()-1; j >= 0; j--){
            nova += resultado.charAt(j);
        }

        BigNumber ans = new BigNumber(nova);
        return ans;
    }
} 