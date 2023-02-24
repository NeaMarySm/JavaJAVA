
//     1 Создать новый список, добавить несколько строк с названиями цветов и вывести коллекцию на экран.
//     2 Итерация всех элементов списка цветов и добавления к каждому символа '!'.
//     3 Вставить элемент в список в первой позиции.
//     4 Извлечь элемент (по указанному индексу) из заданного списка.
//     5 Обновить определенный элемент списка по заданному индексу.
//     6 Удалить третий элемент из списка.
//     7 Поиска элемента в списке по строке.
//     8 Создать новый список и добавить в него несколько елементов первого списка.
//     9 Удалить из первого списка все элементы отсутствующие во втором списке.
//     10 *Сортировка списка.
//     11 *Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.
//

import java.util.ArrayList;
import java.util.LinkedList;

public class S3 {

    public static void main(String[] args) {
        //  --1--
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("yellow");
        colors.add("white");
        //  --2--
        for (int i = 0; i < colors.size(); i++) {
            colors.set(i, (colors.get(i) + '!'));
        }
        System.out.println(colors);
        //  --3--
        colors.add(0, "black");
        System.out.println(colors);
        // --4--
        String currentColor = colors.get(3);
        System.out.println(currentColor);
        //  --5--
        colors.set(1, "purple");
        System.out.println(colors);
        //  --6--
        colors.remove(2);
        System.out.println(colors);
        //  --7--
        int whiteIdx = colors.indexOf("white!");
        System.out.println("Index of white: " + whiteIdx + "\n");
        //  --8--
        ArrayList<String> newColors = new ArrayList<>();
        newColors.add(colors.get(2));
        newColors.add(colors.get(4));
        newColors.add(colors.get(0));
        System.out.println(newColors);
        //  --9--
//        colors.retainAll(newColors);
        System.out.println(colors);
        //  --10--
        colors.sort(String::compareToIgnoreCase);
        System.out.println(colors);
        //  --11--
        compareExecutionTime(100000);
        // 1000 - linked:1; array:1
        // 10000 - linked:3; array:16
        // 100000 - linked: 9; array:1042
    }

    public static void compareExecutionTime(int operations) {
        ArrayList<String> arrayColors = new ArrayList<>();
        LinkedList<String> linkedColors = new LinkedList<>();
        long begin1 = System.currentTimeMillis();
        int i = 0;
        while (i <= operations) {
            arrayColors.add(0, "black");
            i++;
        }
        long end1 = System.currentTimeMillis();
        i = 0;
        long begin2 = System.currentTimeMillis();
        while (i <= operations) {
            linkedColors.add(0, "white");
            i++;
        }
        long end2 = System.currentTimeMillis();

        System.out.printf("%s time: %d\n", "ArrayList", end1 - begin1);
        System.out.printf("%s time: %d\n", "LinkedList", end2 - begin2);
    }

}
