package com.sunrain.tip35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName("com.sunrain.tip35.Sample");
        for(Method m:testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(Test.class)){
                tests++;
                try {
                    //parameter null means invoke static method
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    System.out.println(m+" failed "+e.getCause());
                }catch (Exception e) {
                    System.out.println("INVALID @Test: "+m);
                }

            }
        }
        System.out.printf("Passed:%d,Failed:%d %n",passed,tests-passed);
    }
}
