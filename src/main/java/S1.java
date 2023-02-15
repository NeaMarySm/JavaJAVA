//Первый семинар.
//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        Пункты реализовать в методе main
//        *Пункты реализовать в разных методах
//
//        int i = new Random().nextInt(k); //это кидалка случайных чисел!)


import java.util.Random;

public class S1 {

    public static void main(String[] args) {
        int max = 2000;
        int i = new Random().nextInt(max + 1);
        System.out.println(i);

        int n = S1.findNumberOfHighestBit((i));
        System.out.println("Номер старшего бита, подсчет по исходному числу: " + n);

        String binary = Integer.toBinaryString(i);
        System.out.println("Двоичное представление числа: " + binary);

        int highestBit = Integer.highestOneBit(i);
        System.out.println("Старший бит:" + highestBit);
        System.out.println("Номер старшего бита: " + (binary.length() - 1));

        int[] m1 = S1.findMultiples(i, n);
        S1.printArray(m1);
        int[] m2 = S1.findNonMultiples(i, n);
        System.out.println();
        S1.printArray(m2);
    }

    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    static int[] findMultiples(int rand, int n) {
        int[] rangeShorts = new int[Short.MAX_VALUE - rand];
        int resultLength = 0;
        if (n == 0 || n == 1) {
            for (int i = 0; i < rangeShorts.length; i++) {
                rangeShorts[i] = rand++;
            }
            return rangeShorts;
        } else {
            for (int i = 0; i < rangeShorts.length; i++) {
                if (rand % n == 0) resultLength++;
                rangeShorts[i] = rand++;
            }
            int[] result = new int[resultLength];
            int index = 0;
            for (int num : rangeShorts) {
                if (num % n == 0) {
                    result[index] = num;
                    index++;
                }
            }
            return result;
        }
    }

    static int[] findNonMultiples(int rand, int n) {
        int[] rangeShorts = new int[-Short.MIN_VALUE + rand];
        int resultLength = 0;
        if (n == 0 || n == 1) {
            for (int i = 0; i < rangeShorts.length; i++) {
                rangeShorts[i] = rand++;
            }
            return rangeShorts;
        } else {
            for (int i = 0; i < rangeShorts.length; i++) {
                if (rand % n != 0) resultLength++;
                rangeShorts[i] = rand--;
            }
            int[] result = new int[resultLength];
            int index = 0;
            for (int num : rangeShorts) {
                if (num % n != 0) {
                    result[index] = num;
                    index++;
                }
            }
            return result;
        }
    }

    static int findNumberOfHighestBit(int number) {
        int count = 0;
        while (number != 1) {
            number /= 2;
            count++;
        }
        return count;
    }
}
