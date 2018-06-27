package com.sunrain.tip35;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {
    @ExceptionTest2(value = ArithmeticException.class)
    public static void m1(){ //Test should pass
        int i =0;
        i = i/i;
    }
    @ExceptionTest2(value = ArithmeticException.class)
    public static  void  m2(){  //fail(wrong exception)
        int[] a = new int[0];
        int i = a[1];
    }
    @ExceptionTest2(value = ArithmeticException.class)
    public static void m3(){}   //fail

    @ExceptionTest2(value = {IndexOutOfBoundsException.class,
            NullPointerException.class})
    public static void doublyBad(){   //Test should pass
        List<String> list = new ArrayList<String>();
        list.addAll(5,null);
    }
}
