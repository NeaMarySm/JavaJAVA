import java.util.Scanner;

public class CompareStr {
    public static void main(String[] args) {
        String first = getString("Enter first string: ");
        String second = getString("Enter second string: ");
        String newsubstr = getString("Enter new substring: ");
        if (first.contains(second)) {
            long begin1 = System.currentTimeMillis();
            String result1 = first.replace(second, newsubstr);
            long end1 = System.currentTimeMillis();
            System.out.println(end1 - begin1);
            long begin2 = System.currentTimeMillis();
            String result = replaceSubst(first, second, newsubstr);
            long end2 = System.currentTimeMillis();
            System.out.println(end2 - begin2);
            System.out.println(result);
        } else System.out.println("No matches found");
    }

    public static String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine();
    }

    public static String replaceSubst(String str, String subst, String newSubst) {
        StringBuilder str1 = new StringBuilder(str);
        int start = str1.indexOf(subst);
        int end = start + subst.length();
        return str1.replace(start, end, newSubst).toString();
    }
}
