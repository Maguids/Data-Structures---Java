import java.util.Scanner;

public class ed244  {

    static int count_primes (int A, int B){
        boolean[] isPrime = new boolean[B + 1];
        
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= B; i++) {
            if(isPrime[i] == true) {
                for(int j = (i*i); j <= B; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int counter = 0;
        for (int i = A; i <= B; i++) {
            if(isPrime[i]==true) {
                counter += 1;
            }
        }
        return counter;
    }

   public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);

        int min = stdin.nextInt();
        int max = stdin.nextInt();

        int counter = count_primes(min, max);
        System.out.println(counter);
   }
}