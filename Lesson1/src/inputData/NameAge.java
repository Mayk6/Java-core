package inputData;

import decorator.*;
import java.util.Scanner;

/**
 * Class for requesting name and age
 */
public class NameAge {

    /**
     * Requests the user's name and age and
     * prints a string with his name and age to the console.
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
     * The method asks for input from the console.
     * @param text outputs a string before input
     * @return Returns input from the console
     */
    public static String setData(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        String data = scanner.nextLine();
        return data;
    }

}
