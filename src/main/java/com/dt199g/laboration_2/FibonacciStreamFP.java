package com.dt199g.laboration_2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The FibonacciStreamRX class implements three override methods of the FibonacciInterface interface
 * to generate and print the fibonacci values, the sum of the values and the sequence:value pair
 * using functional programming style.
 *
 * @author Honorine Lima
 */
public class FibonacciStreamFP implements FibonacciInterface {
    /**
     * {@inheritDoc}
     */
    @Override public void fibonacciVal(int limit) {
        System.out.println(
                Stream.iterate(new Pair(0, 1), pair -> new Pair(pair.second(), pair.first() + pair.second()))
                        .limit(limit)
                        .map(Pair::first)
                        .map(l->new StringBuilder().append(l))
                        .reduce(new StringBuilder(), (acc, s)->acc.append(", ").append(s))
                        .delete(0,2)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override public void fibonacciSum(int limit) {
        System.out.println(
                "Sum of " + limit + " sequential Fibonacci values: " + Stream.iterate(new Pair(0, 1), pair -> new Pair(pair.second(), pair.first() + pair.second()))
                        .limit(limit)
                        .map(Pair::first)
                        .mapToInt(Long::intValue)
                        .sum()
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override public void fibonacciSeqAndVal(int limit) {
        System.out.println(
                Stream.iterate(new int[]{0,0, 1}, val -> new int[]{val[0]+1, val[2], val[1] + val[2]})
                        .limit(limit)
                        .map(array -> new StringBuilder().append(array[0]).append(":").append(array[1]))
                        .reduce(new StringBuilder(), (acc, s)->acc.append(" | ").append(s))
                        .delete(0, 3)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override public String getType() {
        return "FUNCTIONAL";
    }
}
