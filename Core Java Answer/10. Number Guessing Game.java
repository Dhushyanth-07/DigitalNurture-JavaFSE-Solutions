import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int secretNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;
        
        System.out.println("Guess a number between 1 and 100");
        
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;
            
            if (guess < secretNumber) {
                System.out.println("Too low!");
            } else if (guess > secretNumber) {
                System.out.println("Too high!");
            }
        } while (guess != secretNumber);
        
        System.out.println("Congratulations! You guessed it in " + attempts + " attempts");
    }
}