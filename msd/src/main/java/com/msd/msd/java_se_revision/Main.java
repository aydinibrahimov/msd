package com.msd.msd.java_se_revision;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int d = 3;
        List<Integer> arr = new ArrayList<>();

        arr.addAll(Arrays.asList(1, 2, 3, 4, 5));
        int j = 0;
        if (d < arr.size()) {
            for (int i = d; i < arr.size(); i++) {

                int temp = arr.get(j);
                arr.add(j, arr.get(d));
                arr.add(d, temp);
                j++;
            }

        }
        System.out.println(arr);
    }


    public static boolean isParenthesesValid(String s) {

        Stack<Character> pr = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    pr.push(c);
                    break;
                case '{':
                    pr.push(c);
                    break;
                case '[':
                    pr.push(c);
                    break;
                case ')':
                    if (pr.empty() || pr.peek() != '(') return false;
                    else pr.pop();
                    break;
                case '}':
                    if (pr.empty() || pr.peek() != '{') return false;
                    else pr.pop();
                    break;
                case ']':
                    if (pr.empty() || pr.peek() != '[') return false;
                    else pr.pop();
                    break;
                default:
                    ;
            }
        }
        return pr.isEmpty();
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
