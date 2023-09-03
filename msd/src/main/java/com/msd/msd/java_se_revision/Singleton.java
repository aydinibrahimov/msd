package com.msd.msd.java_se_revision;

public class Singleton {
    private Singleton() {

    }

    public static Singleton singleton;

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class){
            singleton = new Singleton();
        }}
        return singleton;
    }
}
