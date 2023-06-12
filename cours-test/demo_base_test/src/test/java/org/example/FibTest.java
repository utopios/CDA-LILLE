package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FibTest {
    private Fib fib;

    @Test
    void testGetFibSeriesShouldNotEmptyWhenRangeIs1() {
        fib = new Fib(1);
        int res = fib.getFibSeries().size();
        Assertions.assertTrue(res > 0);
    }
    @Test
    void testGetFibSeriesShouldBeListWith0WhenRangeIs1() {
        fib = new Fib(1);
        List res = fib.getFibSeries();
        Assertions.assertEquals(Arrays.asList(0), res);
    }

    @Test
    void testGetFibSeriesShouldContains3WhenRangeIs6() {
        fib = new Fib(6);
        List res = fib.getFibSeries();
        Assertions.assertTrue(res.contains(3));
    }

    @Test
    void testGetFibSeriesSizeShouldBe6WhenRangeIs6() {
        fib = new Fib(6);
        List res = fib.getFibSeries();
        Assertions.assertEquals(6, res.size());
    }

    @Test
    void testGetFibSeriesShouldNotContains4WhenRangeIs6() {
        fib = new Fib(6);
        List res = fib.getFibSeries();
        Assertions.assertFalse(res.contains(4));
    }

    @Test
    void testGetFibSeriesShouldContainsAllValuesWhenRangeIs6() {
        fib = new Fib(6);
        List res = fib.getFibSeries();
        Assertions.assertTrue(res.containsAll(Arrays.asList(1,1,0,2,3,5)));
    }

    @Test
    void testGetFibSeriesShouldContainsAllValuesSortedWhenRangeIs6() {
        fib = new Fib(6);
        List res = fib.getFibSeries();
        Assertions.assertEquals(Arrays.asList(0,1,1,2,3,5), res);
    }
 }
