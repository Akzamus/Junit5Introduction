package org.example.JUnit5;

public class PersonValidator {
    public static boolean validateFirstName(Person person) {
        String name = person.getFirstName();
        if(name.isEmpty()) return false;
        for (char ch : name.toCharArray())
            if (!Character.isLetter(ch)) return false;
        return true;
    }
}
