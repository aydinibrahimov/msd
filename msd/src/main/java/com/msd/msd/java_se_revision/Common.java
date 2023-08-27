package com.msd.msd.java_se_revision;

import java.io.*;

public class Common implements InterfaceB {
    public static void main(String[] args) {

        try {
            FileInputStream f=new FileInputStream("dgdfgf");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("done");
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
