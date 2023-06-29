package decorator;

/**
 * Class Decorator
 */
public class Decorator {

    /**
     * @param name Name
     * @param age Age
     * @return Returns the string "Your name: " + name + "Your age: " + age"
     */

    public static String decorate(String name, int age){
        return "Your name: " + name + ", Your age: " + age;
    }


}
