package com.msd.msd.java_se_revision;

import java.util.Stack;

public class Cava {

    public static void main(String[] args) {
        String expression = "(a+b) [{c[d]}";
        System.out.println(isBracketsClosed(expression)); // true


    }


    public static int hourglassSum(List<List<Integer>> arr) {
        int rows=arr.length;
        int columns=arr[0].length;
        int maxHourglassSum=Integer.MIN_VALUE;
        for(int i=0;i<rows-2;i++){
            for(int j=0;i<columns-2;j++){

                int  currentSum=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+
                        arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                maxHourglassSum=Math.max(maxHourglassSum,currentSum);
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
