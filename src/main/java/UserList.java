import java.util.*;

public class UserList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] keyValues = new String[]{"Фамилия", "Имя", "Отчество", "Возраст", "Пол"};
        String stopKey = "q";
        boolean inProgress = true;
        ArrayList<String> lastnames = new ArrayList<>();
        ArrayList<String> firstnames = new ArrayList<>();
        ArrayList<String> patronymic = new ArrayList<>();
        ArrayList<String> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        ArrayList<ArrayList<String>> dataBase = new ArrayList<>();
        dataBase.add(lastnames);
        dataBase.add(firstnames);
        dataBase.add(patronymic);
        dataBase.add(age);
        dataBase.add(gender);
        while (inProgress) {
            String input = getInput(sc, String.format("Новый пользователь. Введите %s или '%s' для завершения: ", keyValues[0], stopKey)).toLowerCase();
            if (input.equalsIgnoreCase(stopKey)) {
                inProgress = false;
            } else {
                dataBase.get(0).add(input);

                for (int i = 1; i < keyValues.length; i++) {
                    input = getInput(sc, String.format("Введите %s: ", keyValues[i])).toLowerCase();
                    dataBase.get(i).add(input);
                }
            }
        }
        String sortKey = "s";
        String answer = getInput(sc, String.format("Введите %s для вывода сортированного списка или любую другую клаившу для выхода: ", sortKey));
        if (answer.equalsIgnoreCase(sortKey)) {
            printSorted(dataBase);
        }
    }

    public static String getInput(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

//    public static void printFormatted(ArrayList<ArrayList<String>> users) {
//        for (int i = 0; i < users.get(0).size(); i++) {
//            StringBuilder formatted = new StringBuilder();
//            for (int j = 0; j < users.size(); j++) {
//                if (j == 0) formatted.append(capitalizeFirst(users.get(j).get(i))).append(' ');
//                if (j == 1 || j == 2)
//                    formatted.append(capitalizeFirst(users.get(j).get(i).substring(0, 1))).append('.');
//                if (j == 3) formatted.append(' ').append(users.get(j).get(i));
//                if (j == 4) formatted.append(capitalizeFirst(users.get(j).get(i).substring(0, 1)));
//            }
//            System.out.println(formatted);
//        }
//    }

    public static void printFormatted(ArrayList<ArrayList<String>> users, Integer[] order) {
        for (int k = 0; k < order.length; k++) {
            int i = order[k];
            StringBuilder formatted = new StringBuilder();
            for (int j = 0; j < users.size(); j++) {
                if (j == 0) formatted.append(capitalizeFirst(users.get(j).get(i))).append(' ');
                if (j == 1 || j == 2)
                    formatted.append(capitalizeFirst(users.get(j).get(i).substring(0, 1))).append('.');
                if (j == 3) formatted.append(' ').append(users.get(j).get(i));
                if (j == 4) formatted.append(capitalizeFirst(users.get(j).get(i).substring(0, 1)));
            }
            System.out.println(formatted);
        }
    }

    public static String capitalizeFirst(String item) {
        if (!item.isEmpty()) {
            return item.substring(0, 1).toUpperCase() + item.substring(1);
        } else return item;
    }

    public static void printSorted(ArrayList<ArrayList<String>> users) {
        ArrayList<String> ages = users.get(3);
        ArrayList<String> genders = users.get(4);
        int[] agesOrder = new int[ages.size()];
        for (int i = 0; i < agesOrder.length; i++) {
            agesOrder[i] = Integer.parseInt(ages.get(i));
        }
        bubble(agesOrder);
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int j = 0; j < agesOrder.length; j++) {
            indexes.add(-1);
            for (int k = 0; k < agesOrder.length; k++) {
                if (agesOrder[j] == Integer.parseInt(ages.get(k))) {
                    indexes.set(j, k);
                }
            }
        }
        sortGender(indexes, genders);
        Integer[] result = indexes.toArray(new Integer[0]);
        printFormatted(users, result);
    }

    public static void sortGender(ArrayList<Integer> order, ArrayList<String> genders) {
        int j = 0;
        for (int i = 0; i < genders.size(); i++) {
            if (!genders.get(order.get(j)).contains("м")) {
                order.add(order.get(j));
                order.remove(j);
            } else j++;
        }
    }

    public static void bubble(int[] array) {
        int count = array.length;
        while (count > 0) {
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            count--;
        }
    }
}
