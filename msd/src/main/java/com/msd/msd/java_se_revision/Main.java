package com.msd.msd.java_se_revision;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {

        char[] arr = String.valueOf(x).toCharArray();
        int n = arr.length;
        for(int i=0;i<n/2+1)

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target && i != j) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
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
