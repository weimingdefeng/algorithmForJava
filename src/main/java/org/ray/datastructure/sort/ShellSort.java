package org.ray.datastructure.sort;

import java.util.Arrays;

/**
 * created by ray
 * Date: 25/02/2018
 * Time: 12:01
 */
public class ShellSort {

    private static <T extends Comparable<? super T>> void incrementalInsertionSort(T[] a, int first, int last,
                                                                                   int space) {
        int unsorted, index;

        for (unsorted = first + space; unsorted < last; unsorted = unsorted + space) {
            T firstUnsorted = a[unsorted];

            for (index = unsorted - space;
                 (index >= first) && (firstUnsorted.compareTo(a[index]) < 0); index = index - space) {
                a[index + space] = a[index];
            }
            a[index + space] = firstUnsorted;
        }
    }

    public static <T extends Comparable<? super T>> void shellSort(T[] a, int first, int last) {
        int n = last - first + 1;

        for (int space = n / 2; space > 0; space = space / 2) {
            for (int begin = first; begin < first + space; begin++) {
                incrementalInsertionSort(a, begin, last, space);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] array = { 9, 6, 2, 4, 8, 7, 5, 3 };

        System.out.println("before sort:" + Arrays.toString(array));
        shellSort(array, 0, array.length);
        System.out.println("after sort:" + Arrays.toString(array));

    }

}
