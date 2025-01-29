public class MathOperations{
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;
        System.out.println("Получилось: " + (num1 + num2));
        System.out.println("Получилось: " + (num1 - num2));
        System.out.println("Получилось: " + (num1 * num2));
        System.out.println("Получилось: " + (num1 / num2));

        //1) применить несколько арифметических операций над int и double в одном выражении
        double aDouble = 1.5;
        System.out.println("Получилось: " + (num1 + num2 * aDouble));
        System.out.println("Получилось: " + ((num1 + num2) + (aDouble + aDouble)));

        //2) применить несколько логических операций ( < , >, >=, <= )
        System.out.println(aDouble < num2);
        System.out.println(aDouble <= 1.5);
        System.out.println(aDouble >= 0.5);
        System.out.println( (num1 / num2) > aDouble);

        //4) получить переполнение при арифметической операции
        int maxInt = Integer.MAX_VALUE; // 2147483647
        int minInt = Integer.MIN_VALUE; // -2147483648
        double maxDouble = Double.MAX_VALUE; // 2147483647
        double minDouble = -Double.MAX_VALUE; // -2147483648

        System.out.println(maxInt + 1);
        System.out.println(minInt - 1);
        System.out.println(maxDouble * 2);
        System.out.println(minDouble * 2);
    }
}
