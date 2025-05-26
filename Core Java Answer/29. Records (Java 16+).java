import java.util.List;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordDemo {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 25),
            new Person("Bob", 30),
            new Person("Charlie", 20)
        );
        
        System.out.println("People over 21:");
        people.stream()
            .filter(p -> p.age() > 21)
            .forEach(p -> System.out.println(p.name() + " (" + p.age() + ")"));
    }
}