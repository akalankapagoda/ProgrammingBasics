package com.dagger.programming.basics;

import java.util.Scanner;
import java.util.Stack;

class Main {

//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        long m = scan.nextLong();
//        long r = scan.nextLong();
//        long n = scan.nextLong();
//        long k = scan.nextLong();
//        long M = scan.nextLong();
//
//        System.out.println(solve(m, r, n, k, M));
//        scan.close();
//    }

    private static long solve(long m, long r, long n, long k, long M) {

        /*
        Another way
        Find all sums that could come - remainder of mod + modded base value*multiplier
        Now the numbers we should check should not be greater than the sum value,
        if sum is say x, we could compare indexes which are less than x
         */

        // Find r mod m, the sum of values should be a multiplication of this

        long mod = r % m;

        long noOfSets = 0;

        Stack<Long> indexStack = new Stack();
        Stack<Long> sumStack = new Stack();

        indexStack.push(1L);
        sumStack.push(1L);

        while (!indexStack.empty()) {

            long currentIndex = indexStack.peek();

            if (indexStack.size() < k) {
                long nextVal = currentIndex + 1;

                if (nextVal > n) { // Dead end, just clear the value
                    indexStack.pop();
                    sumStack.pop();

                    incrementLast(indexStack, sumStack);
                } else {

                    indexStack.push(nextVal);
                    sumStack.push(sumStack.peek() + nextVal);
                }
            } else if (indexStack.size() == k) {

                indexStack.pop(); // Just removing since we already got the value from peek
                long currentSum = sumStack.pop();

                if (currentIndex > n) { // Dead end
                    incrementLast(indexStack, sumStack);
                } else {

//                    System.out.println("Comparing sum : " + currentSum);
                    if (currentSum % m == mod) {
                        noOfSets++;
                        System.out.println("Found " + noOfSets + " currentSum : " + currentSum);
                        System.out.println(indexStack.toString());
                    }

                    indexStack.push(currentIndex + 1);
                    sumStack.push(currentSum + 1);
                }
            }
        }

        return (m * noOfSets) % M;
    }

    private static void incrementLast(Stack<Long> indexStack, Stack<Long> sumStack) {

        if (indexStack.isEmpty()) {
            return;
        }

        Long index = indexStack.pop() + 1;
        Long sum = sumStack.pop() + 1;

        indexStack.push(index);
        sumStack.push(sum);
    }

    public static void main(String[] args) {
        System.out.println(solve(20, 12, 20, 10, 243));
//        System.out.println(solve(6, 0, 40, 28, 1024));
//        System.out.println(solve(2, 1, 5, 3, -1));

        long t = 4l;

//        long[] kk = new long[t];
    }

}