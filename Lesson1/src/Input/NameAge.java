package Input;

import Decorator.Decorator;

import java.util.Scanner;

public class NameAge {

    /**
     * Запрашивает имя и возраст пользователя и
     * выводит строку с его именем и возрастом в консоль.
     */
    public static void getInfo(){
        String name = setData("Enter your name: ");
        int age = 0;
        try {
            age = Integer.parseInt(setData("Enter age: "));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println(Decorator.decorate(name, age));
    }

    /**
     * Метод запрашивает ввод из консоли.
     * Параметр text выводит строку перед вводом.
     * @param text
     * @return
     */
    public static String setData(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        String data = scanner.nextLine();
        return data;
    }

}
