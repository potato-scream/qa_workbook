import java.util.List;

public class DataTypesAndOperands {

    public static void main(String... args) {
        // Целочисленные типы
        byte aByte = 0; // 8b   -128 + 127
        short aShort = 0; // 16b -32768 +32767
        int aInt = 0; // 32b   (-2^32) .. (+2^32 -1)
        Integer intWrapper = 0;
        long aLong = 0L; // 64b
        // Типы с плавающей точкой
        float aFloat = 0.0F;
        double aDouble = 0.0;
        Double doubleWrapper = 9.1;
        // Символьный
        char aChar = 'a';
        Character charWrapper = 'a';
        // Логически тип
        boolean aBoolean = true;
        Boolean booleanWrapper = true;
        // Строка (и бесконечность других объектных/ссылочных типов)
        String toBePrint = "Hello world!";
        List<Integer> teachers = List.of(10, 20);

        // Операторы
        // Оператор присвоения =
        String nameFirst = "Dmitrii";
        int age = 34;
        String nameSecond = "Dmitrii";
        // Арифметические операторы + - / * % ++ --
        int result = aInt;

        // Операторы сравнения <, >, >=, <=, !=, ==

        // Логические операторы &, |, &&, ||, !

//    System.out.println(!(nameFirst.equals("Dmitrii")));

        // Оператор instanceof

        System.out.println(nameFirst instanceof  String);

        // Тернарный оператор

        char sex = 'm';

        String childName = sex == 'm'
                ? "Valentin"
                : "Valentina";

        // Управляющая конструкция if

        if (sex == 'm') {
            childName = "Valentin";
        } else if (sex == 'w') {
            childName = "Valentina";
        } else {
            System.out.println("((");
        }

        // ключевое слово new

        String name = new String("Dima");

    }
}
