package com.msd.msd.java_se_revision;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer > set=new TreeSet<>();
        set.add(1);
        set.add(0);


        set.forEach((sets)-> System.out.println(sets));
    }
}
