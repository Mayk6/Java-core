package Decorator;

/**
 * Класс декоратор
 */
public class Decorator {

    /**
     * @param name Имя
     * @param age Возраст
     * @return Возвращяет строку "Your name: " + name + "Your age: " + age"
     */

    public static String decorate(String name, int age){
        return "Your name: " + name + ", Your age: " + age;
    }


}
