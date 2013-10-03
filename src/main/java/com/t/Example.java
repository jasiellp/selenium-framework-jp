package com.t;

import java.lang.reflect.Method;
import java.util.ArrayList;


public class Example {

    public void exampleMethodNoParam() {
        System.out.println("No params");
    }

    public void exampleMethodWithParam(ArrayList<String> valor) {
        System.out.println(valor.get(0));
    }

    public static void main(String[] args) throws Throwable {
        Example example = new Example();
        Method noParam = Example.class.getMethod("exampleMethodNoParam");
        Method stringParam = Example.class.getMethod("exampleMethodWithParam", ArrayList.class);
        noParam.invoke(example);
        
        ArrayList<String> valor = new  ArrayList<String>();
        valor.add("Jasiel");
        stringParam.invoke(example, valor);
       
    }
}