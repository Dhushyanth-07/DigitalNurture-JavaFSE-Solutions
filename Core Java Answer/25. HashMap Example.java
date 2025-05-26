import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();
        
        System.out.println("Enter student details (ID and Name):");
        
        while (true) {
            System.out.print("Enter ID (or 0 to exit): ");
            int id = scanner.nextInt();
            if (id == 0) break;
            
            scanner.nextLine(); // consume newline
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            students.put(id, name);
        }
        
        System.out.print("Enter ID to lookup: ");
        int lookupId = scanner.nextInt();
        System.out.println("Student name: " + students.get(lookupId));
    }
}