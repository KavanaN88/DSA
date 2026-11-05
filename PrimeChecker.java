
import java.util.*;

class PrimeChecker {

    void checkPrime(int... numbers) {

        for (int num : numbers) {

            boolean isPrime = true;

            if (num < 2) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {

                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        PrimeChecker obj = new PrimeChecker();

        obj.checkPrime(2);
        obj.checkPrime(2, 1);
        obj.checkPrime(2, 1, 3);
        obj.checkPrime(2, 1, 3, 4, 5);
    }
}
