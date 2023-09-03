package com.msd.msd.java_se_revision;

public class Singleton {
    private Singleton() {
        System.out.println("Object created");

    }

    private static Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class){
            singleton = new Singleton();
        }}else{
            System.out.println("Instance of Singleton already exists");
        }
        return singleton;
    }
}
