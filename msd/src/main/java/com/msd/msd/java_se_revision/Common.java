package com.msd.msd.java_se_revision;

import java.io.*;

public class Common implements InterfaceB {
    public static void main(String[] args) {

        myMethod();
    }
    public static void myMethod() {
        System.out.println("myMethod");
        myMethod();
    }

    @Override
    public void show(int a) {

    }

    @Override
    public void show1(int a) {

    }

    @Override
    public void show() {

    }
}
