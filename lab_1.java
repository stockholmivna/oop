import java.math.BigDecimal; 
import java.text.DecimalFormat;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;

public class lab_1 {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>(Arrays.asList(10.0, 20.5, 30.0, 40.7, 50.0, 60.3, 70.0, 80.1, 90.0, 100.9)); //create an array list
        
        byte byte1 = 55;
        Short short1 = -123;
        int int1 = 32;
        long long1 = -543789;
        float  float1 = 35e3f;
        double double1 = 321.2;
        
        numbers.add(byte1);
        numbers.add(short1);
        numbers.add(int1);
        numbers.add(long1);
        numbers.add(float1);
        numbers.add(double1);
        
        System.out.println("List of numbers: " + numbers); //list of all numbers
        
        List<Integer> integerNumbers = new ArrayList<>(); //a new array list to store integers
        List<String> floatNumbers = new ArrayList<>(); //a new array list to store formatted string numbers
        

        DecimalFormat df = new DecimalFormat("#.00"); //pattern to format numbers to two decimal places

        for (Number number : numbers) {
            integerNumbers.add(number.intValue());
            floatNumbers.add(df.format(number.doubleValue()));
        }

        System.out.println("List of integers: " + integerNumbers);
        System.out.println("List of numbers with two decimal places: " + floatNumbers);

        double sum = 0;

        for (Number number : numbers) {
            if (number.doubleValue() > 50) { //check if the number is greater than 50
                sum += number.doubleValue();
            }
        }
        
        System.out.println("Sum of numbers greater than 50: " + sum);
    }
}