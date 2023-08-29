package com.msd.msd.java_se_revision;

public interface InterfaceC extends InterfaceA,InterfaceB {
    void show(int a);

  default  void show1(int a){
      System.out.println("default method");
  };

}
