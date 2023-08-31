package com.msd.msd.java_se_revision;

import java.util.List;
import java.util.Stack;

public class Cava {

    public static void main(String[] args) {
        String expression = "(a+b) [{c[d]}";
        System.out.println(isBracketsClosed(expression)); // true


    }


    public static int hourglassSum(List<List<Integer>> arr) {
        int rows = arr.size();
        int columns = arr.get(0).size();
        int maxHourglassSum = Integer.MIN_VALUE;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < columns - 2; j++) {
                int currentSum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) +
                        arr.get(i + 1).get(j + 1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                maxHourglassSum = Math.max(maxHourglassSum, currentSum);
            }
        }
        return maxHourglassSum;
    }

    public static String isBracketsClosed(String brackets ) {
        Stack<String> stack = new Stack<>();
        stack.push(brackets);
        for(String  s:stack){
            System.out.println(s);
        }


        return "Bosh daxiletme";
    }


}
