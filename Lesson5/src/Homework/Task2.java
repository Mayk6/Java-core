package Homework;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {

    public static void main(String[] args) {

        byte[] map = {2, 2, 3, 0, 1, 0, 1, 2, 3};

        int serializedMap = serializeMap(map);
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("map.dat"))) {
            outputStream.writeInt(serializedField);
            System.out.println("Write done.");
        } catch (IOException e) {
            System.out.println("Write error.");
            System.out.println(e.getMessage());
        }
    }

    private static int serializeMap(byte[] field) {
        if (field == null || field.length != 9) {
            throw new IllegalArgumentException("The array must have 9 elements.");
        }

        int serializedField = 0;
        for (int i = 0; i < field.length; i++) {
            if (field[i] < 0 || field[i] > 3) {
                throw new IllegalArgumentException("Each element must be between 0 and 3.");
            }
            serializedField |= (field[i] << (i * 2));
        }
        return serializedField;
    }
}
