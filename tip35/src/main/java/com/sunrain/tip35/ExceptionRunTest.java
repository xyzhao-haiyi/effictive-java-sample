package com.sunrain.tip35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExceptionRunTest {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName("com.sunrain.tip35.Sample2");
        for(Method m:testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(ExceptionTest.class)){
                tests++;
                try {
                    //parameter null means invoke static method
                    m.invoke(null);
                    System.out.printf("Test %s failed:no Exception %n",m);
                } catch (InvocationTargetException e) {
                    Throwable throwable = e.getCause();
                    Class<? extends Exception> excType = m.getAnnotation
                            (ExceptionTest.class).value();
                    if(excType.isInstance(throwable)){
                        passed++;
                    }else {
                        System.out.printf("Test %s failed:expected %s,got " +
                                "%s%n",m,excType.getName(),throwable);
                    }
                }catch (Exception e) {
                    System.out.println("INVALID @Test: "+m);
                }

            }
        }
        System.out.printf("Passed:%d,Failed:%d %n",passed,tests-passed);
    }
}
