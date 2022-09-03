package org.example.JUnit5;

public class StringUtils {

    public String makeWithCapitalLetter(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String getGoogleURL() {
        return "www.google.com";
    }
}
