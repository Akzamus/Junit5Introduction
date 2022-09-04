package org.example.JUnit5;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;

import static org.junit.Assert.assertEquals;

class RepetitionInfoDemo {

    @RepeatedTest(3)
    void testWithRepetitionInfo(RepetitionInfo repetitionInfo, TestReporter testReporter) {
        testReporter.publishEntry("Repetition number: " + repetitionInfo.getCurrentRepetition());
        assertEquals(3, repetitionInfo.getTotalRepetitions());
    }
}
