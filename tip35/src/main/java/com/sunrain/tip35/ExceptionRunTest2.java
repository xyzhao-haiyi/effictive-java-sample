package com.sunrain.tip35;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExceptionRunTest2 {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName("com.sunrain.tip35.Sample3");
        for(Method m:testClass.getDeclaredMethods()){
            if(m.isAnnotationPresent(ExceptionTest2.class)){
                tests++;
                try {
                    //parameter null means invoke static method
                    m.invoke(null);
                    System.out.printf("Test %s failed:no Exception %n",m);
                } catch (InvocationTargetException e) {
                    Throwable throwable = e.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation
                            (ExceptionTest2.class).value();
                    int oldPassed = passed;
                    for(Class<? extends Exception> excType:excTypes){
                        if(excType.isInstance(throwable)){
                            passed++;
                            break;
                        }
                    }
                    if(oldPassed==passed){
                        System.out.printf("Test %s failed: %s %n",m,throwable);
                    }
                }catch (Exception e) {
                    System.out.println("INVALID @Test: "+m);
                }

            }
        }
        System.out.printf("Passed:%d,Failed:%d %n",passed,tests-passed);
    }
}
