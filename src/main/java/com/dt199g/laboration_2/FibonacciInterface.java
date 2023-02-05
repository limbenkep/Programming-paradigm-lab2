package com.dt199g.laboration_2;

/**
 * An interface which states needed methods of each Fibonacci class / approach.
 *
 * @author Erik Ström
 */
public interface FibonacciInterface {
    /**
     * The fibonacciVal method generates and prints the values of the first n elements of the Fibonacci sequence,
     * where n is given as a parameter.
     *
     * @param limit the number of elements of the Fibonacci sequence to be generated and printed.
     */
    void fibonacciVal(int limit);

    /**
     * The fibonacciSum method generates and prints the sum of the first n elements of the Fibonacci sequence,
     * where n is given as a parameter.
     *
     * @param limit the number of elements of the Fibonacci sequence to be generated and summed.
     */
    void fibonacciSum(int limit);

    /**
     * The fibonacciSeqAndVal method generates and prints the sequence index and value of the first n elements of
     * the Fibonacci sequence, where n is given as a parameter.
     *
     * @param limit the number of elements of the Fibonacci sequence to be generated and printed.
     */
    void fibonacciSeqAndVal(int limit);

    /**
     * Simple getter to retrieve type of Fibonacci approach.
     *
     * @return type of Fibonacci approach as string value.
     */
    String getType();
}
