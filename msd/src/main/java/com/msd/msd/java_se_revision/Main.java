package com.msd.msd.java_se_revision;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] array = {2,5,1,3,4,7};
        for (int a : shuffle(array,3)) {
            System.out.print(a + " ");
        }
    String s="";
        s.charAt(5);
        StringBuilder s=new StringBuilder();
        char c=s.charAt(2);
        if(c=='.'){

        }
    }
    public static int[] shuffle(int[] nums, int n) {
        int[] array=new int[2*n];
        for(int i=0;i<n;i=i+2){




        }
        return array;
    }
    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < 5; i++) {
            int k = nums[i];
            nums =mySwap(nums,i,k);

        }
        return nums;
    }

    public static int[] mySwap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
        return nums;
    }

    public static int finalValueAfterOperations(String[] operations) {


        int x = 0;
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "X++":
                    x++;
                    break;
                case "++X":
                    ++x;
                    break;
                case "X--":
                    x--;
                    break;
                case "--X":
                    --x;
                    break;
                default:
                    System.out.println("no operation");
                    break;
            }
        }
        return x;
    }


    public static int maxProfit(Integer[] prices) {
        List<Integer> ls = Stream.of(prices).collect(Collectors.toList());
        Arrays.sort(prices);
        int n = prices.length;
        System.out.println("gggg" + ls.indexOf(prices[n - 1]));
        for (int i = 0; i < n - 1; i++) {

        }


        int profit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = prices[j] - prices[i];
                if (k > profit)
                    profit = k;
            }
        }
        return profit;
    }


    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        if (x >= 0 && s.equals(String.valueOf(sb)))
            return true;
        return false;
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
