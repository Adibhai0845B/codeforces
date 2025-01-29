class Calculator {
    // Method Overloading: add method with different parameter lists
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }
    // Method to add datatype integers
    public double add(double a, int b) {
        return a + b ;
    }
    // Method to add two double numbers
    public double add(double a, double b) {
        return a + b;
    }
}
 class AdvancedCalculator extends Calculator {
    @Override
    public int add(int a, int b) {
        System.out.println("AdvancedCalculator's add method for two integers");
        return super.add(a, b); // calling superclass's add method
    }
}

public class aaa{
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Method Overloading - calling different versions of the add method
        System.out.println("Sum of two integers: " + calc.add(5, 10));
        System.out.println("Sum of three integers: " + calc.add(5, 10));
        System.out.println("Sum of two doubles: " + calc.add(5.5, 10.5));

        // Method Overriding - using the overridden add method
        AdvancedCalculator advCalc = new AdvancedCalculator();
        System.out.println("Sum of two integers using overridden method: " + advCalc.add(20, 30));
    }
}
