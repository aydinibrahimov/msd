package com.msd.msd.java_se_revision;

import java.util.Stack;

public class Cava {

    public static void main(String[] args) {
        String expression = "(a+b) [{c[d]}";
        System.out.println(isBracketsClosed(expression)); // true


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
