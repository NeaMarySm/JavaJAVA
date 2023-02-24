import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class S3_ArrList {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("yellowness");
        colors.add("white");
        colors.add("cian");
        colors.add("purple");

//        ArrayList<String> reversed = new ArrayList<>();
//        for (String el : colors) {
//            reversed.add(0, el);
//        }
//        System.out.println(reversed);
//        ArrayList<String> reversed2 = new ArrayList<>();
//        System.out.println(colors);
//        ListIterator<String> iterator = colors.listIterator(colors.size());
//        while (iterator.hasPrevious()) reversed2.add(iterator.previous());
//        System.out.println(reversed2);

        int avg = countAvgLength(colors);
        System.out.println(avg);
//        deleteShort(avg,colors);
        ArrayList<String> newColors = createShortArray(avg, colors);
        System.out.println(colors);
        System.out.println(newColors);
        colors.removeAll(newColors);
        System.out.println(colors);
    }

    public static int countAvgLength(List<String> data) {
        int sum = 0;
        for (String el : data) {
            sum += el.length();
        }
        return sum / data.size();
    }

    public static void deleteShort(int minLen, ArrayList<String> data) {
        ListIterator<String> iterator = data.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().length() < minLen) {
                iterator.remove();
            }
        }
    }

    public static ArrayList<String> createShortArray(int minLen, ArrayList<String> data) {
        ArrayList<String> result = new ArrayList<>();
        for (String el : data) {
            if (el.length() >= minLen) {
                result.add(el);
            }
        }
        return result;
    }
}
