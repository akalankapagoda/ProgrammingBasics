package com.dagger.programming.basics.general;

/**
 * Calculate square root of a given number to the given max error.
 */
public class Sqrt {

    public static void main(String[] args) {

        System.out.println(sqrt(0.04, 0.001));
    }

    /**
     * Guess a value, at the beginning it's the sqrt value itself.
     * Check if the guessed value multiplied by itself is the x value or closer to it less than the error rate.
     * If it is, then return the guessed value.
     *
     * If not, if it's greater than x, reduce it by half between the currently guessed minvalue and the guessed value.
     * Mark the currently guessed value as the ceil for guessed values.
     *
     * IF it's less than x, increase it by half between the length of currently guessed max value and 0.
     * Mark the currently guessed value as the floor for guessed value.
     *
     * Loop until the error is less than expected.
     *
     * @param x Squared value which we need to find the square root of.
     *          Expects this to be greater than 0 (x > 0)
     * @param err The max error
     * @return Square root guessed to less than the max error provided
     */
    public static double sqrt(double x, double err) {

        double sqrt = x; // Initialize with current value
        double maxValue = sqrt;
        double minValue = 0;

        if (x < 1) {
            maxValue = 1;
            minValue = sqrt;
        }

        while (true) {

            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            double calculatedValue = sqrt * sqrt;

            System.out.println("sqrt : " + sqrt + " calc : " + calculatedValue +
                        " minVal : " + minValue + " maxVal : " + maxValue);

            if (Math.abs(calculatedValue - x) > err) { // recalculate
                if (calculatedValue > x) {
                    maxValue = sqrt;
                    sqrt = (sqrt + minValue) / 2;
                } else {
                    minValue = sqrt;
                    sqrt = (minValue + maxValue) / 2;
                }
            } else {
                return sqrt;
            }
        }
    }
}
