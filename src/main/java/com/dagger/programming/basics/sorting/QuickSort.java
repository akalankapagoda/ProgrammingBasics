package com.dagger.programming.basics.sorting;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = {10, 80, 30, 90, 40, 50, 70};
        int[] array2 = {10, 30, 40, 50, 70, 80, 90};

        quickSort(array2);

        System.out.print("[");
        for(int i : array2) {
            System.out.print(i + ", ");
        }
        System.out.print("]");
    }

    public static void quickSort(int[] array) {
        sortPartition(array, 0, array.length - 1);
    }

    private static void sortPartition(int[] array, int start, int end) {

        if (start >= end || start > array.length - 1 || end > array.length - 1) {
            return;
        }

        int pivot = end;

        int swappingIndex = start - 1;

        for (int i = start; i < end; i++) {

            if (array[i] < array[pivot]) {
                swappingIndex++;

                swap(array, swappingIndex, i);
            }
        }

        swappingIndex++;
        swap(array, swappingIndex, pivot);

        sortPartition(array, start, swappingIndex - 1);
        sortPartition(array, swappingIndex + 1, end);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
