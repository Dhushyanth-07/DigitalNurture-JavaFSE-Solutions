public class TypeCasting {
    public static void main(String[] args) {
        double doubleValue = 9.87;
        int intValue = (int) doubleValue;
        System.out.println("double to int: " + intValue);
        
        int anotherInt = 123;
        double anotherDouble = (double) anotherInt;
        System.out.println("int to double: " + anotherDouble);
    }
}