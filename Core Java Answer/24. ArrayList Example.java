import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        
        System.out.println("Enter student names (type 'done' to finish):");
        
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            names.add(name);
        }
        
        System.out.println("Student names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}