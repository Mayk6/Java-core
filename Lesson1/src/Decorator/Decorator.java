package Decorator;

/**
 * Класс декоратор
 */
public class Decorator {

    /**
     * Возвращяет строку "Your name: + name + Your age: + age"
     * на основе входящих данных.
     * @param name Имя
     * @param age Возраст
     * @return
     */

    public static String decorate(String name, int age){
        return "Your name: " + name + ", Your age: " + age;
    }


}
