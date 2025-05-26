import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        
        double[] numbers = new double[n];
        double sum = 0;
        
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
            sum += numbers[i];
        }
        
        double average = sum / n;
        
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}