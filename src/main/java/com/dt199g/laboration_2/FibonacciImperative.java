package com.dt199g.laboration_2;

/**
 * The FibonacciImperative class implements three methods to generate and print different aspects of the
 * Fibonacci sequence. NOTHING IN THIS CLASS MAY BE MODIFIED!
 *
 * @author Erik Ström
 */
public class FibonacciImperative implements FibonacciInterface {
    /**
     * {@inheritDoc}
     */
    @Override public void fibonacciVal(int limit) {
        // Initialize an array to hold the first two values of the Fibonacci sequence
        long[] t = new long[]{0, 1};

        // Initialize a StringBuilder to hold the final string representation of the sequence and values
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < limit; i++) {
            // Append the current value of the Fibonacci sequence to the string builder
            sb.append(t[0]).append(", ");

            // Calculate the next value of the sequence
            long temp = t[0];
            t[0] = t[1];
            t[1] = temp + t[1];
        }

        // Print the generated values, excluding the last ", "
        System.out.println(sb.substring(0, sb.length() - 2));
    }

    /**
     * {@inheritDoc}
     */
    @Override public void fibonacciSum(int limit) {
        long first = 0, second = 1, sum = 0;

        for (int i = 0; i < limit; i++) {
            // Calculate the next value of the sequence
            long next = first + second;

            // Add the current value to the sum
            sum += first;

            // Shift the values of the sequence
            first = second;
            second = next;
        }

        // Print the sum of the generated values
        System.out.printf("Sum of %d sequental Fibonnaci values: %,d%n", limit, sum);
    }

    /**
     * {@inheritDoc}
     */
    @Override public void fibonacciSeqAndVal(int limit) {
        // Initialize an array to hold the first two values of the Fibonacci sequence
        long[] fib = new long[] {0, 1};

        // Initialize a StringBuilder to hold the final string representation of the sequence and values
        StringBuilder sb = new StringBuilder();

        // Loop through the number of elements specified by the input
        for (int i = 0; i < limit; i++) {
            // Store the current value of the sequence
            long current = fib[0];

            // Append the current index and value to the StringBuilder
            sb.append(i).append(":").append(current).append(" | ");

            // Calculate the next value in the sequence
            long next = fib[0] + fib[1];

            // Shift the values in the `fib` array for the next iteration
            fib[0] = fib[1];
            fib[1] = next;
        }

        // Output the final string representation of the sequence and values, excluding the last " | " separator
        System.out.println(sb.substring(0, sb.length() - 3));
    }

    /**
     * {@inheritDoc}
     */
    @Override public String getType() {
        return "IMPERATIVE";
    }
}
