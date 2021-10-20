package com.dagger.programming.basics.sorting;

/**
 * Sorting strings.
 */
public class StringSort {

    public static void main(String[] args) {

        String[] words = {"abc", "aex", "aaa", "ab"};

        stringSort(words);
    }


    static class Node {
        int value;
        String word;

        // For now consider max chars as 3, should iterate and calc this for this to be accurate though
        private static final int MAX_CHARS = 3;

        Node (String word) {
            this.word = word;
            calcValue();
        }

        /**
         * This is the logic described below.
         */
        private void calcValue() {

            char[] chars = word.toCharArray();

            int startBaseValue = (int) 'a' - 1;
            int base = (int) 'z' - startBaseValue;
            int baseCounter = 1;
            int value = 0;

            for(int i = MAX_CHARS - 1; i >= 0; i--) {

                if (i < chars.length) {
                    value += ((int) chars[i]) * baseCounter + startBaseValue * baseCounter++;
                } else {
                    value += startBaseValue * baseCounter + startBaseValue * baseCounter++;
                }
            }

            this.value = value;

        }
    }

    /**
     * Create a number for each string going through the chars from end to start.
     *
     * For each n char in the above loop, add a base value of n*26 + int value of char * base value as the string value.
     *
     * Then sort these numeric values, the strings will have the same sort order.
     *
     * if we consider a - z to have 1 - 26
     *
     * if we consider a string with n chars..
     *
     * n'th char will then have a value between 1-26
     * n-1'th char will have a value between 26 + (1 - 26)
     * n-2'th char will have a value between 26*2 + (1 - 26) * 2
     * ...
     *
     * Likewise, we'll give the highest weight to the first character and lowest weight to the last character.
     * And the weights are choses 26 chars apart so that a value from nth char never falls in the range of n-1 char's value.
     *
     * Then we add all.
     *
     * Then we do quicksort of these calculated values with the respective string attached to each.
     *
     * What to do with strings with different lengths can be decided later, whether we forcefully add zzz to it or whether we forcefully add aaaaa to it
     * depending on what we decide, 'ab' will appear aither before of after 'aaa'
     *
     * @param words
     */
    private static void stringSort(String[] words) {


        Node[] nodes = new Node[words.length];

        for (int i =0; i < words.length; i++) {
            nodes[i] = new Node(words[i]);

            System.out.println(nodes[i].value);
        }

        quickSort(nodes);

    }

    private static void quickSort(Node[] data) {

        quickSort(data, 0, data.length-1);

        for (Node i : data) {
            System.out.print(i.word + " ");
        }

    }

    private static void quickSort(Node[] data, int start, int end) {

        if (start >= end || start < 0) {
            return;
        }

        int pivot = data[end].value;

        int forwardIdx = start;
        int backwardIdx = end - 1;



        while (forwardIdx <= backwardIdx) {

            if (data[forwardIdx].value > pivot) {

                while (backwardIdx > forwardIdx) {

                    if (data[backwardIdx].value < pivot) {

                        swap(data, forwardIdx, backwardIdx);
                    }

                    backwardIdx--;
                }
            }

            forwardIdx++;
        }

        forwardIdx--; // reduce last increment

        // swap pivot

        if (data[forwardIdx].value > pivot) {
            swap(data, forwardIdx, end);
        }

        // continue

        quickSort(data, start, forwardIdx);
        quickSort(data, forwardIdx + 1, end);

    }

    private static void swap(Node[] data, int indexX, int indexY) {
        Node temp = data[indexY];
        data[indexY] = data[indexX];
        data[indexX] = temp;
    }
}
