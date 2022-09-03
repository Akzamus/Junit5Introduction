package org.example.JUnit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private final StringUtils su = new StringUtils();

    @ParameterizedTest
    @CsvSource({"Almaty,almaty", "Astana,ASTANA", "Kazakhstan,KaZaKhStAn"})
    void makeWithCapitalLetter(String expected, String str) {
        assertEquals(expected, su.makeWithCapitalLetter(str));
    }

    @ParameterizedTest(name = "String = {0}, reversedString = {1}")
    @CsvSource({"ytamla,almaty", "eman,name", "dlroW,World"})
    void reverse(String expected, String str) {
        assertEquals(expected, su.reverse(str));
    }

    @Test
    void getGoogleURL() {
        final String actual = su.getGoogleURL();
        assertAll(
                () -> assertThat(actual, endsWith("com")),
                () -> assertThat(actual,isA(String.class)),
                () -> assertThat("They different!",actual, is("www.google.com"))
        );
    }
}