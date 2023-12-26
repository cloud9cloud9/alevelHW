package ua.nalezhytyi.hw20.task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("aboba", 123);
        Writer writer = new Writer();
        String filePath = "C:\\Users\\Vladick\\IdeaProjects\\alevelhomework\\src\\main\\" +
                "java\\ua\\nalezhytyi\\hw19\\some.json";
        try {
            writer.writeToJsonFile(person,filePath);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

        Reader reader = new Reader();
        try {
            Person objectsFromFile = reader.readFromJsonFile(filePath, Person.class);
            System.out.println(objectsFromFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
