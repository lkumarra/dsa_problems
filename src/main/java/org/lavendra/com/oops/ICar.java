package org.lavendra.com.oops;

public interface ICar {

    static void staticMethod(){
        System.out.println("This is a static method in interface");
    }

     default void defaultMethod(){
         System.out.println("Default Method");
    }

    public void carName(String carName);

}
