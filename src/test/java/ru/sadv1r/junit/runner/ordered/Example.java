package ru.sadv1r.junit.runner.ordered;

import org.junit.Ignore;
import org.junit.Test;

@Ignore("Test class with ordered tests example")
public class Example {
    @Test
    @Order(1)
    public void needToBeFirst() {
        // Do nothing
    }

    @Test
    @Order(3)
    public void needToBeThird() {
        // Do nothing
    }

    @Test
    public void withoutOrder() {
        // Do nothing
    }

    @Test
    @Order(2)
    public void needToBeSecond() {
        // Do nothing
    }

    @Test
    public void withoutOrderPairOne() {
        // Do nothing
    }

    @Test
    public void withoutOrderPairTwo() {
        // Do nothing
    }

    @Test
    @Order(Integer.MAX_VALUE)
    public void needToBeAfterAll() {
        // Do nothing
    }

    @Test
    @Order(-1)
    public void needToBeBeforeFirst() {
        // Do nothing
    }

    @Test
    @Order(0)
    public void justZero() {
        // Do nothing
    }
}