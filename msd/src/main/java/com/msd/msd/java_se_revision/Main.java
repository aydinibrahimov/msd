package com.msd.msd.java_se_revision;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] array = {"13", "12", "kj", "tryg", "ytu", "oiuytrsdfxc"};
        String maximumValue = null;
        int a = array[0].compareTo(array[1]);
        Arrays.sort(array);
//        for (int i = 0; i < array.length; i++) {
//            if (a == 1) {
//                maximumValue = array[i];
//                array[i]=array[i+1];
//                array[i+1]=maximumValue;
//            }
//        }
        System.out.println(Arrays.toString(array));

    }


    public static void threeWayPartition(int[] A) {
        int start = 0, mid = 0;
        int pivot = 1;
        int end = A.length - 1;

        while (mid <= end) {
            if (A[mid] < pivot) {
                swap(A, start, mid);
                ++start;
                ++mid;
            } else if (A[mid] > pivot) {
                swap(A, mid, end);
                --end;
            } else {
                ++mid;
            }
        }
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }




    
}
