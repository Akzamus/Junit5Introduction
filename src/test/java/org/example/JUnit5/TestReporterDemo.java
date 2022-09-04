package org.example.JUnit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import java.util.HashMap;
import java.util.Map;

class TestReporterDemo {

    @Test
    void keyValuePair(TestReporter testReporter) {
        testReporter.publishEntry("my key", "my value");
    }

    @Test
    void multipleKeyValuePair(TestReporter testReporter) {
        Map<String, String> values = new HashMap<>();
        values.put("name", "Kolya");
        values.put("handle", "Pikachu");
        testReporter.publishEntry(values);
    }
}
