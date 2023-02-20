//        Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
//        Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
//        *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
//        Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
//        Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
//        Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
//        *Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.


import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {

        isSubstring(); //1
        checkRotation(); //2
        getReverseString(); //3
        printEq(); //4
        replaceOperations(); //5,6
        replaceComparison(100000); //7
    }

    public static String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }

    public static void isSubstring() {
        System.out.println("\nПоиск подстроки");
        String first = getString("Введите строку: ");
        String second = getString("Введите искомую подстроку: ");
        int index = subStringStart(first, second);
        if (index == -1) System.out.printf("Исходная строка не содежит %s ", second);
        else System.out.printf("Искомая подстрока начинается позиции %d ", index + 1);
    }

    public static int subStringStart(String str, String subst) {
        StringBuilder str1 = new StringBuilder(str);
        return str1.indexOf(subst);
    }

    public static void checkRotation() {
        System.out.println("\nПроверка на вращение");
        String first = getString("Введите первую строку: ");
        String second = getString("Введите вторую строку: ");
        if (inRotation(first, second)) {
            System.out.println("Строки являются вращением друг друга");
        } else System.out.println("Строки не являются вращением друг друга");
    }

    public static boolean inRotation(String str1, String str2) {
        StringBuilder s1 = new StringBuilder(str1).append(str1);
        System.out.println(s1);
        if (s1.indexOf(str2) != -1 && str1.length() == str2.length()) return true;
        else return false;
    }

    public static void getReverseString() {
        System.out.println("\nПереворот строки");
        String initialString = getString("Введите начальную строку: ");
        StringBuilder sb = new StringBuilder(initialString);
        String result = reverseRecursive(sb).toString();
        System.out.println("Перевернутая строка: " + result);

    }

    public static StringBuilder reverseRecursive(StringBuilder str) {
        if (str.length() == 1) return new StringBuilder().append(str.charAt(0));
        return new StringBuilder().append(str.charAt(str.length() - 1))
                .append(reverseRecursive(str.deleteCharAt(str.length() - 1)));
    }

    public static void printEq() {
        System.out.println("\nСоставление выражений");
        String first = getString("Введите первое число: ");
        String second = getString(("Введите второе: "));
        char[] operators = {'+', '-', '*'};
        for (char item : operators) {
            System.out.println(makeEq(first, second, item));
        }
    }

    public static String makeEq(String str1, String str2, char operation) {
        StringBuilder resultString = new StringBuilder();
        int first = Integer.parseInt(str1);
        int second = Integer.parseInt(str2);
        int result = 0;
        switch (operation) {
            case '+':
                result = first + second;
                break;
            case '-':
                result = first - second;
                break;
            case '*':
                result = first * second;
                break;
            default:
                System.out.println("Неизвестная операция");
        }
        return resultString.append(first)
                .append(operation)
                .append(second)
                .append("=")
                .append(result)
                .toString();
    }

    public static void replaceComparison(int maxSymbols) {
        System.out.println("\nСравнение по времени метода replace у String и stringBuilder для " + maxSymbols + " знаков");
        StringBuilder initialString = new StringBuilder();
        int length = 0;
        while (length <= maxSymbols) {
            initialString.append("=");
            length++;
        }
        String targetString = initialString.toString();

        long begin1 = System.currentTimeMillis();
        targetString.replace("=", "равно");
        long end1 = System.currentTimeMillis();
        System.out.println("Время выполнения с использованием String: " + (end1 - begin1));

        long begin2 = System.currentTimeMillis();
        replaceUsingReplace(targetString, "=", "равно");
        long end2 = System.currentTimeMillis();
        System.out.println("Время выполнения с использованием StringBuilder: " + (end2 - begin2));
    }

    public static void replaceOperations() {
        System.out.println("\nОперации замены");
        String initialString = getString("Введите начальную строку: ");
        String targetSubstring = getString("Изменяемая подстрока: ");
        String newSubstring = getString("Новая подстрока: ");
        String result1 = replaceUsingInsert(initialString, targetSubstring, newSubstring);
        System.out.println("С использованием Insert: " + result1);
        String result2 = replaceUsingReplace(initialString, targetSubstring, newSubstring);
        System.out.println("C использованием Replace: " + result2);

    }

    public static String replaceUsingInsert(String input, String substring, String newString) {
        StringBuilder sb = new StringBuilder(input);
        int index = sb.indexOf(substring);
        if (index == -1) return input;
        sb.deleteCharAt(index);
        sb.insert(index, newString);
        return sb.toString();
    }

    public static String replaceUsingReplace(String input, String substring, String newString) {
        StringBuilder str1 = new StringBuilder(input);
        int start = str1.indexOf(substring);
        if (start == -1) return input;
        int end = start + substring.length();
        return str1.replace(start, end, newString).toString();
    }

}
