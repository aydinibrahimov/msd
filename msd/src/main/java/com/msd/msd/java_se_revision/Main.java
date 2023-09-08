package com.msd.msd.java_se_revision;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(isParenthesesValid("((([salam])))"));
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
                default: ;
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
