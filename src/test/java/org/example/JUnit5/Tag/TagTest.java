package org.example.JUnit5.Tag;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class TagTest {

    @Test
    @DisplayName("CaseA: prod & dev")
    @Tag("production")
    @Tag("development")
    void testCaseA() {}

    @Test
    @DisplayName("CaseB: prod")
    @Tag("production")
    void testCaseB() {}

    @Test
    @DisplayName("CaseC: dev")
    @Tag("development")
    void testCaseC() {}
}
