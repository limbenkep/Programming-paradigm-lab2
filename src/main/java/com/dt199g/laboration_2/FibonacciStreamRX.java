package com.dt199g.laboration_2;

import io.reactivex.rxjava3.core.Observable;


/**
 * The FibonacciStreamRX class implements three override methods of the FibonacciInterface interface
 * to generate and print the fibonacci values, the sum of the values and the sequence:value pair
 * using reactive programming style.
 *
 * @author Honorine Lima
 */
public class FibonacciStreamRX implements FibonacciInterface {
    /**
     * {@inheritDoc}
     */
    @Override public void fibonacciVal(int limit) {
        Observable.range(1,limit-1)
                //.repeat(limit)
                .scan(new Pair(0, 1), (accumulator, val) -> new Pair(accumulator.second(), accumulator.first()+accumulator.second()))
                .reduce(new StringBuilder(), (acc, s)->acc.append(", ").append(s.first()))
                .map(s->s.delete(0, 2))
                .subscribe(System.out::println);
    }

    /**
     * {@inheritDoc}
     */
    @Override public void fibonacciSum(int limit) {
        Observable.range(1,limit-1)
                //.repeat(limit)
                .scan(new Pair(0, 1), (accumulator, val) -> new Pair(accumulator.second(), accumulator.first()+accumulator.second()))
                .reduce(0L, (acc, pair) ->acc + pair.first())
                .subscribe(sum->System.out.printf("Sum of %d sequential Fibonnaci values: %,d%n", limit, sum));
    }

    /**
     * {@inheritDoc}
     */
    @Override public void fibonacciSeqAndVal(int limit) {
        Observable.range(1,1)
                .repeat(limit-1)
                .scan(new Pair(0, 1), (accumulator, val) -> new Pair(accumulator.second(), accumulator.first()+accumulator.second()))
                .map(Pair::first)
                .zipWith(Observable.range(0, limit), (x,y) -> y + ":" + x)
                .reduce(new StringBuilder(), (acc, s)->acc.append(" | ").append(s))
                .map(s->s.delete(0, 3))
                .subscribe(System.out::println);
    }

    /**
     * {@inheritDoc}
     */
    @Override public String getType() {
        return "REACTIVE";
    }
}
