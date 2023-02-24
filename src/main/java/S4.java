
// 1.Ввод с консоли в формате Ф.И.О Возраст пол
// 2.Выход из режима вода по горячей кнопке
// 3.Вывод несортированного списка в формате Иванов И.И. 32M
// 4.Два варианта продолжения, либо вывод списка сортированного по возрасту либо завершение приложения.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S4 {
    public static void main(String[] args) {
        String[] keyValues = new String[]{"Фамилия", "Имя", "Отчество", "Возраст", "Пол"};
        ArrayList<String> users = setUsers(keyValues);
        printFormatted(users);

        String sortKey = "s";
        String answer = getInput(String.format("Введите %s для вывода сортированного списка или любую другую клаившу для выхода: ", sortKey));
        if (answer.equalsIgnoreCase(sortKey)) {
            Collections.sort(users);
            printUsers(users, keyValues);
        }
    }

    public static String getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(message);
        return scanner.nextLine();
    }
    public static ArrayList<String> setUsers(String[] keyValues){
        String stopKey = "q";
        boolean inProgress = true;
        ArrayList<String> users = new ArrayList<>();
        while (inProgress) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < keyValues.length; i++) {
                String input = getInput(String.format("Введите %s или '%s' для завершения: ", keyValues[i], stopKey));
                if (input.equalsIgnoreCase(stopKey)) {
                    inProgress = false;
                    break;
                } else {
                    if (i != keyValues.length - 1) {
                        result.append(input.toLowerCase()).append(',');
                    } else result.append(input);
                }
            }
            if (!result.isEmpty())
                users.add(result.toString());
        }
        return users;
    }
    public static void printUsers(ArrayList<String> users, String[] features) {
        for (int j = 0; j < users.size(); j++) {
            System.out.println("User " + (j + 1));
            String[] user = users.get(j).split(",");
            for (int i = 0; i < user.length; i++) {
                String formatted = capitalizeFirst(user[i]);
                System.out.println(features[i] + ": " + formatted);
            }
        }
    }

    public static void printFormatted(ArrayList<String> users) {
        for (int j = 0; j < users.size(); j++) {
            System.out.println("User " + (j + 1));
            String[] user = users.get(j).split(",");
            StringBuilder formatted = new StringBuilder();
            for (int i = 0; i < user.length; i++) {
                if (i == 0) formatted.append(capitalizeFirst(user[i])).append(' ');
                if (i == 1 || i == 2) formatted.append(capitalizeFirst(user[i].substring(0, 1))).append('.');
                if (i == 3) formatted.append(' ').append(user[i]);
                if (i == 4) formatted.append(capitalizeFirst(user[i].substring(0, 1)));
            }
            System.out.println(formatted);
        }
    }

    public static String capitalizeFirst(String item) {
        if (!item.isEmpty()) {
            return item.substring(0, 1).toUpperCase() + item.substring(1);
        } else return item;
    }

}
