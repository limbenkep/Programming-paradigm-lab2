package com.dt199g.laboration_2;


import java.util.Arrays;

/**
 * Lab2 is the main class for executing the fibonacci sequence programs.
 * The program takes an optional command line argument for the number of elements to be calculated.
 * If no argument is provided, the default value is used. If the argument is not a valid integer, or is less than 1,
 * the default value will be used. The program then executes the fibonacci sequence for the number of elements
 * specified, for three different implementations: imperative, functional, and reactive.
 * The elapsed time for each implementation is displayed.
 *
 * NOTHING IN THIS CLASS MAY BE MODIFIED!
 *
 * @author Erik Ström
 */
public class Lab2 {
    /**
     * Main method for executing the fibonacci sequence programs.
     * @param args Command line argument for the number of elements to be calculated.
     */
    public static void main(String... args) {
        int limit = 10;
        if (args != null && args.length > 0) {
            try {
                limit = Integer.parseInt(args[0]);
                if (limit < 1)
                    limit = 20;
            } catch (NumberFormatException ignored) {
                // NumberFormatException is thrown when the argument cannot be parsed as an integer.
                // In this case, we ignore the exception and use the default value.
            }
        }

        // A string of dashes is used to visually separate the output for each implementation.
        String line = "---------------------";
        long startTime, nanoSeconds;

        // Execute the fibonacci sequence for each implementation.
        for (FibonacciInterface fib : Arrays.asList(new FibonacciImperative(), new FibonacciStreamFP(), new FibonacciStreamRX())) {
            startTime = System.nanoTime();

            // Display the name of the implementation.
            System.out.printf("%n%s %n%s SOLUTION %n%s%n", line, fib.getType(), line);

            // Run calculations.
            fib.fibonacciVal(limit);        // Only values for sequence (comma separated)
            fib.fibonacciSum(limit);        // Total sum of all values in sequence
            fib.fibonacciSeqAndVal(limit);  // Both sequence numbers and values (as 'seq:val' pairs)

            // Display the elapsed time for the implementation.
            nanoSeconds = System.nanoTime() - startTime;
            System.out.printf("Elapsed time: %,dns | %,dms%n", nanoSeconds, nanoSeconds / 1000000);
        }
    }
}
